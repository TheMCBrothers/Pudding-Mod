package net.themcbrothers.puddingmod;

import dev.architectury.core.item.ArchitecturyBucketItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;

import static net.themcbrothers.puddingmod.PuddingMod.PUDDING_TAB;

/**
 * @author TheMCLoveMan
 */
public class PuddingItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(PuddingMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> PUDDING_BUCKET = REGISTER.register("pudding_bucket", () ->
            new ArchitecturyBucketItem(PuddingFluids.PUDDING, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).arch$tab(PUDDING_TAB)));
    public static final RegistrySupplier<Item> PUDDING_ITEM = REGISTER.register("pudding", () ->
            new BowlFoodItem(new Item.Properties().food(Foods.BEETROOT_SOUP).stacksTo(16).craftRemainder(Items.BOWL).arch$tab(PUDDING_TAB)));
    public static final RegistrySupplier<BowlFoodItem> VANILLA_PUDDING = registerPudding(PuddingVariants.VANILLA);
    public static final RegistrySupplier<BowlFoodItem> CHOCOLATE_PUDDING = registerPudding(PuddingVariants.CHOCOLATE);

    public static final RegistrySupplier<BlockItem> PUDDING_BLOCK_ITEM = REGISTER.register("pudding_block", () ->
            new BlockItem(PuddingBlocks.PUDDING_BLOCK.get(), new Item.Properties().arch$tab(PUDDING_TAB)));

    private static RegistrySupplier<BowlFoodItem> registerPudding(IPudding pudding) {
        return REGISTER.register(pudding.getName() + "_pudding", () -> IPudding.getPuddingItem(pudding));
    }

    static void register() {
        REGISTER.register();
    }
}
