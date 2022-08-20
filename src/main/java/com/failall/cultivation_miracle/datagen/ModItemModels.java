package com.failall.cultivation_miracle.datagen;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.registry.RegistryBlocks;
import com.failall.cultivation_miracle.registry.RegistryItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModels extends ItemModelProvider {

    public ModItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CultivationMiracle.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // TODO Dont forget to register BlockItems
        withExistingParent(RegistryBlocks.PRIMORDIAL_BLOCK_ITEM.getId().getPath(), modLoc("block/primordial_block"));
        withExistingParent(RegistryBlocks.PRIMORDIAL_ORE_ITEM.getId().getPath(), modLoc("block/primordial_ore"));
        withExistingParent(RegistryBlocks.PRIMORDIAL_ORE_DEEPSLATE_ITEM.getId().getPath(), modLoc("block/primordial_ore_deepslate"));

        simpleItem(RegistryItems.PRIMORDIAL_INGOT);
        simpleItem(RegistryItems.RAW_PRIMORDIAL);
    }

        private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
            return withExistingParent(item.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(CultivationMiracle.MOD_ID,"item/" + item.getId().getPath()));
        }

        private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
            return withExistingParent(item.getId().getPath(),
                    new ResourceLocation("item/handheld")).texture("layer0",
                    new ResourceLocation(CultivationMiracle.MOD_ID,"item/" + item.getId().getPath()));
        }

}
