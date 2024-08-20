package net.sienna.totem_magic.datagen.texture;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.block.ModBlocks;
import net.sienna.totem_magic.fluid.ModFluids;
import net.sienna.totem_magic.item.ModItems;

public class ModItemStateProvider extends ItemModelProvider {

    public ModItemStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TotemMagic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        item(ModFluids.TOTEM_ESSENCE_BUCKET.get());
        item(ModItems.TOTEM_HEART.get());

        complexBlock(ModBlocks.REGENERATION_TOTEM.get());
        complexBlock(ModBlocks.TOTEM_TOPPER.get());
        complexBlock(ModBlocks.SWIFTNESS_TOTEM.get());
        complexBlock(ModBlocks.HASTE_TOTEM.get());
        complexBlock(ModBlocks.CERULAE_TOTEM.get());
        complexBlock(ModBlocks.CRIMTAE_TOTEM.get());

        saplingItem(ModBlocks.CRIMTAE_SAPLING);
        saplingItem(ModBlocks.CERULAE_SAPLING);

        buttomItem(ModBlocks.CERULAE_BUTTON.get(), ModBlocks.CERULAE_PLANKS.get());
        buttomItem(ModBlocks.CRIMTAE_BUTTON.get(), ModBlocks.CRIMTAE_PLANKS.get());

        fenceItem(ModBlocks.CERULAE_FENCE.get(), ModBlocks.CERULAE_PLANKS.get());
        fenceItem(ModBlocks.CRIMTAE_FENCE.get(), ModBlocks.CRIMTAE_PLANKS.get());

    }

    public ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(),
                ResourceLocation.fromNamespaceAndPath(TotemMagic.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(block).getPath()));
    }

    private void item(Item item) { //Tells the game where to find the item texture, and also what kind of item they are (item/generated is just regular item, not like a sword)
        String name = getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/" + name);
    }

    private String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(TotemMagic.MOD_ID + ":","");
    }

    public ItemModelBuilder saplingItem(DeferredBlock block) {
        return withExistingParent(block.getId().getPath(),
                mcLoc("item/generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(TotemMagic.MOD_ID, "block/" + block.getId().getPath()));
    }

    public void buttomItem(Block block, Block baseBlock) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        ResourceLocation baseBlockKey = BuiltInRegistries.BLOCK.getKey(baseBlock);
        this.withExistingParent(blockKey.getPath(), mcLoc("block/button_inventory"))
                .texture("texture", "block/" + baseBlockKey.getPath());
    }
    public void fenceItem(Block block, Block baseBlock) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        ResourceLocation baseBlockKey = BuiltInRegistries.BLOCK.getKey(baseBlock);
        this.withExistingParent(blockKey.getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", "block/" + baseBlockKey.getPath());
    }

}
