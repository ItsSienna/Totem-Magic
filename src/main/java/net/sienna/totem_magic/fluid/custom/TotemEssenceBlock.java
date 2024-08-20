package net.sienna.totem_magic.fluid.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sienna.totem_magic.block.ModBlocks;
import net.sienna.totem_magic.item.ModItems;

import java.util.HashMap;
import java.util.List;

public class TotemEssenceBlock extends LiquidBlock {
    public TotemEssenceBlock(FlowingFluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        level.scheduleTick(pos, this, 1);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isClientSide) {
            List<Entity> entitiesInRange = level.getEntities(null, new AABB(pos));
            for (Entity entity : entitiesInRange) {
                if(entity instanceof ItemEntity) {
                    ItemEntity potentialTotem = ((ItemEntity) entity);
                    Item potentialTotemItem = ((ItemEntity) entity).getItem().getItem();

                    //CRIMTAE CRAFTING RECIPES:
                    if(potentialTotemItem == ModBlocks.CRIMTAE_TOTEM.asItem()) {
                        Vec3 totemPos = potentialTotem.position();
                        if(entitiesInRange.stream().filter(checkingEntity -> checkingEntity instanceof ItemEntity)
                                .map(checkingEntity -> (ItemEntity) checkingEntity)
                                .anyMatch(checkingItemEntity -> checkingItemEntity.getItem().getItem() == Items.DIAMOND)) {

                            //TOTEMS FROM CRIMTAE
                            if(entitiesInRange.stream().filter(checkingEntity -> checkingEntity instanceof ItemEntity)
                                    .map(checkingEntity -> (ItemEntity) checkingEntity)
                                    .anyMatch(checkingItemEntity -> checkingItemEntity.getItem().getItem() == Items.REDSTONE_BLOCK)) {

                                //Calls the crafting method with the ingredient and the totem
                                craftingMethod(level, totemPos, entitiesInRange, Items.REDSTONE_BLOCK, ModBlocks.CRIMTAE_TOTEM.asItem());
                            }
                            if(entitiesInRange.stream().filter(checkingEntity -> checkingEntity instanceof ItemEntity)
                                    .map(checkingEntity -> (ItemEntity) checkingEntity)
                                    .anyMatch(checkingItemEntity -> checkingItemEntity.getItem().getItem() == Items.ICE)) {

                                craftingMethod(level, totemPos, entitiesInRange, Items.ICE, ModBlocks.CRIMTAE_TOTEM.asItem());
                            }
                            if(entitiesInRange.stream().filter(checkingEntity -> checkingEntity instanceof ItemEntity)
                                    .map(checkingEntity -> (ItemEntity) checkingEntity)
                                    .anyMatch(checkingItemEntity -> checkingItemEntity.getItem().getItem() == ModItems.TOTEM_HEART.get())) {

                                craftingMethod(level, totemPos, entitiesInRange, ModItems.TOTEM_HEART.get(), ModBlocks.CRIMTAE_TOTEM.asItem());
                            }



                        }

                    }

                    if(potentialTotemItem == ModBlocks.CERULAE_TOTEM.asItem()) {
                        Vec3 totemPos = potentialTotem.position();
                        if(entitiesInRange.stream().filter(checkingEntity -> checkingEntity instanceof ItemEntity)
                                .map(checkingEntity -> (ItemEntity) checkingEntity)
                                .anyMatch(checkingItemEntity -> checkingItemEntity.getItem().getItem() == Items.DIAMOND)) {

                            //TOTEMS FROM CERULAE
                            if(entitiesInRange.stream().filter(checkingEntity -> checkingEntity instanceof ItemEntity)
                                    .map(checkingEntity -> (ItemEntity) checkingEntity)
                                    .anyMatch(checkingItemEntity -> checkingItemEntity.getItem().getItem() == Items.DIAMOND_BLOCK)) {

                                craftingMethod(level, totemPos, entitiesInRange, Items.DIAMOND_BLOCK, ModBlocks.CERULAE_TOTEM.asItem());
                            }
                            if(entitiesInRange.stream().filter(checkingEntity -> checkingEntity instanceof ItemEntity)
                                    .map(checkingEntity -> (ItemEntity) checkingEntity)
                                    .anyMatch(checkingItemEntity -> checkingItemEntity.getItem().getItem() == ModItems.TOTEM_HEART.get())) {

                                craftingMethod(level, totemPos, entitiesInRange, ModItems.TOTEM_HEART.get(), ModBlocks.CERULAE_TOTEM.asItem());
                            }

                        }
                    }

                }
            }
        }
        level.scheduleTick(pos, this, 1);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        level.scheduleTick(pos, this, 1);
    }

    private static void doEffects(ServerLevel level, Vec3 totemPos) {
        level.sendParticles(ParticleTypes.DRAGON_BREATH, totemPos.x, totemPos.y, totemPos.z, 25, 0.1, 0.1, 0.1, 0.3d);
        level.playSeededSound(null, totemPos.x, totemPos.y, totemPos.z, SoundEvents.ALLAY_AMBIENT_WITH_ITEM, SoundSource.BLOCKS, 1f, 1f, 0);
    }

    private static void craftingMethod(ServerLevel level, Vec3 totemPos, List<Entity> entitiesInRange, Item ingredient, Item totem) {
        HashMap<Item, Block> ingredientToTotem = new HashMap<>();
        ingredientToTotem.put(Blocks.REDSTONE_BLOCK.asItem(), ModBlocks.REGENERATION_TOTEM.get());
        ingredientToTotem.put(Blocks.DIAMOND_BLOCK.asItem(), ModBlocks.HASTE_TOTEM.get());
        ingredientToTotem.put(Blocks.ICE.asItem(), ModBlocks.SWIFTNESS_TOTEM.get());
        ingredientToTotem.put(ModItems.TOTEM_HEART.get(), ModBlocks.TOTEM_TOPPER.get());

        doEffects(level, totemPos);
        Boolean hasRemovedTotem = false;
        Boolean hasRemovedDiamond = false;
        Boolean hasRemovedIngredient = false;

        //Checking the surrounding entities and replacing the totem (whatever the input "totem" is) with the crafted totem (from the hashmap, from its ingredient)
        for (Entity removeEntity : entitiesInRange) {
            ItemEntity removeEntityAsItemEntity = ((ItemEntity) removeEntity);
            if(removeEntityAsItemEntity.getItem().getItem() == totem && !hasRemovedTotem){
                if (removeEntityAsItemEntity.getItem().getCount() > 1) {
                    removeEntityAsItemEntity.getItem().shrink(1);
                } else {
                    removeEntity.remove(Entity.RemovalReason.DISCARDED);
                }
                level.addFreshEntity(new ItemEntity(level, totemPos.x, totemPos.y, totemPos.z, ingredientToTotem.get(ingredient).asItem().getDefaultInstance()));
//                ItemStack newTotem = ingredientToTotem.get(ingredient).asItem().getDefaultInstance();
//                ((ItemEntity) removeEntity).setItem(newTotem);
                hasRemovedTotem = true;
            }

            //Check and remove the diamond (only one copy)
            if(removeEntityAsItemEntity.getItem().getItem() == Items.DIAMOND && !hasRemovedDiamond) {
                if (removeEntityAsItemEntity.getItem().getCount() > 1) {
                    removeEntityAsItemEntity.getItem().shrink(1);
                } else {
                    removeEntity.remove(Entity.RemovalReason.DISCARDED);
                }
                hasRemovedDiamond = true;
            }

            //Check and remove the ingredient (only one copy)
            if(removeEntityAsItemEntity.getItem().getItem() == ingredient && !hasRemovedIngredient) {
                if (removeEntityAsItemEntity.getItem().getCount() > 1) {
                    removeEntityAsItemEntity.getItem().shrink(1);
                } else {
                    removeEntity.remove(Entity.RemovalReason.DISCARDED);
                }
                hasRemovedIngredient = true;
            }

        }

    }


}
