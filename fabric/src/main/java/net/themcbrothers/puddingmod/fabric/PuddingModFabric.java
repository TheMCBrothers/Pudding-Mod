package net.themcbrothers.puddingmod.fabric;

import net.themcbrothers.puddingmod.PuddingMod;
import net.fabricmc.api.ModInitializer;

/**
 * @author TheMCLoveMan
 */
public class PuddingModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PuddingMod.init();
    }
}
