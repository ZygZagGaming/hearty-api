package io.github.zygzaggaming.hearty.api;

import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

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

    public final ResourceKey<HeartType> resourceKey;

    /**
     * Constructs a new <code>HeartType</code>.
     * @param id this <code>HeartType</code>'s id
     * @param priority this <code>HeartType</code>'s priority; <code>HeartType</code>s are shown on-screen in order of <u>increasing</u> <code>priority</code>
     */
    public HeartType(ResourceLocation id, double priority) {
        this.id = id;
        this.priority = priority;
        resourceKey = ResourceKey.create(HeartyRegistries.HEART_TYPE_KEY, id);
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

    /**
     * @param id the id to check against
     * @return whether or not our id matches the given parameter.
     */
    public boolean is(ResourceLocation id) {
        return id.equals(this.id);
    }

    /**
     * @param id the id to check against
     * @return whether or not our id matches the given parameter.
     */
    public boolean is(ResourceKey<HeartType> id) {
        return id.location().equals(this.id);
    }

    /**
     * @param tag the tag to check against
     * @param registries access to the registries
     * @return whether or not our id matches the given parameter.
     */
    public boolean is(TagKey<HeartType> tag, RegistryAccess registries) {
        return registries.holder(resourceKey)
                .map(heartTypeReference ->
                        registries.lookup(HeartyRegistries.HEART_TYPE_KEY)
                                .flatMap(it -> it.get(tag))
                                .map(it -> it.contains(heartTypeReference))
                                .orElse(false)
                ).orElse(false);
    }
}
