package com.failall.cultivation_miracle.capability.cultivation;

import net.minecraft.nbt.CompoundTag;

public class CultivationCapability {

    private int qi;
    private int maxQi;
    private int cultivationSpeed;
    private boolean isCultivating;

    public CultivationCapability(int maxQi, int cultivationSpeed) {
        this.maxQi = maxQi;
        this.cultivationSpeed = cultivationSpeed;
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
    
    public void setMaxQi(int maxQi) {
        this.maxQi = maxQi;
    }

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



    // REMEMBER if more capability features(e.g. cultivation realm/level) is added, add it to the copyFrom method
    public void copyFrom(CultivationCapability source) {
        this.qi = source.qi;
        this.maxQi = source.maxQi;
        this.cultivationSpeed = source.cultivationSpeed;
        this.isCultivating = source.isCultivating;
    }

    // see https://gist.github.com/TheCurle/6db954d680f6f067dcdc791355c32c89
    // dont forget to implement those 2 methods so data will be saved to disk
    
    public void serializeNBT(CompoundTag tag) {
        tag.putInt("total_qi", this.qi);
        tag.putInt("max_qi", this.maxQi);
        tag.putInt("cultivation_speed", this.cultivationSpeed);
        tag.putBoolean("isCultivating", this.isCultivating);
    }

    
    public void deserializeNBT(CompoundTag nbt) {
        this.qi = nbt.getInt("total_qi");
        this.maxQi = nbt.getInt("max_qi");
        this.cultivationSpeed = nbt.getInt("cultivation_speed");
        this.isCultivating = nbt.getBoolean("isCultivating");
    }
}
