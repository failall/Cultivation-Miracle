package com.failall.cultivation_miracle.datagen;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.keys.KeyBinding;
import com.failall.cultivation_miracle.registry.RegistryBlocks;
import com.failall.cultivation_miracle.registry.RegistryItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.failall.cultivation_miracle.misc.ModCreativeModeTab.TAB_NAME;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, CultivationMiracle.MOD_ID, locale);
    }

    // See https://github.com/McJty/TutorialV3/blob/main/src/main/java/com/example/tutorialv3/datagen/TutLanguageProvider.java
    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "Cultivation Miracle");
        add(RegistryItems.PRIMORDIAL_INGOT.get(), "Primordial Ingot");
        add(RegistryItems.RAW_PRIMORDIAL.get(), "Raw Primordial");

        add(RegistryBlocks.PRIMORDIAL_BLOCK.get(), "Block of Primordial Ingots");
        add(RegistryBlocks.PRIMORDIAL_ORE.get(), "Primordial Ore");
        add(RegistryBlocks.PRIMORDIAL_ORE_DEEPSLATE.get(), "Deepslate Primordial Ore");
        add(RegistryBlocks.ALCHEMICAL_CAULDRON_EARTH_STAGE.get(), "Alchemical Cauldron");

        // key bindings & category
        add(KeyBinding.KEY_CATEGORY_CULTIVATION_MIRACLE, "Cultivation Miracle");
        add(KeyBinding.KEY_CULTIVATE, "Cultivate");

        // ModMessages


    }
}
