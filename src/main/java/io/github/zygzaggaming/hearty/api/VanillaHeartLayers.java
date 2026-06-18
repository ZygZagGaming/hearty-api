package io.github.zygzaggaming.hearty.api;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class VanillaHeartLayers {
    /**
     * Controls heart wiggling on regeneration and low health.
     */
    public static final ResourceKey<HeartLayer> HEART_WIGGLE =
            ResourceKey.create(HeartyRegistries.HEART_LAYER_KEY, ResourceLocation.fromNamespaceAndPath("hearty", "heart_wiggle"));
}
