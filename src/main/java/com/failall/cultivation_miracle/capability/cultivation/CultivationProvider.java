package com.failall.cultivation_miracle.capability.cultivation;

import com.failall.cultivation_miracle.config.ModCommonConfig;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CultivationProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<CultivationCapability> PLAYER_QI = CapabilityManager.get(new CapabilityToken<CultivationCapability>(){});
    private CultivationCapability qi = null;
    private final LazyOptional<CultivationCapability> lazyOptional = LazyOptional.of(this::createCultivationCapability);

    private CultivationCapability createCultivationCapability() {
        if (this.qi == null) {
            this.qi = new CultivationCapability(ModCommonConfig.MAX_QI_STARTING.get(), ModCommonConfig.CULTIVATION_SPEED_STARTING.get());
        }
        return this.qi;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_QI) {
            return lazyOptional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        createCultivationCapability().serializeNBT(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        createCultivationCapability().deserializeNBT(tag);
    }
}
