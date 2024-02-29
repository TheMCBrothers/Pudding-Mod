package net.themcbrothers.puddingmod;

import dev.architectury.core.block.ArchitecturyLiquidBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * @author TheMCLoveMan
 */
public class PuddingBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(PuddingMod.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<LiquidBlock> PUDDING = REGISTER.register("pudding", () ->
            new ArchitecturyLiquidBlock(PuddingFluids.PUDDING, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));
    public static final RegistrySupplier<Block> PUDDING_BLOCK = REGISTER.register("pudding_block", () ->
            new SlimeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SLIME_BLOCK)));

    static void register() {
        REGISTER.register();
    }
}
