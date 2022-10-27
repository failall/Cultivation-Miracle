package com.failall.cultivation_miracle.registry;

import com.failall.cultivation_miracle.CultivationMiracle;
import com.failall.cultivation_miracle.cultivation.CultivationRealm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RegistryCultivationRealms {

    public static final DeferredRegister<CultivationRealm> DEFERRED_CULTIVATION_REALMS = DeferredRegister.create(
           new ResourceLocation(CultivationMiracle.MOD_ID, "cultivation_realms"), CultivationMiracle.MOD_ID);

    public static final Supplier<IForgeRegistry<CultivationRealm>> CULTIVATION_REALMS = DEFERRED_CULTIVATION_REALMS
                        .makeRegistry(RegistryBuilder::new);

    // ENTRIES
    public static final RegistryObject<CultivationRealm> PERCEPTION = registerRealm("perception",
            () -> new CultivationRealm("Perception"));

    public static final RegistryObject<CultivationRealm> FOUNDATION = registerRealm("foundation",
            () -> new CultivationRealm("Foundation"));

    public static final RegistryObject<CultivationRealm> ESTABLISHMENT = registerRealm("establishment",
            () -> new CultivationRealm("Establishment"));

    public static final RegistryObject<CultivationRealm> NASCENT = registerRealm("nascent",
            () -> new CultivationRealm("Nascent"));

    public static final RegistryObject<CultivationRealm> NIHILTIY = registerRealm("nihiltiy",
            () -> new CultivationRealm("Nihility"));

    public static final RegistryObject<CultivationRealm> ASCENSION = registerRealm("ascension",
            () -> new CultivationRealm("Ascension"));

    public static final RegistryObject<CultivationRealm> DIVINE_LORD = registerRealm("divine_lord",
            () -> new CultivationRealm("Divine Lord"));

    //TODO add remaining realms

    private static <T extends CultivationRealm>RegistryObject<T> registerRealm(String name, Supplier<T> realm) {
        return DEFERRED_CULTIVATION_REALMS.register(name, realm);
    }


    public static void register(IEventBus eventBus) {
        DEFERRED_CULTIVATION_REALMS.register(eventBus);
    }



}
