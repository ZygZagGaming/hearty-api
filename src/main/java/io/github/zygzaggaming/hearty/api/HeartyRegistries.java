package io.github.zygzaggaming.hearty.api;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

/**
 * Contains <code>ResourceKey</code>s and <code>Registry</code>s for <code>HeartLayer</code>s and <code>HeartType</code>s.
 */
public record HeartyRegistries(
        Registry<HeartUnitLayer> heartUnitLayers,
        Registry<HeartLayer> heartLayers,
        Registry<HeartType> heartTypes
) {
    /**
     * The <code>ResourceKey</code> for <code>HEART_UNIT_LAYER_REGISTRY</code>.
     */
    public static final ResourceKey<Registry<HeartUnitLayer>> HEART_UNIT_LAYER_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath("hearty", "heart_unit_layer"));
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
