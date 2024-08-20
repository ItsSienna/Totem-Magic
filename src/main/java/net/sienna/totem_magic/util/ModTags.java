package net.sienna.totem_magic.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.sienna.totem_magic.TotemMagic;

public class ModTags {
    public static class Biomes {
        public static final TagKey<Biome> IS_SACRED_GROVE = modBiomeTag("is_sacred_grove");
    }

    private static TagKey<Biome> modBiomeTag(String name) {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(TotemMagic.MOD_ID, name));
    }
}
