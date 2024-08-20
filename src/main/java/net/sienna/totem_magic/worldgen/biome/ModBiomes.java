package net.sienna.totem_magic.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.worldgen.ModPlacedFeatures;

public class ModBiomes {

    public static final ResourceKey<Biome> SACRED_GROVE = register("sacred_grove");

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(SACRED_GROVE, sacredGrove(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(TotemMagic.MOD_ID, name));
    }

    public static Biome sacredGrove(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        //We're also adding farm animals (pigs, cows etc)
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        //We're grabbing all the default stuff here, and we're even grabbing extra gold (like mesas!)
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);

        //We're adding the plains trees placement to our biome
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

        //We're adding our walnut trees and snapdragons
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CERULAE_PLACED_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CRIMTAE_PLACED_TREE);

        //This is the super interesting thing.
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build()) //Generation settings (hills, mountains)
                .mobSpawnSettings(spawnBuilder.build()) //Mob spawn settings
                .specialEffects((new BiomeSpecialEffects.Builder()) //Change the colour of things!
                        .waterColor(0x5284FF)
                        .waterFogColor(0x82A6FF)
                        .fogColor(0x82A6FF)
                        .skyColor(0x4BE1FF)
                        .grassColorOverride(0x00D32D).build())
                .build();
    }
}
