package net.sienna.totem_magic.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sienna.totem_magic.TotemMagic;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TotemMagic.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final DeferredItem<Item> TOTEM_HEART = ITEMS.registerSimpleItem("totem_heart");
}
