package com.failall.cultivation_miracle.event;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.capability.cultivation.CultivationProvider;
import com.failall.cultivation_miracle.cultivation.CultivationRealm;
import com.failall.cultivation_miracle.cultivation.CultivationStage;
import com.failall.cultivation_miracle.registry.RegistryCultivationRealms;
import com.failall.cultivation_miracle.registry.RegistryCultivationStages;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.rmi.NoSuchObjectException;
import java.util.NoSuchElementException;

@Mod.EventBusSubscriber(modid = CultivationMiracle.MOD_ID)
public class CultivationCapEvents {

    // If player is cultivating --> increase things and handle reaching limits/etc.
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(CultivationProvider.PLAYER_QI).ifPresent(cultivator -> {
                // Check if threshold QI is reached --> handle rest
                // Stage section
                CultivationStage stage = RegistryCultivationStages.DEFERRED_CULTIVATION_STAGES.getEntries().stream().filter(
                        c -> c.getId() == cultivator.getCultivationStage()
                ).findFirst().get().orElseThrow(() -> new NoSuchElementException("This cultivation stage does not exist."));

                if (cultivator.getMaxQi() >= cultivator.getThresholdQi() && stage.getStageRankingNumber() <= 7) {
                    cultivator.rankUpStage();
                    cultivator.applyAttributeChangesFromStage();
                }


                // Realm section
                CultivationRealm realm = RegistryCultivationRealms.DEFERRED_CULTIVATION_REALMS.getEntries().stream().filter(
                        c -> c.getId() == cultivator.getCultivationRealm()
                ).findFirst().get().orElseThrow(() -> new NoSuchElementException("This cultivation realm does not exist."));

                // Cultivation check & calculation
                if (cultivator.getCultivationStatus()) {

                }
            });
        }
    }

}
