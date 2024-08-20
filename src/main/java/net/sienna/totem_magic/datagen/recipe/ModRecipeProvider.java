package net.sienna.totem_magic.datagen.recipe;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.sienna.totem_magic.block.ModBlocks;
import net.sienna.totem_magic.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        stairBuilder(ModBlocks.CERULAE_STAIRS.get(), Ingredient.of(ModBlocks.CERULAE_PLANKS))
                .unlockedBy("has_cerulae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CERULAE_PLANKS.get()).build()))
                .save(recipeOutput);
        slabBuilder(RecipeCategory.MISC, ModBlocks.CERULAE_SLABS.get(), Ingredient.of(ModBlocks.CERULAE_PLANKS))
                .unlockedBy("has_cerulae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CERULAE_PLANKS.get()).build()))
                .save(recipeOutput);
        buttonBuilder(ModBlocks.CERULAE_BUTTON.get(), Ingredient.of(ModBlocks.CERULAE_PLANKS))
                .unlockedBy("has_cerulae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CERULAE_PLANKS.get()).build()))
                .save(recipeOutput);
        fenceBuilder(ModBlocks.CERULAE_FENCE.get(), Ingredient.of(ModBlocks.CERULAE_PLANKS))
                .unlockedBy("has_cerulae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CERULAE_PLANKS.get()).build()))
                .save(recipeOutput);
        fenceGateBuilder(ModBlocks.CERULAE_FENCE_GATE.get(), Ingredient.of(ModBlocks.CERULAE_PLANKS))
                .unlockedBy("has_cerulae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CERULAE_PLANKS.get()).build()))
                .save(recipeOutput);
        pressurePlateBuilder(RecipeCategory.MISC, ModBlocks.CERULAE_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.CERULAE_PLANKS))
                .unlockedBy("has_cerulae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CERULAE_PLANKS.get()).build()))
                .save(recipeOutput);

        stairBuilder(ModBlocks.CRIMTAE_STAIRS.get(), Ingredient.of(ModBlocks.CRIMTAE_PLANKS))
                .unlockedBy("has_crimtae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CRIMTAE_PLANKS.get()).build()))
                .save(recipeOutput);
        slabBuilder(RecipeCategory.MISC, ModBlocks.CRIMTAE_SLABS.get(), Ingredient.of(ModBlocks.CRIMTAE_PLANKS))
                .unlockedBy("has_crimtae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CRIMTAE_PLANKS.get()).build()))
                .save(recipeOutput);
        buttonBuilder(ModBlocks.CRIMTAE_BUTTON.get(), Ingredient.of(ModBlocks.CRIMTAE_PLANKS))
                .unlockedBy("has_crimtae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CRIMTAE_PLANKS.get()).build()))
                .save(recipeOutput);
        fenceBuilder(ModBlocks.CRIMTAE_FENCE.get(), Ingredient.of(ModBlocks.CRIMTAE_PLANKS))
                .unlockedBy("has_crimtae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CRIMTAE_PLANKS.get()).build()))
                .save(recipeOutput);
        fenceGateBuilder(ModBlocks.CRIMTAE_FENCE_GATE.get(), Ingredient.of(ModBlocks.CRIMTAE_PLANKS))
                .unlockedBy("has_crimtae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CRIMTAE_PLANKS.get()).build()))
                .save(recipeOutput);
        pressurePlateBuilder(RecipeCategory.MISC, ModBlocks.CRIMTAE_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.CRIMTAE_PLANKS))
                .unlockedBy("has_crimtae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CRIMTAE_PLANKS.get()).build()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CERULAE_PLANKS.get(), 4)
                .requires(ModBlocks.CERULAE_LOG.get())
                .unlockedBy("has_cerulae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CERULAE_PLANKS.get()).build()))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMTAE_PLANKS.get(), 4)
                .requires(ModBlocks.CRIMTAE_LOG.get())
                .unlockedBy("has_crimtae", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CRIMTAE_PLANKS.get()).build()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CERULAE_TOTEM.get())
                .pattern(" A ")
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModBlocks.CERULAE_LOG)
                .unlockedBy("has_cerulae_log", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CERULAE_LOG.get()).build()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRIMTAE_TOTEM.get())
                .pattern(" A ")
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModBlocks.CRIMTAE_LOG)
                .unlockedBy("has_crimtae_log", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CRIMTAE_LOG.get()).build()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TOTEM_HEART.get())
                .pattern("GGG")
                .pattern("WNW")
                .pattern("GGG")
                .define('G', Items.GOLD_INGOT)
                .define('W', ModBlocks.CRIMTAE_PLANKS)
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy("has_netherite", inventoryTrigger(ItemPredicate.Builder.item().of(Items.NETHERITE_INGOT).build()))
                .save(recipeOutput);
    }
}
