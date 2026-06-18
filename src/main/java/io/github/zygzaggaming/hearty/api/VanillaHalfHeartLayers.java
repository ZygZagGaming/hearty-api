package io.github.zygzaggaming.hearty.api;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class VanillaHalfHeartLayers {
    /**
     * Controls hearts becoming frozen when in powder snow.
     */
    public static final ResourceKey<HalfHeartLayer> FROZEN =
            ResourceKey.create(HeartyRegistries.HALF_HEART_LAYER_KEY, ResourceLocation.fromNamespaceAndPath("hearty", "frozen"));
    /**
     * Controls hearts becoming green when poisoned.
     */
    public static final ResourceKey<HalfHeartLayer> POISON =
            ResourceKey.create(HeartyRegistries.HALF_HEART_LAYER_KEY, ResourceLocation.fromNamespaceAndPath("hearty", "poison"));
    /**
     * Controls hearts becoming black when afflicted by Wither.
     */
    public static final ResourceKey<HalfHeartLayer> WITHER =
            ResourceKey.create(HeartyRegistries.HALF_HEART_LAYER_KEY, ResourceLocation.fromNamespaceAndPath("hearty", "wither"));
    /**
     * Controls hearts changing texture when in hardcore mode.
     */
    public static final ResourceKey<HalfHeartLayer> HARDCORE =
            ResourceKey.create(HeartyRegistries.HALF_HEART_LAYER_KEY, ResourceLocation.fromNamespaceAndPath("hearty", "hardcore"));
    /**
     * Controls hearts blinking when taking damage or regenerating health.
     */
    public static final ResourceKey<HalfHeartLayer> BLINK =
            ResourceKey.create(HeartyRegistries.HALF_HEART_LAYER_KEY, ResourceLocation.fromNamespaceAndPath("hearty", "blink"));
}
