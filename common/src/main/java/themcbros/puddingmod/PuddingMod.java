package themcbros.puddingmod;

import me.shedaniel.architectury.registry.CreativeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import themcbros.puddingmod.init.BlockInit;
import themcbros.puddingmod.init.ItemInit;

public class PuddingMod {
    public static final String MOD_ID = "puddingmod";
    // Registering a new creative tab
    public static final CreativeModeTab PUDDING_TAB = CreativeTabs.create(new ResourceLocation(MOD_ID, "pudding_tab"),
            () -> new ItemStack(ItemInit.PUDDING_ITEM.get()));
    
    public static void init() {
        BlockInit.BLOCKS.register();
        ItemInit.ITEMS.register();
    }
}
