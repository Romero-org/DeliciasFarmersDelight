package org.romero.delicias.common.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

// https://mcsrc.dev/1/26.2/net/minecraft/references/BlockItemId

public record BlockItemId(ResourceKey<Block> block, ResourceKey<Item> item) {
    public static BlockItemId create(final ResourceLocation blockId, final ResourceLocation itemId) {
        return new BlockItemId(ResourceKey.create(Registries.BLOCK, blockId), ResourceKey.create(Registries.ITEM, itemId));
    }

    public static BlockItemId create(final String blockName, final String itemName) {
        return create(ResourceLocation.withDefaultNamespace(blockName), ResourceLocation.withDefaultNamespace(itemName));
    }

    public static BlockItemId create(final String name) {
        ResourceLocation id = ResourceLocation.withDefaultNamespace(name);
        return create(id, id);
    }
}
