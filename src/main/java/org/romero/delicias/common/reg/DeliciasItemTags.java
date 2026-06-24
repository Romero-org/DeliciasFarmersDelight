package org.romero.delicias.common.reg;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.romero.delicias.DeliciasFD;

public class DeliciasItemTags {

    private static TagKey<Item> create(String name) {
        return TagKey.create(Registries.ITEM, DeliciasFD.id(name));
    }
}
