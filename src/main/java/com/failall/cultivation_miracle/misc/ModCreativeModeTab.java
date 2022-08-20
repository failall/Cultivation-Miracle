package com.failall.cultivation_miracle.misc;

import com.failall.cultivation_miracle.registry.RegistryItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {

    public static final String TAB_NAME = "cultivation_miracle_tab";

    public static final CreativeModeTab CULTIVATION_MIRACLE_TAB = new CreativeModeTab(TAB_NAME) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegistryItems.PRIMORDIAL_INGOT.get()); //TODO Change to Mod Item
        }
    };

}
