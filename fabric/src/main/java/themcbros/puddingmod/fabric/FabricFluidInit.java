package themcbros.puddingmod.fabric;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import themcbros.puddingmod.PuddingMod;
import themcbros.puddingmod.fluid.fabric.PuddingFluid;
import themcbros.puddingmod.fluid.fabric.PuddingLiquidBlock;

public class FabricFluidInit implements ModInitializer {

    public static FlowingFluid STILL_PUDDING;
    public static FlowingFluid FLOWING_PUDDING;

    public static BucketItem PUDDING_BUCKET;

    public static LiquidBlock PUDDING;

    @Override
    public void onInitialize() {
        STILL_PUDDING = Registry.register(Registry.FLUID, new ResourceLocation(PuddingMod.MOD_ID, "pudding"), new PuddingFluid.Source());
        FLOWING_PUDDING = Registry.register(Registry.FLUID, new ResourceLocation(PuddingMod.MOD_ID, "flowing_pudding"), new PuddingFluid.Flowing());

        PUDDING_BUCKET = Registry.register(Registry.ITEM, new ResourceLocation(PuddingMod.MOD_ID, "pudding_bucket"),
                new BucketItem(STILL_PUDDING, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(PuddingMod.PUDDING_TAB)));

        PUDDING = Registry.register(Registry.BLOCK, new ResourceLocation(PuddingMod.MOD_ID, "pudding"),
                new PuddingLiquidBlock(STILL_PUDDING, BlockBehaviour.Properties.copy(Blocks.WATER)));
    }
}
