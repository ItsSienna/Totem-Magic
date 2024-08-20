package net.sienna.totem_magic.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.block.custom.GenericTotemBlock;
import net.sienna.totem_magic.block.custom.ModWoodBlocks;
import net.sienna.totem_magic.block.custom.TotemTopperBlock;
import net.sienna.totem_magic.item.ModItems;
import net.sienna.totem_magic.worldgen.ModConfiguredFeatures;

import java.util.Optional;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TotemMagic.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> block) {
        DeferredBlock<Block> blockRegistry = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(blockRegistry.get(), new Item.Properties()));
        return blockRegistry;
    }

    public static final DeferredBlock<Block> TOTEM_TOPPER = registerBlock("totem_topper", () -> new TotemTopperBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).noOcclusion()));

    public static final DeferredBlock<Block> REGENERATION_TOTEM = registerBlock("regeneration_totem", () -> new GenericTotemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> SWIFTNESS_TOTEM = registerBlock("swiftness_totem", () -> new GenericTotemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE).noOcclusion()));
    public static final DeferredBlock<Block> HASTE_TOTEM = registerBlock("haste_totem", () -> new GenericTotemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).noOcclusion()));

    public static final DeferredBlock<Block> CERULAE_LOG = registerBlock("cerulae_log", () -> new ModWoodBlocks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> CERULAE_WOOD = registerBlock("cerulae_wood", () -> new ModWoodBlocks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> CERULAE_PLANKS = registerBlock("cerulae_planks", () -> new ModWoodBlocks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }
    });

    public static final DeferredBlock<Block> CRIMTAE_LOG = registerBlock("crimtae_log", () -> new ModWoodBlocks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> CRIMTAE_WOOD = registerBlock("crimtae_wood", () -> new ModWoodBlocks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> CRIMTAE_PLANKS = registerBlock("crimtae_planks", () -> new ModWoodBlocks(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }
    });

    public static final DeferredBlock<Block> CERULAE_LEAVES = registerBlock("cerulae_leaves", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 60; //This is just default for leaves
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 30; //This is just default for leaves
        }
    });

    public static final DeferredBlock<Block> CRIMTAE_LEAVES = registerBlock("crimtae_leaves", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 60; //This is just default for leaves
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 30; //This is just default for leaves
        }
    });

    public static final DeferredBlock<Block> CERULAE_SAPLING = registerBlock("cerulae_sapling", () -> new SaplingBlock(new TreeGrower("cerulae_tree", Optional.empty(), Optional.of(ModConfiguredFeatures.CERULAE_TREE), Optional.empty()), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> CRIMTAE_SAPLING = registerBlock("crimtae_sapling", () -> new SaplingBlock(new TreeGrower("crimtae_tree", Optional.empty(), Optional.of(ModConfiguredFeatures.CRIMTAE_TREE), Optional.empty()), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> CERULAE_STAIRS = registerBlock("cerulae_stairs", () -> new StairBlock(ModBlocks.CERULAE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<Block> CRIMTAE_STAIRS = registerBlock("crimtae_stairs", () -> new StairBlock(ModBlocks.CRIMTAE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));

    public static final DeferredBlock<Block> CERULAE_SLABS = registerBlock("cerulae_slabs", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final DeferredBlock<Block> CRIMTAE_SLABS = registerBlock("crimtae_slabs", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));

    public static final DeferredBlock<Block> CERULAE_BUTTON = registerBlock("cerulae_button", () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredBlock<Block> CRIMTAE_BUTTON = registerBlock("crimtae_button", () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final DeferredBlock<Block> CERULAE_PRESSURE_PLATE = registerBlock("cerulae_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PRESSURE_PLATE)));
    public static final DeferredBlock<Block> CRIMTAE_PRESSURE_PLATE = registerBlock("crimtae_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PRESSURE_PLATE)));

    public static final DeferredBlock<Block> CERULAE_FENCE = registerBlock("cerulae_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE)));
    public static final DeferredBlock<Block> CRIMTAE_FENCE = registerBlock("crimtae_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE)));

    public static final DeferredBlock<Block> CERULAE_FENCE_GATE = registerBlock("cerulae_fence_gate", () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE_GATE)));
    public static final DeferredBlock<Block> CRIMTAE_FENCE_GATE = registerBlock("crimtae_fence_gate", () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE_GATE)));

    public static final DeferredBlock<Block> CERULAE_TOTEM = registerBlock("cerulae_totem", () -> new GenericTotemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).noOcclusion()));
    public static final DeferredBlock<Block> CRIMTAE_TOTEM = registerBlock("crimtae_totem", () -> new GenericTotemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).noOcclusion()));

}
