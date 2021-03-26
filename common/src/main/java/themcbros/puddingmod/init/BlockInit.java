package themcbros.puddingmod.init;

import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static themcbros.puddingmod.PuddingMod.MOD_ID;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registry.BLOCK_REGISTRY);
    public static final RegistrySupplier<Block> PUDDING_BLOCK = BLOCKS.register("pudding_block", () ->
            new SlimeBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)));

}
