package com.failall.cultivation_miracle.util;

import com.failall.cultivation_miracle.cultivation.CultivationRealm;
import com.failall.cultivation_miracle.cultivation.CultivationStage;
import com.failall.cultivation_miracle.registry.RegistryCultivationRealms;
import com.failall.cultivation_miracle.registry.RegistryCultivationStages;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;

public class CultivationLogicProviders {

    public static CultivationStage getCultivationStageFromRegistry(ResourceLocation resourceLocation) {
        return RegistryCultivationStages.DEFERRED_CULTIVATION_STAGES.getEntries().stream().filter(
                c -> c.getId() == resourceLocation
        ).findFirst().get().get();
    }

    // This methods returns the RegistryObject of the given cultivation stage parameter that has a 1 higher internal ID
    // (next stage = ID + 1)
    public static RegistryObject<CultivationStage> getNewStageRegistryObjFromRegistry(CultivationStage cultivationStage) {
        return RegistryCultivationStages.DEFERRED_CULTIVATION_STAGES.getEntries().stream().filter(
                c -> c.get().getStageRankingNumber() == cultivationStage.getStageRankingNumber() + 1
        ).filter(c -> c.get().getRealm().getRealmRankingNumber() ==
                getRealmRegistryObjFromRegistry(cultivationStage.getRealm()).get().getRealmRankingNumber()).findFirst().get();
    }

    public static RegistryObject<CultivationRealm> getNewRealmRegistryObjFromRegistry(CultivationRealm cultivationRealm) {
        return RegistryCultivationRealms.DEFERRED_CULTIVATION_REALMS.getEntries().stream().filter(
                c -> c.get().getRealmRankingNumber() == cultivationRealm.getRealmRankingNumber() + 1
        ).findFirst().get();
    }

    public static RegistryObject<CultivationRealm> getRealmRegistryObjFromRegistry(CultivationRealm cultivationRealm) {
        return RegistryCultivationRealms.DEFERRED_CULTIVATION_REALMS.getEntries().stream().filter(
                c -> c.get().getRealmRankingNumber() == cultivationRealm.getRealmRankingNumber()
        ).findFirst().get();
    }

    public static CultivationRealm getCultivationRealmFromRegistry(ResourceLocation resourceLocation) {
        return RegistryCultivationRealms.DEFERRED_CULTIVATION_REALMS.getEntries().stream().filter(
                c -> c.getId() == resourceLocation
        ).findFirst().get().get();
    }

}
