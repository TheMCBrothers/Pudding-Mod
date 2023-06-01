package net.themcbrothers.puddingmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

/**
 * @author TheMCLoveMan
 */
public class PuddingTags {
    public static final TagKey<Fluid> PUDDING = TagKey.create(Registries.FLUID, new ResourceLocation("pudding"));
}
