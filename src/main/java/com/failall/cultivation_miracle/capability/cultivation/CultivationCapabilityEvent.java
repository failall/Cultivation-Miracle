package com.failall.cultivation_miracle.capability.cultivation;

import com.failall.cultivation_miracle.CultivationMiracle;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CultivationMiracle.MOD_ID)
public class CultivationCapabilityEvent {

    // Whenever a new object of some type is created the AttachCapabilitiesEvent will fire. In our case we want to know
    // when a new player arrives so that we can attach our capability here
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(CultivationProvider.PLAYER_QI).isPresent()) {
                // The player does not already have this capability so we need to add the capability provider here
                event.addCapability(new ResourceLocation(CultivationMiracle.MOD_ID, "cultivation"), new CultivationProvider());
            }
        }
    }

    // When a player dies or teleports from the end capabilities are cleared. Using the PlayerEvent.Clone event
    // we can detect this and copy our capability from the old player to the new one
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            // We need to copyFrom the capabilities
            event.getOriginal().getCapability(CultivationProvider.PLAYER_QI).ifPresent(oldStore -> {
                event.getOriginal().getCapability(CultivationProvider.PLAYER_QI).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    // Finally we need to register our capability in a RegisterCapabilitiesEvent
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(CultivationCapability.class);
    }

}
