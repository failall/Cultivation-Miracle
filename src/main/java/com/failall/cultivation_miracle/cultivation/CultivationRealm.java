package com.failall.cultivation_miracle.cultivation;

public class CultivationRealm {

    private final String realmNameDisplay;
    private final Integer realmRankingNumber;

    private static Integer realmRankingCounter = 1;


    public CultivationRealm(String realmNameDisplay) {
        this.realmNameDisplay = realmNameDisplay;
        this.realmRankingNumber = realmRankingCounter;
        realmRankingCounter++;
    }

    public Integer getRealmRankingNumber() {
        return realmRankingNumber;
    }
}
