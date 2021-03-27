package themcbros.puddingmod;

import me.shedaniel.architectury.hooks.TagHooks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.material.Fluid;

public class PuddingTags {

    public static final Tag.Named<Fluid> PUDDING = TagHooks.getFluidOptional(new ResourceLocation(PuddingMod.MOD_ID, "pudding"));

}
