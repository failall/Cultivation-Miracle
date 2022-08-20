package com.failall.cultivation_miracle.registry;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.misc.ModCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegistryItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CultivationMiracle.MOD_ID);

    public static final RegistryObject<Item> PRIMORDIAL_INGOT = ITEMS.register("primordial_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CULTIVATION_MIRACLE_TAB)));

    public static final RegistryObject<Item> RAW_PRIMORDIAL = ITEMS.register("raw_primordial",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CULTIVATION_MIRACLE_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
