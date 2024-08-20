package net.sienna.totem_magic.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> CRIMTAE_PLACED_TREE = registerKey("crimtae_placed_tree");
    public static final ResourceKey<PlacedFeature> CERULAE_PLACED_TREE = registerKey("cerulae_placed_tree");

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TotemMagic.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<? ,?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CERULAE_PLACED_TREE, configuredFeatures.getOrThrow(ModConfiguredFeatures.CERULAE_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.2f, 4),
                        ModBlocks.CERULAE_SAPLING.get()));

        register(context, CRIMTAE_PLACED_TREE, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRIMTAE_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.2f, 4),
                        ModBlocks.CRIMTAE_SAPLING.get()));
    }
}
