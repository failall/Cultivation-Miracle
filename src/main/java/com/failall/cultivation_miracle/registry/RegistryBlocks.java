package com.failall.cultivation_miracle.registry;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.block.AlchemicalCauldronEarthStageBlock;
import com.failall.cultivation_miracle.misc.ModCreativeModeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class RegistryBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CultivationMiracle.MOD_ID);

    public static final Item.Properties TAB_PROPERTY = new Item.Properties().tab(ModCreativeModeTab.CULTIVATION_MIRACLE_TAB);

    public static final RegistryObject<Block> PRIMORDIAL_ORE = registerBlock("primordial_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f,2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PRIMORDIAL_ORE_DEEPSLATE = registerBlock("primordial_ore_deepslate",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f,2f).requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> PRIMORDIAL_BLOCK = registerBlock("primordial_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f,2f).requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)));

    public static final RegistryObject<Block> ALCHEMICAL_CAULDRON_EARTH_STAGE = registerBlock("alchemical_cauldron_earth_stage",
            () ->  new AlchemicalCauldronEarthStageBlock(BlockBehaviour.Properties.of(Material.METAL).strength(3f,2f).requiresCorrectToolForDrops().noOcclusion()));

    // Block items
    public static final RegistryObject<Item> PRIMORDIAL_ORE_ITEM = fromBlock(PRIMORDIAL_ORE);
    public static final RegistryObject<Item> PRIMORDIAL_ORE_DEEPSLATE_ITEM = fromBlock(PRIMORDIAL_ORE_DEEPSLATE);
    public static final RegistryObject<Item> PRIMORDIAL_BLOCK_ITEM = fromBlock(PRIMORDIAL_BLOCK);
    public static final RegistryObject<Item> ALCHEMICAL_CAULDRON_EARTH_STAGE_ITEM = fromBlock(ALCHEMICAL_CAULDRON_EARTH_STAGE);


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    // Register Item associated with the block
    public static <T extends Block> RegistryObject<Item> fromBlock(RegistryObject<T> block) {
        return RegistryItems.ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), TAB_PROPERTY));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
