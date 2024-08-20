package net.sienna.totem_magic.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.block.ModBlocks;

import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMTAE_TREE = registerKey("crimtae_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CERULAE_TREE = registerKey("cerulae_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ESSENCE_FOUNTAIN = registerKey("essence_fountain");

    public static ResourceKey<ConfiguredFeature<? ,?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TotemMagic.MOD_ID, name));
    }
    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<? ,?>> context, ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<? , ?>> context) {
        register(context, CERULAE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.CERULAE_LOG.get()),
                new CherryTrunkPlacer(6, 2, 1, ConstantInt.of(3), UniformInt.of(3, 4), UniformInt.of(-3, -2), UniformInt.of(-1, 0)),
                BlockStateProvider.simple(ModBlocks.CERULAE_LEAVES.get()),
                new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4), 0.3f, 0.3f, 0.2f, 0.5f),
                new TwoLayersFeatureSize(2, 0, 2)).dirt(BlockStateProvider.simple(Blocks.DIRT)).build());

        register(context, CRIMTAE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.CRIMTAE_LOG.get()),
                new DarkOakTrunkPlacer(9, 3, 1),
                BlockStateProvider.simple(ModBlocks.CRIMTAE_LEAVES.get()),
                new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).dirt(BlockStateProvider.simple(Blocks.DIRT)).build());
    }
}
