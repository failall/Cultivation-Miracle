package com.failall.cultivation_miracle.event;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.capability.cultivation.CultivationProvider;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CultivationMiracle.MOD_ID)
public class CultivationCapEvents {

    // If player is cultivating --> increase things and handle reaching limits/etc.
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(CultivationProvider.PLAYER_QI).ifPresent(cultivator -> {
                if(cultivator.getCultivationStatus()) {
                    
                }
            });
        }
    }

}
