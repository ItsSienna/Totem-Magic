package net.sienna.totem_magic.datagen.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.block.ModBlocks;
import net.sienna.totem_magic.fluid.ModFluids;
import net.sienna.totem_magic.item.ModItems;

public class ModLangProvider extends LanguageProvider {

    public ModLangProvider(PackOutput output) {
        super(output, TotemMagic.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //Items
        addItem(ModFluids.TOTEM_ESSENCE_BUCKET, "Bucket of Totem Essence");
        //Blocks
        addBlock(ModBlocks.REGENERATION_TOTEM, "Regeneration Totem");
        addBlock(ModBlocks.TOTEM_TOPPER, "Totem Topper");
        addBlock(ModBlocks.SWIFTNESS_TOTEM, "Swiftness Totem");
        addBlock(ModBlocks.HASTE_TOTEM, "Haste Totem");
        addBlock(ModFluids.TOTEM_ESSENCE_BLOCK, "Totem Essence");
        addBlock(ModBlocks.CERULAE_LOG, "Cerulae Log");
        addBlock(ModBlocks.CERULAE_PLANKS, "Cerulae Planks");
        addBlock(ModBlocks.CERULAE_WOOD, "Cerulae Wood");
        addBlock(ModBlocks.CERULAE_LEAVES, "Cerulae Leaves");
        addBlock(ModBlocks.CRIMTAE_LOG, "Crimtae Log");
        addBlock(ModBlocks.CRIMTAE_PLANKS, "Crimtae Planks");
        addBlock(ModBlocks.CRIMTAE_WOOD, "Crimtae Wood");
        addBlock(ModBlocks.CRIMTAE_LEAVES, "Crimtae Leaves");
        addBlock(ModBlocks.CERULAE_SAPLING, "Cerulae Sapling");
        addBlock(ModBlocks.CERULAE_TOTEM, "Cerulae Totem");
        addBlock(ModBlocks.CERULAE_BUTTON, "Cerulae Button");
        addBlock(ModBlocks.CERULAE_FENCE, "Cerulae Fence");
        addBlock(ModBlocks.CERULAE_STAIRS, "Cerulae Stairs");
        addBlock(ModBlocks.CERULAE_FENCE_GATE, "Cerulae Fence Gate");
        addBlock(ModBlocks.CERULAE_SLABS, "Cerulae Slab");
        addBlock(ModBlocks.CERULAE_PRESSURE_PLATE, "Cerulae Pressure Plate");
        addBlock(ModBlocks.CRIMTAE_TOTEM, "Crimtae Totem");
        addBlock(ModBlocks.CRIMTAE_BUTTON, "Crimtae Button");
        addBlock(ModBlocks.CRIMTAE_FENCE, "Crimtae Fence");
        addBlock(ModBlocks.CRIMTAE_STAIRS, "Crimtae Stairs");
        addBlock(ModBlocks.CRIMTAE_FENCE_GATE, "Crimtae Fence Gate");
        addBlock(ModBlocks.CRIMTAE_SLABS, "Crimtae Slab");
        addBlock(ModBlocks.CRIMTAE_PRESSURE_PLATE, "Crimtae Pressure Plate");
        addItem(ModItems.TOTEM_HEART, "Totem Heart");
    }
}
