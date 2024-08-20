package net.sienna.totem_magic.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.sienna.totem_magic.datagen.lang.ModLangProvider;
import net.sienna.totem_magic.datagen.loot.ModLootTables;
import net.sienna.totem_magic.datagen.recipe.ModRecipeProvider;
import net.sienna.totem_magic.datagen.tag.ModBiomeTagsProvider;
import net.sienna.totem_magic.datagen.tag.ModBlockTagsProvider;
import net.sienna.totem_magic.datagen.texture.ModBlockStateProvider;
import net.sienna.totem_magic.datagen.texture.ModItemStateProvider;
import net.sienna.totem_magic.datagen.worldgen.ModWorldGenProvider;

import java.util.concurrent.CompletableFuture;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new ModLangProvider(output));

        generator.addProvider(true, new ModItemStateProvider(output, existingFileHelper));
        generator.addProvider(true, new ModBlockStateProvider(output, existingFileHelper));

        generator.addProvider(true, new ModLootTables(output, lookupProvider));


        generator.addProvider(true, new ModBlockTagsProvider(output, lookupProvider, existingFileHelper));

        generator.addProvider(true, new ModWorldGenProvider(output, lookupProvider));

        generator.addProvider(true, new ModRecipeProvider(output, lookupProvider));

    }
}
