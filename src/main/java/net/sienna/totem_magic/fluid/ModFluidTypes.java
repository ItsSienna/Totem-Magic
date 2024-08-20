package net.sienna.totem_magic.fluid;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.sienna.totem_magic.TotemMagic;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {

    //We're just grabbing the water textures and putting them in variables for use down below. Don't have to do this, we can just create our own!
    public static final ResourceLocation WATER_STILL_RL = ResourceLocation.parse("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = ResourceLocation.parse("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = ResourceLocation.parse("block/water_overlay");

    //Oh boy, here I go registering again
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, TotemMagic.MOD_ID);

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

    //Fluids!
    public static final Supplier<FluidType> TOTEM_ESSENCE_FLUID_TYPE = FLUID_TYPES.register("totem_essence_fluid_type", () ->
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xA1ff7f7f,
                    new Vector3f(255f/255f, 255f/255f, 255f/255f),
                    FluidType.Properties.create()
                            .canConvertToSource(true)
                            .canSwim(true)));
}
