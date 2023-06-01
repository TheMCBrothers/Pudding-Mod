package net.themcbrothers.puddingmod;

import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.core.fluid.ArchitecturyFluidAttributes;
import dev.architectury.core.fluid.SimpleArchitecturyFluidAttributes;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

/**
 * @author TheMCLoveMan
 */
public class PuddingFluids {
    public static final DeferredRegister<Fluid> REGISTER = DeferredRegister.create(PuddingMod.MOD_ID, Registries.FLUID);

    private static final ArchitecturyFluidAttributes ATTRIBUTES = SimpleArchitecturyFluidAttributes.ofSupplier(() -> PuddingFluids.FLOWING_PUDDING, () -> PuddingFluids.PUDDING)
            .blockSupplier(() -> PuddingBlocks.PUDDING)
            .bucketItemSupplier(() -> PuddingItems.PUDDING_BUCKET)
            .explosionResistance(100.0F)
            .tickDelay(20)
            .slopeFindDistance(2)
            .dropOff(2)
            .sourceTexture(PuddingMod.location("block/pudding_still"))
            .flowingTexture(PuddingMod.location("block/pudding_flow"));

    public static final RegistrySupplier<FlowingFluid> PUDDING = REGISTER.register("pudding",
            () -> new ArchitecturyFlowingFluid.Source(ATTRIBUTES));
    public static final RegistrySupplier<FlowingFluid> FLOWING_PUDDING = REGISTER.register("flowing_pudding",
            () -> new ArchitecturyFlowingFluid.Flowing(ATTRIBUTES));

    static void register() {
        REGISTER.register();
    }
}
