package net.sienna.totem_magic.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class ModWoodBlocks extends RotatedPillarBlock {
    public ModWoodBlocks(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5; //This is just default for logs
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5; //This is just default for logs
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) { //Stripping!
            //For each new wood type, just create a new if statement for stripping.
//            if(state.is(ModBlocks.CERULAE_LOG.get())) {
//                return ModBlocks.STRIPPED_CERULAE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
//            }
//
//            if(state.is(ModBlocks.CERULAE_WOOD.get())) {
//                return ModBlocks.STRIPPED_CERULAE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
//            }

        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
