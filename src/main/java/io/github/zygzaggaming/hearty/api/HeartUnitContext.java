package io.github.zygzaggaming.hearty.api;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class HeartUnitContext extends HeartContext {
    private final HeartType heartType;
    private final ResourceLocation sprite;
    private final int heartUnitIndex;
    public HeartUnitContext(Minecraft minecraft, HeartyRegistries registries, Player player, Gui gui, GuiGraphics graphics, int x, int y, int heartIndex, HeartType heartType, ResourceLocation sprite, int heartUnitIndex) {
        super(minecraft, registries, player, gui, graphics, x, y, heartIndex);
        this.heartType = heartType;
        this.sprite = sprite;
        this.heartUnitIndex = heartUnitIndex;
    }

    public HeartUnitContext(HeartContext ctx, HeartType heartType, ResourceLocation sprite, int heartUnitIndex) {
        this(ctx.minecraft(), ctx.registries(), ctx.player(), ctx.gui(), ctx.graphics(), ctx.x(), ctx.y(), ctx.heartIndex(), heartType, sprite, heartUnitIndex);
    }

    public HeartType heartType() {
        return heartType;
    }

    public ResourceLocation sprite() {
        return sprite;
    }

    public HeartUnitContext withSprite(ResourceLocation newSprite) {
        return new HeartUnitContext(minecraft(), registries(), player(), gui(), graphics(), x(), y(), heartIndex(), heartType(), newSprite, heartUnitIndex());
    }

    public int heartUnitIndex() {
        return heartUnitIndex;
    }

    public boolean is(ResourceKey<HeartType> key) {
        return heartType().is(key);
    }
}
