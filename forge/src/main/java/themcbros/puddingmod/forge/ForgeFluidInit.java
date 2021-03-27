package themcbros.puddingmod.forge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import themcbros.puddingmod.PuddingMod;

public class ForgeFluidInit {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PuddingMod.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PuddingMod.MOD_ID);
    private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, PuddingMod.MOD_ID);

    private static final RegistryObject<LiquidBlock> PUDDING_LIQUID = BLOCKS.register("pudding",
            () -> new LiquidBlock(ForgeFluidInit.PUDDING, BlockBehaviour.Properties.copy(Blocks.WATER)));

    private static final RegistryObject<BucketItem> PUDDING_BUCKET = ITEMS.register("pudding_bucket", () ->
            new BucketItem(ForgeFluidInit.PUDDING, new Item.Properties().tab(PuddingMod.PUDDING_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    private static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> ForgeFluidInit.PUDDING.get(), () -> ForgeFluidInit.FLOWING_PUDDING.get(),
            FluidAttributes.builder(
                    new ResourceLocation(PuddingMod.MOD_ID, "block/pudding_still"),
                    new ResourceLocation(PuddingMod.MOD_ID, "block/pudding_flow"))
                    .color(0xFFBF00).translationKey("block.puddingmod.pudding"))
            .bucket(ForgeFluidInit.PUDDING_BUCKET).block(ForgeFluidInit.PUDDING_LIQUID).explosionResistance(100.0F).slopeFindDistance(2)
            .levelDecreasePerBlock(2).tickRate(20);

    private static final RegistryObject<ForgeFlowingFluid> FLOWING_PUDDING = FLUIDS.register("flowing_pudding",
            () -> new ForgeFlowingFluid.Flowing(PROPERTIES));
    private static final RegistryObject<ForgeFlowingFluid> PUDDING = FLUIDS.register("pudding",
            () -> new ForgeFlowingFluid.Source(PROPERTIES));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
        FLUIDS.register(bus);
    }

}
