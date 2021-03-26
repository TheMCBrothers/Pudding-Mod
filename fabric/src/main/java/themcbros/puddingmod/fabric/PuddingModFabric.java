package themcbros.puddingmod.fabric;

import themcbros.puddingmod.PuddingMod;
import net.fabricmc.api.ModInitializer;

public class PuddingModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PuddingMod.init();
    }
}
