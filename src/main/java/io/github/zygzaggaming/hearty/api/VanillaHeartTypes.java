package io.github.zygzaggaming.hearty.api;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class VanillaHeartTypes {
    /**
     * Regular health.
     */
    public static final ResourceKey<HeartType> HEALTH =
            ResourceKey.create(HeartyRegistries.HEART_TYPE_KEY, ResourceLocation.fromNamespaceAndPath("hearty", "health"));
    /**
     * Empty hearts.
     */
    public static final ResourceKey<HeartType> EMPTY =
            ResourceKey.create(HeartyRegistries.HEART_TYPE_KEY, ResourceLocation.fromNamespaceAndPath("hearty", "empty"));
    /**
     * Absorption hearts.
     */
    public static final ResourceKey<HeartType> ABSORPTION =
            ResourceKey.create(HeartyRegistries.HEART_TYPE_KEY, ResourceLocation.fromNamespaceAndPath("hearty", "absorption"));
}
