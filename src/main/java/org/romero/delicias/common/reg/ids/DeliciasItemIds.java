package org.romero.delicias.common.reg.ids;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.romero.delicias.DeliciasFD;

public final class DeliciasItemIds {

    public static final ResourceKey<Item> OLIVES = create("olives");

    public static final ResourceKey<Item> OIL_BOTTLE = create("oil_bottle");

    public static final ResourceKey<Item> CALAMARI = create("calamari");

    public static final ResourceKey<Item> RAISINS = create("raisins");

    private DeliciasItemIds() {}

    private static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, DeliciasFD.id(name));
    }
}
