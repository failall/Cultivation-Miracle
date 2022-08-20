package com.failall.cultivation_miracle.datagen;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.registry.RegistryBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTags extends BlockTagsProvider {
    public ModBlockTags(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, CultivationMiracle.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Cultivation Miracle Tags";
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(RegistryBlocks.PRIMORDIAL_BLOCK.get())
                .add(RegistryBlocks.PRIMORDIAL_ORE_DEEPSLATE.get())
                .add(RegistryBlocks.PRIMORDIAL_ORE.get())
                .add(RegistryBlocks.ALCHEMICAL_CAULDRON_EARTH_STAGE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(RegistryBlocks.PRIMORDIAL_BLOCK.get())
                .add(RegistryBlocks.PRIMORDIAL_ORE_DEEPSLATE.get())
                .add(RegistryBlocks.PRIMORDIAL_ORE.get())
                .add(RegistryBlocks.ALCHEMICAL_CAULDRON_EARTH_STAGE.get());

        tag(Tags.Blocks.ORES)
                .add(RegistryBlocks.PRIMORDIAL_BLOCK.get())
                .add(RegistryBlocks.PRIMORDIAL_ORE_DEEPSLATE.get())
                .add(RegistryBlocks.PRIMORDIAL_ORE.get());
    }
}
