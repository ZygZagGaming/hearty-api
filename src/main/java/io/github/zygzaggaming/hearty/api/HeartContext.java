package io.github.zygzaggaming.hearty.api;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

/**
 * Contains data available when rendering a single heart, <u>regardless</u> of type.
 *
 * @see HeartLayer
 * @see HeartUnitLayer
 * @author ZygZagGaming
 */
public class HeartContext extends GuiContext {
    private final HeartyRegistries registries;
    private final int x, y, heartIndex;

    /**
     * Constructs a new <code>HeartContext</code> with the given values.
     * @param minecraft the current <code>Minecraft</code> instance
     * @param player the client player
     * @param gui the current <code>Gui</code> instance
     * @param graphics the current <code>GuiGraphics</code> instance
     * @param x the horizontal screen-space position of this heart, from the <u>left side</u> of the screen
     * @param y the vertical screen-space position of this heart, from the <u>top</u> of the screen
     * @param heartIndex the index of this heart, starting from <code>0</code>
     */
    public HeartContext(Minecraft minecraft, HeartyRegistries registries, Player player, Gui gui, GuiGraphics graphics, int x, int y, int heartIndex) {
        super(minecraft, player, gui, graphics);
        this.registries = registries;
        this.x = x;
        this.y = y;
        this.heartIndex = heartIndex;
    }

    /**
     * Constructs a new <code>HeartContext</code> with the given values
     * @param ctx a <code>GuiContext</code> instance containing the remaining data
     * @param x the horizontal screen-space position of this heart, from the <u>left side</u> of the screen
     * @param y the vertical screen-space position of this heart, from the <u>top</u> of the screen
     * @param heartIndex the index of this heart, starting from <code>0</code>
     */
    public HeartContext(HeartyRegistries registries, GuiContext ctx, int x, int y, int heartIndex) {
        this(ctx.minecraft(), registries, ctx.player(), ctx.gui(), ctx.graphics(), x, y, heartIndex);
    }

    /**
     * @return The <code>HeartyRegistries</code> instance allowing users to query each of the Hearty registries.
     */
    public HeartyRegistries registries() {
        return registries;
    }

    /**
     * The x-coordinate of this heart.
     * @return the horizontal screen-space position of this heart, from the <u>left side</u> of the screen.
     */
    public int x() {
        return x;
    }

    /**
     * The y-coordinate of this heart.
     * @return the vertical screen-space position of this heart, from the <u>top</u> of the screen.
     */
    public int y() {
        return y;
    }

    /**
     * Creates a new <code>HeartContext</code> inheriting most of this <code>HeartContext</code>'s values, but with the given y-coordinate.
     * @param newY the returned <code>HeartContext</code>'s y-coordinate
     * @return a new instance of <code>HeartContext</code> inheriting most of this <code>HeartContext</code>'s values, but with the given y-coordinate.
     */
    public HeartContext withY(int newY) {
        return new HeartContext(minecraft(), registries(), player(), gui(), graphics(), x(), newY, heartIndex());
    }

    /**
     * The index of this heart.
     * @return the index of this heart, starting from <code>0</code>.
     */
    public int heartIndex() {
        return heartIndex;
    }
}
