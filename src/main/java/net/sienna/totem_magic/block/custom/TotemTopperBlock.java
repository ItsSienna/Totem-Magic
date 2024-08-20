package net.sienna.totem_magic.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sienna.totem_magic.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TotemTopperBlock extends HorizontalDirectionalBlock {
    public TotemTopperBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return null;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(0,0,0,16,16,16);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isClientSide) {
            Block blockOneBelow = level.getBlockState(pos.below()).getBlock();
            Boolean blockOneIsTotem;
            Block blockTwoBelow = level.getBlockState(pos.below(2)).getBlock();
            Boolean blockTwoIsTotem;
            Block blockThreeBelow = level.getBlockState(pos.below(3)).getBlock();
            if (blockOneBelow instanceof GenericTotemBlock) {
                blockOneIsTotem = true;
                applyRadiusEffect(pos, 10, level, blockOneBelow, 2);
            } else {blockOneIsTotem = false;}
            if (blockTwoBelow instanceof GenericTotemBlock && blockOneIsTotem) {
                blockTwoIsTotem = true;
                applyRadiusEffect(pos, 10, level, blockTwoBelow, 1);
            } else {blockTwoIsTotem = false;}
            if (blockTwoBelow instanceof GenericTotemBlock && blockOneIsTotem && blockTwoIsTotem) {
                applyRadiusEffect(pos, 10, level, blockThreeBelow, 0);
            }

        }
        level.scheduleTick(pos, this, 20);
    }


    private void applyRadiusEffect(BlockPos pos, double radius, ServerLevel level, Block block, int amplifier) {
        List<Entity> entitiesInRange = level.getEntities(null, new AABB(pos).inflate(radius));

        for (Entity entity : entitiesInRange) {
            if (entity instanceof Player livingEntity) {
                if (block == ModBlocks.REGENERATION_TOTEM.get()) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, amplifier, true, false));
                }
                if (block == ModBlocks.SWIFTNESS_TOTEM.get()) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, amplifier, true, false));
                }
                if (block == ModBlocks.HASTE_TOTEM.get()) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, amplifier, true, false));
                }
            }
        }
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        if(!level.isClientSide()) {
            level.scheduleTick(pos, this, 1);
        }
    }
}
