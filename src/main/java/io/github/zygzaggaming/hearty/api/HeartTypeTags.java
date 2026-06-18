package io.github.zygzaggaming.hearty.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

@SuppressWarnings("unused")
public class HeartTypeTags {
    /**
     * Variants of regular health (full, empty).
     */
    public static final TagKey<HeartType> IS_REGULAR_HEALTH =
            TagKey.create(HeartyRegistries.HEART_TYPE_KEY, ResourceLocation.fromNamespaceAndPath("hearty", "is_regular_health"));
}
