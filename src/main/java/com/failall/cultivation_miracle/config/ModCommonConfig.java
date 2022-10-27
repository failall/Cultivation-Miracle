package com.failall.cultivation_miracle.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec COMMON_SPEC;

    public static final ForgeConfigSpec.IntValue MAX_QI_STARTING;
    public static final ForgeConfigSpec.IntValue CULTIVATION_SPEED_STARTING;
    public static final ForgeConfigSpec.IntValue THRESHOLD_QI_STARTING;

    static {
        // Start a category with BUILDER.push() and end with BUILDER.pop()
        BUILDER.comment("Common config for Cultivation Miracle");

        BUILDER.push("Cultivator config options");
        BUILDER.comment("Starting values of the cultivator(player):");
        MAX_QI_STARTING = BUILDER
                .defineInRange("Maximum Qi", 100, 1, 100000);
        CULTIVATION_SPEED_STARTING = BUILDER
                .defineInRange("Cultivation Speed", 1 , 1, 100000);
        THRESHOLD_QI_STARTING = BUILDER
                .defineInRange("Threshold Qi", 100, 1 + 1, 100001);
        BUILDER.pop();



        COMMON_SPEC = BUILDER.build();

    }
}
