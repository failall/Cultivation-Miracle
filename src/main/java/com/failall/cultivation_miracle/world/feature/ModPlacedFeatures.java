package com.failall.cultivation_miracle.world.feature;

import com.failall.cultivation_miracle.CultivationMiracle;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, CultivationMiracle.MOD_ID);


    //Configure placement/rarity of the ore TODO configure stats of placement
    public static final RegistryObject<PlacedFeature> PRIMORDIAL_ORE_PLACED = PLACED_FEATURES.register("primordial_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PRIMORDIAL_ORE.getHolder().get(),
                    ModOrePlacement.commonOrePlacement(6, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }

}
