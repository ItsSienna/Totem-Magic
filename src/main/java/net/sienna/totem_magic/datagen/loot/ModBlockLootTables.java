package net.sienna.totem_magic.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.block.ModBlocks;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.REGENERATION_TOTEM.get());
        dropSelf(ModBlocks.TOTEM_TOPPER.get());
        dropSelf(ModBlocks.SWIFTNESS_TOTEM.get());
        dropSelf(ModBlocks.HASTE_TOTEM.get());
        dropSelf(ModBlocks.CERULAE_PLANKS.get());
        dropSelf(ModBlocks.CERULAE_LOG.get());
        dropSelf(ModBlocks.CERULAE_WOOD.get());
        dropSelf(ModBlocks.CRIMTAE_LOG.get());
        dropSelf(ModBlocks.CRIMTAE_PLANKS.get());
        dropSelf(ModBlocks.CRIMTAE_WOOD.get());
        dropSelf(ModBlocks.CRIMTAE_SAPLING.get());
        dropSelf(ModBlocks.CERULAE_SAPLING.get());

        dropSelf(ModBlocks.CRIMTAE_STAIRS.get());
        dropSelf(ModBlocks.CERULAE_STAIRS.get());

        dropSelf(ModBlocks.CRIMTAE_SLABS.get());
        dropSelf(ModBlocks.CERULAE_SLABS.get());

        dropSelf(ModBlocks.CRIMTAE_BUTTON.get());
        dropSelf(ModBlocks.CERULAE_BUTTON.get());

        dropSelf(ModBlocks.CRIMTAE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.CERULAE_PRESSURE_PLATE.get());

        dropSelf(ModBlocks.CRIMTAE_FENCE_GATE.get());
        dropSelf(ModBlocks.CERULAE_FENCE_GATE.get());

        dropSelf(ModBlocks.CRIMTAE_FENCE.get());
        dropSelf(ModBlocks.CERULAE_FENCE.get());

        dropSelf(ModBlocks.CERULAE_LEAVES.get());
        dropSelf(ModBlocks.CRIMTAE_LEAVES.get());

        dropSelf(ModBlocks.CERULAE_TOTEM.get());
        dropSelf(ModBlocks.CRIMTAE_TOTEM.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(TotemMagic.MOD_ID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}
