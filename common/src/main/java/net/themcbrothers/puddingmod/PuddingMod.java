package net.themcbrothers.puddingmod;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * @author TheMCLoveMan
 */
public class PuddingMod {
    public static final String MOD_ID = "puddingmod";

    // Registering a new creative tab
    private static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> PUDDING_TAB = TABS.register("pudding_tab",
            () -> CreativeTabRegistry.create(
                    Component.translatable("itemGroup.puddingmod.pudding_tab"),
                    () -> new ItemStack(PuddingItems.VANILLA_PUDDING.get())
            ));


    public static void init() {
        TABS.register();
        PuddingFluids.register();
        PuddingBlocks.register();
        PuddingItems.register();
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
