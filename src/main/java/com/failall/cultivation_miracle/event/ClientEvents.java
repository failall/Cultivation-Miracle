package com.failall.cultivation_miracle.event;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.keys.KeyBinding;
import com.failall.cultivation_miracle.network.ModMessages;
import com.failall.cultivation_miracle.network.cultivation.CultivationC2SPacket;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ClientEvents {

    @Mod.EventBusSubscriber(modid = CultivationMiracle.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ClientEventsForge {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            // handle what happens when player is starting to cultivate
            if (KeyBinding.CULTIVATE_KEY.consumeClick()) {
                ModMessages.sendToServer(new CultivationC2SPacket());
            }
        }
    }

    // TODO INFO whether the bus has to be FORGE or MOD is determined from the event itstelf, look into the event class
    // and see which Interface(forge or mod) it implements

    @Mod.EventBusSubscriber(modid = CultivationMiracle.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientEventMods {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.CULTIVATE_KEY);
        }
    }

}
