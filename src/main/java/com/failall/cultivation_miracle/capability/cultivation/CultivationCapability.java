package com.failall.cultivation_miracle.capability.cultivation;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.cultivation.CultivationStage;
import com.failall.cultivation_miracle.registry.RegistryCultivationRealms;
import com.failall.cultivation_miracle.registry.RegistryCultivationStages;
import com.failall.cultivation_miracle.util.CultivationLogicProviders;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;

public class CultivationCapability {

    private int qi;
    private int maxQi;
    private int thresholdQi;
    private int maxQiFromCultivationStage;
    private int cultivationSpeed;
    private boolean isCultivating;

    private ResourceLocation cultivationRealm;
    private ResourceLocation cultivationStage;

    private HashMap<String,Double> playerAttr = new HashMap<>();

    public CultivationCapability(int maxQi, int cultivationSpeed, int thresholdQi) {
        this.qi = 0;
        this.maxQi = maxQi;
        this.cultivationSpeed = cultivationSpeed;
        this.thresholdQi = thresholdQi;
        this.cultivationRealm = RegistryCultivationRealms.PERCEPTION.getId();
        initPlayerBaseAttributes();
        //TODO add stage to constructor
        this.cultivationStage = RegistryCultivationStages.PERCEPTION_I.getId();
        this.cultivationRealm = RegistryCultivationRealms.ESTABLISHMENT.getId();
    }

    public ResourceLocation getCultivationRealm() {
        return cultivationRealm;
    }

    public ResourceLocation getCultivationStage() {
        return cultivationStage;
    }

    public int getCurrentQi() {
        return qi;
    }

    public void setCurrentQi(int qi) {
        this.qi = qi;
    }

    public void addCurrentQi(int qi) {
        //TODO replace cultivationSpeed with a formula
        this.qi = Math.min(cultivationSpeed, maxQi);
    }
    
    public int getMaxQi() {
        return maxQi;
    }

    // No Setter, cause when the hell would i ever want to set the maxQi to smth? What if i add maxQi through another process than lvl up, e.g.
    // cultivating, items, potions, etc.?
    public void addMaxQi(int maxQiToAdd) {
        this.maxQi += maxQiToAdd;
    }
    
    public int getCultivationSpeed() {
        return cultivationSpeed;
    }

    public void setCultivationSpeed(int cultivationSpeed) {
        this.cultivationSpeed = cultivationSpeed;
    }

    public void addCultivationSpeed(int cultivationSpeed) {
        this.cultivationSpeed += cultivationSpeed;
    }

    public boolean getCultivationStatus() {
        return this.isCultivating;
    }

    public void setCultivationStatus(boolean isCultivating) {
        this.isCultivating = isCultivating;
    }

    public void setPlayerAttr(String key, Double val) {
        if (playerAttr.containsKey(key)) {
            playerAttr.put(key, val);
            return;
        }

        throw new ArrayIndexOutOfBoundsException();
    }
    public Double getPlayerAttr(String key) {
        if (playerAttr.containsKey(key)) return playerAttr.get(key);

        throw new ArrayIndexOutOfBoundsException();
    }


    //TODO Perform this method on rank up to add max QI depending on cultivation stage
    public void setMaxQiFromCultivationStage(int maxQiFromCultivationStage) {
        this.maxQiFromCultivationStage = maxQiFromCultivationStage;
    }



    // REMEMBER if more capability features(e.g. cultivation realm/level) is added, add it to the copyFrom method
    public void copyFrom(CultivationCapability source) {
        this.qi = source.qi;
        this.maxQi = source.maxQi;
        this.cultivationSpeed = source.cultivationSpeed;
        this.isCultivating = source.isCultivating;
        this.maxQiFromCultivationStage = source.maxQiFromCultivationStage;
        this.cultivationRealm = source.cultivationRealm;
        this.playerAttr = source.playerAttr;
    }

    // see https://gist.github.com/TheCurle/6db954d680f6f067dcdc791355c32c89
    // don't forget to implement those 2 methods so data will be saved to disk
    
    public void serializeNBT(CompoundTag tag) {
        tag.putInt("total_qi", this.qi);
        tag.putInt("max_qi", this.maxQi);
        tag.putInt("cultivation_speed", this.cultivationSpeed);
        tag.putInt("threshold_qi", this.thresholdQi);
        tag.putBoolean("isCultivating", this.isCultivating);
        tag.putInt("maxQiFromCultivationStage", this.maxQiFromCultivationStage);
        tag.putString("cultivation_realm", this.cultivationRealm.getPath());
        tag.putString("cultivation_stage", this.cultivationStage.getPath());
        // Stats
        CompoundTag stats = new CompoundTag();
        for (var stat : this.playerAttr.keySet()) {
            stats.putDouble(stat, this.playerAttr.get(stat));
        }
        tag.put("playerStats", stats);
    }

    
    public void deserializeNBT(CompoundTag nbt) {
        this.qi = nbt.getInt("total_qi");
        this.maxQi = nbt.getInt("max_qi");
        this.cultivationSpeed = nbt.getInt("cultivation_speed");
        this.thresholdQi = nbt.getInt("threshold_qi");
        this.isCultivating = nbt.getBoolean("isCultivating");
        this.maxQiFromCultivationStage = nbt.getInt("maxQiFromCultivationStage");
        this.cultivationRealm = new ResourceLocation(CultivationMiracle.MOD_ID, nbt.getString("cultivation_realm"));
        this.cultivationStage = new ResourceLocation(CultivationMiracle.MOD_ID, nbt.getString("cultivation_stage"));
        // Stats
        CompoundTag stats = nbt.getCompound("playerStats");
        for (var stat : this.playerAttr.keySet()) {
            this.playerAttr.put(stat, stats.getDouble(stat));
        }
    }

    private void initPlayerBaseAttributes(){
        playerAttr.put("MAX_HP",1d); // "MAX_HP"
        playerAttr.put("DAMAGE",1d); // "DAMAGE"
        playerAttr.put("ARMOR",0d); // "ARMOR"
        // More to follow TODO also update this in CultivationStage.java
    }

    public void rankUpStage() {
        final CultivationStage currentStage = CultivationLogicProviders.getCultivationStageFromRegistry(this.cultivationStage);

        if (currentStage.getStageRankingNumber() == 7) {
            rankUpRealm();
            return;
        }

        RegistryObject<CultivationStage> newStage = CultivationLogicProviders.getStageRegistryObjFromRegistry(currentStage);

        this.cultivationStage = newStage.getId();
        this.maxQi += newStage.get().getMaxQiToAdd();
        this.thresholdQi += newStage.get().getThresholdQiToAdd();
        this.cultivationSpeed = newStage.get().getCultivationSpeedToAdd();
        this.qi = this.qi / 2;
    }

    public void rankUpRealm() {

    }

    public void applyAttributeChangesFromStage() {
        final CultivationStage stage = CultivationLogicProviders.getCultivationStageFromRegistry(this.cultivationStage);

        for (var statName : stage.getPlayerAttrMap().keySet()) {
            this.playerAttr.put(statName, this.playerAttr.get(statName) + stage.getPlayerAttr(statName));
        }
    }

    public void applyAttributeChangesFromItems() {

    }

    public int getThresholdQi() {
        return thresholdQi;
    }

    public void setThresholdQi(int thresholdQi) {
        this.thresholdQi = thresholdQi;
    }
}
