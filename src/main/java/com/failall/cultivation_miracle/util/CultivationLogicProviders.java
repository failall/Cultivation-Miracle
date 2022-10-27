package com.failall.cultivation_miracle.util;

import com.failall.cultivation_miracle.cultivation.CultivationStage;
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
    // (next realm = ID + 1)
    public static RegistryObject<CultivationStage> getStageRegistryObjFromRegistry(CultivationStage cultivationStage) {
        return RegistryCultivationStages.DEFERRED_CULTIVATION_STAGES.getEntries().stream().filter(
                c -> c.get().getStageRankingNumber() == cultivationStage.getStageRankingNumber() + 1
        ).findFirst().get();
    }

}
