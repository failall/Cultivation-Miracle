package com.failall.cultivation_miracle.cultivation;

import java.util.HashMap;
import java.util.List;

public class CultivationStage {

    // Realm this belongs to, just for checking certain things (idk what yet)
    private final CultivationRealm realm;

    // 1 - 7 with 7 being the highest stage of a realm
    private final Integer stageRankingNumber;
    private final Integer maxQiToAdd;
    private final Integer thresholdQiToAdd;
    private final Integer cultivationSpeedToAdd;

    private HashMap<String, Double> playerAttr = new HashMap<>();

    public CultivationStage(CultivationRealm realm, Integer stageRankingNumber, Integer maxQiToAdd, Integer thresholdQiToAdd, Integer cultSpeedToAdd) {
        this.realm = realm;
        this.stageRankingNumber = stageRankingNumber;
        this.maxQiToAdd = maxQiToAdd;
        this.thresholdQiToAdd = thresholdQiToAdd;
        this.cultivationSpeedToAdd = cultSpeedToAdd;

        playerAttr.put("MAX_HP", 0d); // "MAX_HP"
        playerAttr.put("DAMAGE", 0d); // "DAMAGE"
        playerAttr.put("ARMOR", 0d); // "ARMOR"
        // More to follow TODO also see CultivationStage.java
    }

    public CultivationStage setPlayerAttr(String key, Double val) {
        if (this.playerAttr.containsKey(key)) {
            this.playerAttr.put(key, val);
            return this;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public Double getPlayerAttr(String key) {
        if (playerAttr.containsKey(key))
            return playerAttr.get(key);

        throw new ArrayIndexOutOfBoundsException();
    }

    public HashMap<String, Double> getPlayerAttrMap() {
        return playerAttr;
    }

    public Integer getStageRankingNumber() {
        return stageRankingNumber;
    }

    public Integer getMaxQiToAdd() {
        return maxQiToAdd;
    }

    public Integer getThresholdQiToAdd() {
        return thresholdQiToAdd;
    }

    public Integer getCultivationSpeedToAdd() {
        return cultivationSpeedToAdd;
    }

    public CultivationRealm getRealm() {
        return realm;
    }
}
