package com.failall.cultivation_miracle.event;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.capability.cultivation.CultivationProvider;
import com.failall.cultivation_miracle.cultivation.CultivationRealm;
import com.failall.cultivation_miracle.cultivation.CultivationStage;
import com.failall.cultivation_miracle.registry.RegistryCultivationRealms;
import com.failall.cultivation_miracle.registry.RegistryCultivationStages;
import com.failall.cultivation_miracle.util.CultivationLogicProviders;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.rmi.NoSuchObjectException;
import java.util.NoSuchElementException;

@Mod.EventBusSubscriber(modid = CultivationMiracle.MOD_ID)
public class CultivationCapEvents {

    private static int counter = 0;

    // If player is cultivating --> increase things and handle reaching limits/etc.
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(CultivationProvider.PLAYER_QI).ifPresent(cultivator -> {
                // Check if threshold QI is reached --> handle rest
                // Stage section
                CultivationStage stage = CultivationLogicProviders.getCultivationStageFromRegistry(cultivator.getCultivationStage());

                if (cultivator.getMaxQi() >= cultivator.getThresholdQi() && stage.getStageRankingNumber() < 7) {
                    cultivator.rankUpStage();
                    cultivator.applyAttributeChangesFromStage();
                }

                if (cultivator.getMaxQi() >= cultivator.getThresholdQi() && stage.getStageRankingNumber() == 7) {
                    cultivator.rankUpRealm(event.player);
                }

                // Cultivation check & calculation
                if (cultivator.getCultivationStatus()) {
                    // TODO Replace 60 with a public static value that can be changes to speed up cultivation
                    if (counter == 60 && cultivator.getCurrentQi() == cultivator.getMaxQi()) {
                        counter = 0;
                        cultivator.addMaxQi(1);
                    }
                    counter++;
                }
            });
        }
    }

}
