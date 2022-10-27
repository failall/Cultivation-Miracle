package com.failall.cultivation_miracle.registry;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.cultivation.CultivationStage;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RegistryCultivationStages {

        public static final DeferredRegister<CultivationStage> DEFERRED_CULTIVATION_STAGES = DeferredRegister.create(
                new ResourceLocation(CultivationMiracle.MOD_ID, "cultivation_stages"), CultivationMiracle.MOD_ID);

        public static final Supplier<IForgeRegistry<CultivationStage>> CULTIVATION_STAGES = DEFERRED_CULTIVATION_STAGES
                .makeRegistry(RegistryBuilder::new);

        // ENTRIES
        public static final RegistryObject<CultivationStage> PERCEPTION_I = registerStage("perception_1", () -> new CultivationStage(
                RegistryCultivationRealms.PERCEPTION.get(),
                1,
                20,
                20,
                1
                ).setPlayerAttr("MAX_HP", 0d).setPlayerAttr("DAMAGE", 0d).setPlayerAttr("ARMOR", 0d));



        private static <T extends CultivationStage> RegistryObject<T> registerStage(String name, Supplier<T> stage) {
            return DEFERRED_CULTIVATION_STAGES.register(name, stage);
        }

        public static void register(IEventBus eventBus) {
            DEFERRED_CULTIVATION_STAGES.register(eventBus);
        }

}
