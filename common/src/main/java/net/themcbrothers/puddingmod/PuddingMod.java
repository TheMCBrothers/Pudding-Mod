package net.themcbrothers.puddingmod;

import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

/**
 * @author TheMCLoveMan
 */
public class PuddingMod {
    public static final String MOD_ID = "puddingmod";

    // Registering a new creative tab
    public static final CreativeTabRegistry.TabSupplier PUDDING_TAB = CreativeTabRegistry.create(PuddingMod.location("pudding_tab"), () ->
            new ItemStack(PuddingItems.VANILLA_PUDDING.get()));

    public static void init() {
        PuddingFluids.register();
        PuddingBlocks.register();
        PuddingItems.register();
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
