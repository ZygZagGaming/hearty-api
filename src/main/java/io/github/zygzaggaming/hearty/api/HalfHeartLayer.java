package io.github.zygzaggaming.hearty.api;

import net.minecraft.resources.ResourceLocation;

/**
 * <code>HalfHeartLayer</code>s modify and manipulate rendered half-hearts for additional visual effects not provided by <code>HeartType</code>s or <code>HeartLayer</code>s.
 *
 * @see HeartLayer
 * @author ZygZagGaming
 */
public abstract class HalfHeartLayer implements Comparable<HalfHeartLayer> {
    /**
     * The id of this <code>HalfHeartLayer</code>.
     * This <code>HeartLayer</code> should be registered under this id.
     */
    public final ResourceLocation id;
    /**
     * The priority of this <code>HalfHeartLayer</code>.
     * <code>HalfHeartLayer</code>s are applied in order of <u>increasing</u> <code>priority</code>, <u>after</u> <code>HeartLayer</code>s.
     */
    public final double priority;

    /**
     * Constructs a new <code>HalfHeartLayer</code>.
     * @param id this <code>HalfHeartLayer</code>'s id
     * @param priority this <code>HalfHeartLayer</code>'s priority; <code>HalfHeartLayer</code>s are applied in order of <u>increasing</u> <code>priority</code>, <u>after</u> <code>HeartLayer</code>s
     */
    public HalfHeartLayer(ResourceLocation id, double priority) {
        this.id = id;
        this.priority = priority;
    }

    @Override
    public int compareTo(HalfHeartLayer other) {
        return Double.compare(priority, other.priority);
    }

    /**
     * Applied to each half-heart.
     *
     * @param ctx the context regarding this half-heart
     * @return the sprite that should be used for the half-heart.
     */
    public abstract HalfHeartContext apply(HalfHeartContext ctx);
}
