package net.sienna.totem_magic.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.sienna.totem_magic.TotemMagic;

public class ModWoodTypes {
    public static final WoodType CRIMTAE = WoodType.register(new WoodType(TotemMagic.MOD_ID +":crimtae", BlockSetType.OAK));
    public static final WoodType CERULAE = WoodType.register(new WoodType(TotemMagic.MOD_ID +":cerulae", BlockSetType.OAK));
}
