package com.failall.cultivation_miracle.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        BUILDER.push("Client config for Cultivation Miracle");

        // HERE DEFINE YOUR CONFIGS

        BUILDER.pop();
        CLIENT_SPEC = BUILDER.build();
    }
}
