package net.sienna.totem_magic.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.worldgen.biome.custom.ModOverworldRegion;
import terrablender.api.Regions;

public class TerrablenderAPI {
    public static void registerRegions() { //This weight determines how much of the original biome will be replaced.
        Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath(TotemMagic.MOD_ID, "overworld"), 2));
    }
}
