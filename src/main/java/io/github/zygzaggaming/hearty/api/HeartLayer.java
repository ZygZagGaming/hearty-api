package io.github.zygzaggaming.hearty.api;

import net.minecraft.resources.ResourceLocation;

/**
 * <code>HeartLayer</code>s modify and manipulate rendered hearts for additional visual effects not provided by <code>HeartType</code>s.
 *
 * @see HalfHeartLayer
 * @author ZygZagGaming
 */
public abstract class HeartLayer implements Comparable<HeartLayer> {
    /**
     * The id of this <code>HeartLayer</code>.
     * This <code>HeartLayer</code> should be registered under this id.
     */
    public final ResourceLocation id;
    /**
     * The priority of this <code>HeartLayer</code>.
     * <code>HeartLayer</code>s are applied in order of <u>increasing</u> <code>priority</code>, <u>before</u> <code>HalfHeartLayer</code>s.
     */
    public final double priority;

    /**
     * Constructs a new <code>HeartLayer</code>.
     * @param id this <code>HeartLayer</code>'s id
     * @param priority this <code>HeartLayer</code>'s priority; <code>HeartLayer</code>s are applied in order of <u>increasing</u> <code>priority</code>, <u>before</u> <code>HalfHeartLayer</code>s
     */
    public HeartLayer(ResourceLocation id, double priority) {
        this.id = id;
        this.priority = priority;
    }

    @Override
    public int compareTo(HeartLayer other) {
        return Double.compare(priority, other.priority);
    }

    /**
     * Applied to each heart.
     *
     * @param ctx the context regarding this heart
     * @return the sprite that should be used for the heart.
     */
    public abstract HeartContext apply(HeartContext ctx);
}
