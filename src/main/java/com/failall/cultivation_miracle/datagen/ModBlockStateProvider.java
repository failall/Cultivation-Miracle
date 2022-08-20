package com.failall.cultivation_miracle.datagen;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.registry.RegistryBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CultivationMiracle.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Register blocks
        simpleBlock(RegistryBlocks.PRIMORDIAL_BLOCK.get());
        simpleBlock(RegistryBlocks.PRIMORDIAL_ORE.get());
        simpleBlock(RegistryBlocks.PRIMORDIAL_ORE_DEEPSLATE.get());

    }
}
