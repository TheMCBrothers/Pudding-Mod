package themcbros.puddingmod.init;

import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import themcbros.puddingmod.pudding.IPudding;
import themcbros.puddingmod.pudding.PuddingSorts;

import static themcbros.puddingmod.PuddingMod.*;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY);
    public static final RegistrySupplier<Item> PUDDING_ITEM = ITEMS.register("pudding", () ->
            new BowlFoodItem(new Item.Properties().tab(PUDDING_TAB).food(Foods.BEETROOT_SOUP).stacksTo(16).craftRemainder(Items.BOWL)));
    public static final RegistrySupplier<BowlFoodItem> VANILLA_PUDDING = registerPudding(PuddingSorts.VANILLA);
    public static final RegistrySupplier<BowlFoodItem> CHOCOLATE_PUDDING = registerPudding(PuddingSorts.CHOCOLATE);

    public static final RegistrySupplier<BlockItem> PUDDING_BLOCK_ITEM = ITEMS.register("pudding_block", () ->
            new BlockItem(BlockInit.PUDDING_BLOCK.get(), new Item.Properties().tab(PUDDING_TAB)));

    private static RegistrySupplier<BowlFoodItem> registerPudding(IPudding pudding) {
        return ITEMS.register(pudding.getName() + "_pudding", () -> IPudding.getPuddingItem(pudding));
    }

}
