package com.failall.cultivation_miracle.network.cultivation;

import com.failall.cultivation_miracle.capability.cultivation.CultivationProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CultivationC2SPacket {

    public CultivationC2SPacket() {
    }

    public CultivationC2SPacket(FriendlyByteBuf buf) {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are server side
            // Do Animation for sitdown/cultivate, remove when player is moving again
            ServerPlayer player = ctx.getSender();
            ServerLevel level = ctx.getSender().getLevel(); // or player.getLevel();

            //TODO also check for isCollisionShapeFullBlock(), currently no idea how to do that
            if(!level.getBlockState(player.getOnPos()).isAir() &&
                    level.getBlockState(player.getOnPos().above()).getFluidState().is(Fluids.EMPTY) &&
                    level.getBlockState(player.getOnPos()).getFluidState().is(Fluids.EMPTY)) {

                player.getCapability(CultivationProvider.PLAYER_QI).ifPresent(cultivator -> {
                    cultivator.setCultivationStatus(true);
                });

            }
        });
        return true;
    }
}
