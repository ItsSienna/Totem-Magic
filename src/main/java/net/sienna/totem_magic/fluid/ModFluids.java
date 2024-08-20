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

    //HERE I GO REGISTERING AGAIN... AGAIN! Before was fluid TYPES, now we're doing actual fluids
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, TotemMagic.MOD_ID);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

    //And here's our fluid! MAKE SURE THAT ONE IS .Source, AND THE OTHER IS .Flowing!!! AND ADD "FLOWING" TO THE NAME!
    public static final Supplier<FlowingFluid> SOURCE_TOTEM_ESSENCE = FLUIDS.register("source_totem_essence",
            () -> new BaseFlowingFluid.Source(ModFluids.TOTEM_ESSENCE_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_TOTEM_ESSENCE = FLUIDS.register("flowing_totem_essence",
            () -> new BaseFlowingFluid.Flowing(ModFluids.TOTEM_ESSENCE_PROPERTIES));

    //Custom fluid block! Call .noLootTables otherwise "issues", apparently...
    public static final DeferredBlock<LiquidBlock> TOTEM_ESSENCE_BLOCK = ModBlocks.BLOCKS.register("soap_water_block",
            () -> new TotemEssenceBlock(ModFluids.SOURCE_TOTEM_ESSENCE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    //Custom bucket! Craft remainder leaves the bucket behind, and it only stacks to 1.
    public static final DeferredItem<Item> TOTEM_ESSENCE_BUCKET = ModItems.ITEMS.register("totem_essence_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TOTEM_ESSENCE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    //Here we go, making the properties for soap water.
    //Have to add both the block and the bucket for this!
    //There's also buttloads of properties to have a look at :)
    public static final BaseFlowingFluid.Properties TOTEM_ESSENCE_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.TOTEM_ESSENCE_FLUID_TYPE, SOURCE_TOTEM_ESSENCE , FLOWING_TOTEM_ESSENCE)
            .slopeFindDistance(4).levelDecreasePerBlock(1).block(TOTEM_ESSENCE_BLOCK).bucket(TOTEM_ESSENCE_BUCKET);

    //ALL of the above (register method downwards) is used just for one fluid.
}
