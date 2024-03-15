package io.github.zygzaggaming.hearty.api;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class HalfHeartContext extends HeartContext {
    private final HeartType heartType;
    private final ResourceLocation sprite;
    private final int halfHeartIndex;
    public HalfHeartContext(Minecraft minecraft, Player player, Gui gui, GuiGraphics graphics, int x, int y, int heartIndex, HeartType heartType, ResourceLocation sprite, int halfHeartIndex) {
        super(minecraft, player, gui, graphics, x, y, heartIndex);
        this.heartType = heartType;
        this.sprite = sprite;
        this.halfHeartIndex = halfHeartIndex;
    }

    public HalfHeartContext(HeartContext ctx, HeartType heartType, ResourceLocation sprite, int halfHeartIndex) {
        this(ctx.minecraft(), ctx.player(), ctx.gui(), ctx.graphics(), ctx.x(), ctx.y(), ctx.heartIndex(), heartType, sprite, halfHeartIndex);
    }

    public HeartType heartType() {
        return heartType;
    }

    public ResourceLocation sprite() {
        return sprite;
    }

    public HalfHeartContext withSprite(ResourceLocation newSprite) {
        return new HalfHeartContext(minecraft(), player(), gui(), graphics(), x(), y(), heartIndex(), heartType(), newSprite, halfHeartIndex());
    }

    public int halfHeartIndex() {
        return halfHeartIndex;
    }
}
