package net.sienna.totem_magic;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sienna.totem_magic.block.ModBlocks;
import net.sienna.totem_magic.fluid.ModFluids;
import net.sienna.totem_magic.item.ModItems;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TotemMagic.MOD_ID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MODCOURSE_ITEMS = CREATIVE_MODE_TABS.register("totem_magic", () -> CreativeModeTab.builder()
            .title(Component.literal("Totem Magic"))
            .icon(() -> Items.IRON_BLOCK.getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModBlocks.REGENERATION_TOTEM);
                output.accept(ModBlocks.TOTEM_TOPPER);
                output.accept(ModBlocks.SWIFTNESS_TOTEM);
                output.accept(ModBlocks.HASTE_TOTEM);
                output.accept(ModFluids.TOTEM_ESSENCE_BUCKET);
                output.accept(ModBlocks.CRIMTAE_LEAVES);
                output.accept(ModBlocks.CRIMTAE_SAPLING);
                output.accept(ModBlocks.CRIMTAE_LOG);
                output.accept(ModBlocks.CRIMTAE_WOOD);
                output.accept(ModBlocks.CRIMTAE_PLANKS);
                output.accept(ModBlocks.CERULAE_LEAVES);
                output.accept(ModBlocks.CERULAE_LOG);
                output.accept(ModBlocks.CERULAE_WOOD);
                output.accept(ModBlocks.CERULAE_PLANKS);
                output.accept(ModBlocks.CERULAE_BUTTON);
                output.accept(ModBlocks.CERULAE_STAIRS);
                output.accept(ModBlocks.CERULAE_SLABS);
                output.accept(ModBlocks.CERULAE_FENCE_GATE);
                output.accept(ModBlocks.CERULAE_FENCE);
                output.accept(ModBlocks.CERULAE_PRESSURE_PLATE);
                output.accept(ModBlocks.CRIMTAE_BUTTON);
                output.accept(ModBlocks.CRIMTAE_FENCE);
                output.accept(ModBlocks.CRIMTAE_STAIRS);
                output.accept(ModBlocks.CRIMTAE_SLABS);
                output.accept(ModBlocks.CRIMTAE_FENCE_GATE);
                output.accept(ModBlocks.CRIMTAE_PRESSURE_PLATE);
                output.accept(ModBlocks.CERULAE_TOTEM);
                output.accept(ModBlocks.CRIMTAE_TOTEM);
                output.accept(ModItems.TOTEM_HEART);


            }).build());

}
