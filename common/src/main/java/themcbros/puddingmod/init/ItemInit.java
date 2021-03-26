package themcbros.puddingmod.init;

import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;

import static themcbros.puddingmod.PuddingMod.*;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY);
    public static final RegistrySupplier<Item> MIXED_ITEM = ITEMS.register("mixed_item", () ->
            new Item(new Item.Properties().tab(PUDDING_TAB)));
    public static final RegistrySupplier<Item> PUDDING_ITEM = ITEMS.register("pudding", () ->
            new BowlFoodItem(new Item.Properties().tab(PUDDING_TAB).food(Foods.BEETROOT_SOUP).stacksTo(1)));

    public static final RegistrySupplier<BlockItem> PUDDING_BLOCK_ITEM = ITEMS.register("pudding_block", () ->
            new BlockItem(BlockInit.PUDDING_BLOCK.get(), new Item.Properties().tab(PUDDING_TAB)));

}
