package com.failall.cultivation_miracle.datagen;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

@Mod.EventBusSubscriber(modid = CultivationMiracle.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        // QUICK & SIRTY Info: Instead of checking sides, this check is also possible:
        // generator.addProvider(event.includeServer() or event.includeClient(), provider);

        if (event.includeServer()) {
            generator.addProvider(true, new ModBlockStateProvider(generator, event.getExistingFileHelper()));
            generator.addProvider(true, new ModItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(true, new ModLanguageProvider(generator, "en_us"));
        }
        if (event.includeServer()) {
            // Loot tables are made by hand, since datagens are too complicated for that and I can't figure out some things

            ModBlockTags blocktags = new ModBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(true, blocktags);
            // Item tags need reference to block tags
            generator.addProvider(true, new ModItemTags(generator, blocktags, event.getExistingFileHelper()));

            // Configures Features -> https://forge.gemwire.uk/wiki/Datageneration/Datapack_Registries
            //addPlacedFeatureProvider(event, generator, "add_primordial_ore", ModPlacedFeatures.PRIMORDIAL_ORE_PLACED);


        }


    }

    private static void addPlacedFeatureProvider(GatherDataEvent event, DataGenerator generator, String rl_feature, RegistryObject<PlacedFeature> feature_name) {
        ResourceLocation placedFeatureRL = new ResourceLocation(CultivationMiracle.MOD_ID, rl_feature);
        Map<ResourceLocation, PlacedFeature> map = Map.of(placedFeatureRL, feature_name.get());

        generator.addProvider(true,
                JsonCodecProvider.forDatapackRegistry(
                generator,
                event.getExistingFileHelper(),
                CultivationMiracle.MOD_ID,
                RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.builtinCopy()),
                Registry.PLACED_FEATURE_REGISTRY,
                map
        ));
    }

}
