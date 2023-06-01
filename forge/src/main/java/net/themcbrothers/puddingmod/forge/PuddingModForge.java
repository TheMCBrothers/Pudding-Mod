package net.themcbrothers.puddingmod.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.themcbrothers.puddingmod.PuddingMod;

/**
 * @author TheMCLoveMan
 */
@Mod(PuddingMod.MOD_ID)
public class PuddingModForge {
    public PuddingModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(PuddingMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        PuddingMod.init();
    }
}
