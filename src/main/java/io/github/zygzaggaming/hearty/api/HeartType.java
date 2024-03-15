package io.github.zygzaggaming.hearty.api;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

/**
 * <code>HeartType</code>s are types of hearts that get rendered on-screen.
 *
 * @author ZygZagGaming
 */
public abstract class HeartType implements Comparable<HeartType> {
    /**
     * Returns the number of hearts that should exist on screen of this <code>HeartType</code>.
     * @param ctx the context regarding this heart
     * @return how many of this <code>HeartType</code> should exist on-screen at this moment. Independent of other <code>HeartType</code>s.
     */
    public abstract int getNumber(GuiContext ctx);
    /**
     * Returns the texture for hearts of this <code>HeartType</code>.
     * @param ctx the context regarding this heart
     * @return which texture should currently be used for this <code>HeartType</code>.
     */
    public abstract ResourceLocation getTexture(GuiContext ctx);
    /**
     * The id of this <code>HeartType</code>.
     * This <code>HeartType</code> should be registered under this id.
     */
    public final ResourceLocation id;
    /**
     * The priority of this <code>HeartType</code>.
     * <code>HeartType</code>s are shown on-screen in order of <u>increasing</u> <code>priority</code>.
     */
    public final double priority;

    /**
     * Constructs a new <code>HeartType</code>.
     * @param id this <code>HeartType</code>'s id
     * @param priority this <code>HeartType</code>'s priority; <code>HeartType</code>s are shown on-screen in order of <u>increasing</u> <code>priority</code>
     */
    public HeartType(ResourceLocation id, double priority) {
        this.id = id;
        this.priority = priority;
    }

    @Override
    public int compareTo(HeartType other) {
        return Double.compare(priority, other.priority);
    }

    /**
     * Creates a new <code>HeartType</code> with the given properties.
     * @param id the id of the new <code>HeartType</code>
     * @param priority the priority of the new <code>HeartType</code>; <code>HeartType</code>s are shown on-screen in order of <u>increasing</u> <code>priority</code>
     * @param getNumber the function returning the number of hearts for this <code>HeartType</code> at any given moment
     * @param getTexture the function returning the texture for hearts of this <code>HeartType</code> at any given moment
     * @return a new <code>HeartType</code> with the given properties.
     */
    public static HeartType basicSuppliers(ResourceLocation id, double priority, Function<GuiContext, Integer> getNumber, Function<GuiContext, ResourceLocation> getTexture) {
        return new HeartType(id, priority) {
            @Override
            public int getNumber(GuiContext ctx) {
                return getNumber.apply(ctx);
            }

            @Override
            public ResourceLocation getTexture(GuiContext ctx) {
                return getTexture.apply(ctx);
            }
        };
    }

    /**
     * Creates a new <code>HeartType</code> with the given properties.
     * @param id the id of the new <code>HeartType</code>
     * @param priority the priority of the new <code>HeartType</code>; <code>HeartType</code>s are shown on-screen in order of <u>increasing</u> <code>priority</code>
     * @param getNumber the function returning the number of hearts for this <code>HeartType</code> at any given moment
     * @param texture the texture for hearts of this <code>HeartType</code>
     * @return a new <code>HeartType</code> with the given properties.
     */
    public static HeartType basic(ResourceLocation id, double priority, Function<GuiContext, Integer> getNumber, ResourceLocation texture) {
        return basicSuppliers(id, priority, getNumber, (a) -> texture);
    }
}
