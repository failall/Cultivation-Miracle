package com.failall.cultivation_miracle.datagen;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.registry.RegistryBlocks;
import com.failall.cultivation_miracle.registry.RegistryItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModItemTags extends ItemTagsProvider {
    public ModItemTags(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, CultivationMiracle.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.INGOTS)
                .add(RegistryItems.PRIMORDIAL_INGOT.get());

        tag(Tags.Items.ORES)
                .add(RegistryBlocks.PRIMORDIAL_BLOCK_ITEM.get())
                .add(RegistryBlocks.PRIMORDIAL_ORE_ITEM.get())
                .add(RegistryBlocks.PRIMORDIAL_ORE_DEEPSLATE_ITEM.get());
    }

    @Override
    public String getName() {
        return "Cultivation Miracle Tags";
    }
}
