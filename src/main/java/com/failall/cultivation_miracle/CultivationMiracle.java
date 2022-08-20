package com.failall.cultivation_miracle;

import com.failall.cultivation_miracle.config.ModClientConfig;
import com.failall.cultivation_miracle.config.ModCommonConfig;
import com.failall.cultivation_miracle.network.ModMessages;
import com.failall.cultivation_miracle.registry.RegistryBlockEntities;
import com.failall.cultivation_miracle.registry.RegistryBlocks;
import com.failall.cultivation_miracle.registry.RegistryItems;
import com.failall.cultivation_miracle.world.feature.ModConfiguredFeatures;
import com.failall.cultivation_miracle.world.feature.ModPlacedFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CultivationMiracle.MOD_ID)
public class CultivationMiracle
{
    public static final String MOD_ID = "cultivation_miracle";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public CultivationMiracle()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RegistryBlocks.register(eventBus);
        RegistryItems.register(eventBus);
        RegistryBlockEntities.register(eventBus);
        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModClientConfig.CLIENT_SPEC, "cultivation_miracle-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModCommonConfig.COMMON_SPEC, "cultivation_miracle-common.toml");

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModMessages.register();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        //ItemBlockRenderTypes.setRenderLayer(RegistryBlocks.ALCHEMICAL_CAULDRON_EARTH_STAGE.get(), RenderType.solid());
    }

}
