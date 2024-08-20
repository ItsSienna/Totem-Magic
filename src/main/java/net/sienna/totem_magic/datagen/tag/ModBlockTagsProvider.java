package net.sienna.totem_magic.datagen.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TotemMagic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.FENCES)
                .add(ModBlocks.CRIMTAE_FENCE.get())
                .add(ModBlocks.CERULAE_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.CRIMTAE_FENCE_GATE.get())
                .add(ModBlocks.CERULAE_FENCE_GATE.get());

        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CERULAE_LOG.get())
                .add(ModBlocks.CERULAE_WOOD.get())
                .add(ModBlocks.CRIMTAE_WOOD.get())
                .add(ModBlocks.CRIMTAE_LOG.get());

        tag(BlockTags.PLANKS)
                .add(ModBlocks.CERULAE_PLANKS.get())
                .add(ModBlocks.CRIMTAE_PLANKS.get());
    }
}
