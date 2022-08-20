package com.failall.cultivation_miracle.keys;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {

    public static final String KEY_CATEGORY_CULTIVATION_MIRACLE = "key.category.cultivation_miracle";
    public static final String KEY_CULTIVATE = "key.cultivation_miracle.cultivate";

    public static KeyMapping CULTIVATE_KEY = new KeyMapping(KEY_CULTIVATE, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C, KEY_CATEGORY_CULTIVATION_MIRACLE);

}
