package net.sienna.totem_magic.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.util.ModTags;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_CRIMTAE_TREE = registerKey("add_crimtae_tree");
    public static final ResourceKey<BiomeModifier> ADD_CERULAE_TREE = registerKey("add_cerulae_tree");

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TotemMagic.MOD_ID, name));
    }

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_CRIMTAE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.IS_SACRED_GROVE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRIMTAE_PLACED_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CERULAE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.IS_SACRED_GROVE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CERULAE_PLACED_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}
