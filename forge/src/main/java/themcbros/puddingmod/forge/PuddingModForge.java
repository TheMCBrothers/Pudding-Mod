package themcbros.puddingmod.forge;

import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import themcbros.puddingmod.PuddingMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PuddingMod.MOD_ID)
public class PuddingModForge {
    public PuddingModForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(PuddingMod.MOD_ID, bus);
        PuddingMod.init();
        ForgeFluidInit.register(bus);
    }
}
