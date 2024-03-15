package io.github.zygzaggaming.hearty.api;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class GuiContext {
    private final Minecraft minecraft;
    private final Player player;
    private final Gui gui;
    private final GuiGraphics graphics;

    public GuiContext(Minecraft minecraft, Player player, Gui gui, GuiGraphics graphics) {
        this.minecraft = minecraft;
        this.player = player;
        this.gui = gui;
        this.graphics = graphics;
    }

    public Minecraft minecraft() {
        return minecraft;
    }
    public Player player() {
        return player;
    }
    public Gui gui() {
        return gui;
    }
    public GuiGraphics graphics() {
        return graphics;
    }

    public Level level() {
        return player.level();
    }

    public boolean shouldShowHealth() {
        return player() != null && !player().getAbilities().instabuild && !player().isSpectator();
    }

    public int regenHeartWiggle() {
        return player().hasEffect(MobEffects.REGENERATION) ? gui().tickCount % Mth.ceil(player().getMaxHealth() + 5) : -1;
    }
}
