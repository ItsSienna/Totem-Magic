package net.sienna.totem_magic.datagen.texture;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TotemMagic.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() { //Registers all these as "normal" blocks
        horizontalBlock(ModBlocks.REGENERATION_TOTEM.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/regeneration_totem")));

        horizontalBlock(ModBlocks.TOTEM_TOPPER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/totem_topper")));

        horizontalBlock(ModBlocks.SWIFTNESS_TOTEM.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/swiftness_totem")));

        horizontalBlock(ModBlocks.HASTE_TOTEM.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/haste_totem")));

        horizontalBlock(ModBlocks.CRIMTAE_TOTEM.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/crimtae_totem")));

        horizontalBlock(ModBlocks.CERULAE_TOTEM.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/cerulae_totem")));


        logBlock((RotatedPillarBlock) ModBlocks.CRIMTAE_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.CERULAE_LOG.get());
        blockItem(ModBlocks.CRIMTAE_LOG.get());
        blockItem(ModBlocks.CERULAE_LOG.get());

        axisBlock((RotatedPillarBlock) ModBlocks.CRIMTAE_WOOD.get(), blockTexture(ModBlocks.CRIMTAE_LOG.get()), blockTexture(ModBlocks.CRIMTAE_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.CERULAE_WOOD.get(), blockTexture(ModBlocks.CERULAE_LOG.get()), blockTexture(ModBlocks.CERULAE_LOG.get()));
        blockItem(ModBlocks.CRIMTAE_WOOD.get());
        blockItem(ModBlocks.CERULAE_WOOD.get());

        leavesBlock(ModBlocks.CERULAE_LEAVES);
        leavesBlock(ModBlocks.CRIMTAE_LEAVES);

        saplingBlock(ModBlocks.CERULAE_SAPLING);
        saplingBlock(ModBlocks.CRIMTAE_SAPLING);

        normalBlock(ModBlocks.CERULAE_PLANKS.get());
        normalBlock(ModBlocks.CRIMTAE_PLANKS.get());

        buttonBlock((ButtonBlock) ModBlocks.CERULAE_BUTTON.get(), blockTexture(ModBlocks.CERULAE_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.CRIMTAE_BUTTON.get(), blockTexture(ModBlocks.CRIMTAE_PLANKS.get()));

        fenceBlock((FenceBlock) ModBlocks.CERULAE_FENCE.get(), blockTexture(ModBlocks.CERULAE_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.CRIMTAE_FENCE.get(), blockTexture(ModBlocks.CRIMTAE_PLANKS.get()));

        stairsBlock((StairBlock) ModBlocks.CERULAE_STAIRS.get(), blockTexture(ModBlocks.CERULAE_PLANKS.get()));
        stairsBlock((StairBlock) ModBlocks.CRIMTAE_STAIRS.get(), blockTexture(ModBlocks.CRIMTAE_PLANKS.get()));
        blockItem(ModBlocks.CERULAE_STAIRS.get());
        blockItem(ModBlocks.CRIMTAE_STAIRS.get());

        slabBlock((SlabBlock) ModBlocks.CERULAE_SLABS.get(), blockTexture(ModBlocks.CERULAE_PLANKS.get()), blockTexture(ModBlocks.CERULAE_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.CRIMTAE_SLABS.get(), blockTexture(ModBlocks.CRIMTAE_PLANKS.get()), blockTexture(ModBlocks.CRIMTAE_PLANKS.get()));
        blockItem(ModBlocks.CERULAE_SLABS.get());
        blockItem(ModBlocks.CRIMTAE_SLABS.get());

        pressurePlateBlock((PressurePlateBlock) ModBlocks.CERULAE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CERULAE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.CRIMTAE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CRIMTAE_PLANKS.get()));
        blockItem(ModBlocks.CERULAE_PRESSURE_PLATE.get());
        blockItem(ModBlocks.CRIMTAE_PRESSURE_PLATE.get());


        fenceGateBlock((FenceGateBlock) ModBlocks.CERULAE_FENCE_GATE.get(), blockTexture(ModBlocks.CERULAE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.CRIMTAE_FENCE_GATE.get(), blockTexture(ModBlocks.CRIMTAE_PLANKS.get()));
        blockItem(ModBlocks.CERULAE_FENCE_GATE.get());
        blockItem(ModBlocks.CRIMTAE_FENCE_GATE.get());







    }

    //This is for saplings
    private void saplingBlock(DeferredBlock<Block> block) {
        simpleBlock(block.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), blockTexture(block.get())).renderType("cutout"));
    }
    //This is for leaves - technically they also have a cutout (transparency)
    private void leavesBlock(DeferredBlock<Block> block) {
        simpleBlock(block.get(),
                models().cubeAll(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), blockTexture(block.get())).renderType("cutout"));
        simpleBlockItem(block.get(), models().getExistingFile(modLoc("block/" + block.getId().getPath())));
    }
    private void blockItem (Block block) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlockItem(block, models().getExistingFile(modLoc("block/" + path)));
    }
    private void blockItem (Block block, String appendix) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlockItem(block, models().getExistingFile(modLoc("block/" + path + appendix)));
    }

    //This is for specifically cube blocks
    private void normalBlock (Block block) { //Tells the game that a "normal" block is a block that uses the same texture on all six sides
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlock(block, models().cubeAll(path, modLoc("block/" + path)));
        simpleBlockItem(block, models().getExistingFile(modLoc("block/" + path)));
    }







}
