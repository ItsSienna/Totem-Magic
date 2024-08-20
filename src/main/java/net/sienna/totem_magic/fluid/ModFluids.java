package net.sienna.totem_magic.fluid;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sienna.totem_magic.TotemMagic;
import net.sienna.totem_magic.block.ModBlocks;
import net.sienna.totem_magic.fluid.custom.TotemEssenceBlock;
import net.sienna.totem_magic.item.ModItems;

import java.util.function.Supplier;

public class ModFluids {


    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, TotemMagic.MOD_ID);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }


    public static final Supplier<FlowingFluid> SOURCE_TOTEM_ESSENCE = FLUIDS.register("source_totem_essence",
            () -> new BaseFlowingFluid.Source(ModFluids.TOTEM_ESSENCE_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_TOTEM_ESSENCE = FLUIDS.register("flowing_totem_essence",
            () -> new BaseFlowingFluid.Flowing(ModFluids.TOTEM_ESSENCE_PROPERTIES));


    public static final DeferredBlock<LiquidBlock> TOTEM_ESSENCE_BLOCK = ModBlocks.BLOCKS.register("soap_water_block",
            () -> new TotemEssenceBlock(ModFluids.SOURCE_TOTEM_ESSENCE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));

    public static final DeferredItem<Item> TOTEM_ESSENCE_BUCKET = ModItems.ITEMS.register("totem_essence_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TOTEM_ESSENCE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final BaseFlowingFluid.Properties TOTEM_ESSENCE_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.TOTEM_ESSENCE_FLUID_TYPE, SOURCE_TOTEM_ESSENCE , FLOWING_TOTEM_ESSENCE)
            .slopeFindDistance(4).levelDecreasePerBlock(1).block(TOTEM_ESSENCE_BLOCK).bucket(TOTEM_ESSENCE_BUCKET);


}
