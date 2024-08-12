package io.github.zygzaggaming.hearty.api;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

/**
 * Contains <code>ResourceKey</code>s and <code>Registry</code>s for <code>HeartLayer</code>s and <code>HeartType</code>s.
 */
public class HeartyRegistries {
    /**
     * The <code>ResourceKey</code> for <code>HALF_HEART_LAYER_REGISTRY</code>.
     */
    public static final ResourceKey<Registry<HalfHeartLayer>> HALF_HEART_LAYER_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath("hearty", "half_heart_layer"));
    /**
     * The <code>ResourceKey</code> for <code>HEART_LAYER_REGISTRY</code>.
     */
    public static final ResourceKey<Registry<HeartLayer>> HEART_LAYER_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath("hearty", "heart_layer"));

    /**
     * The <code>ResourceKey</code> for <code>HEART_TYPE_REGISTRY</code>.
     */
    public static final ResourceKey<Registry<HeartType>> HEART_TYPE_KEY =
        ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath("hearty", "heart_type"));
}
