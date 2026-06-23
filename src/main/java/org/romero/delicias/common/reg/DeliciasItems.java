package org.romero.delicias.common.reg;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.romero.delicias.common.reg.ids.DeliciasBlockItemIds;
import org.romero.delicias.common.util.BlockItemId;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public final class DeliciasItems {

    private DeliciasItems() {}

    public static Item WILD_GARLIC = registerBlock(DeliciasBlockItemIds.WILD_GARLIC, DeliciasBlocks.WILD_GARLIC);

    public static Item GARLIC = registerItem(DeliciasBlockItemIds.GARLIC_CROP, createBlockItemWithCustomItemName(DeliciasBlocks.GARLIC), new Item.Properties().food(DeliciasFoodProperties.GARLIC));

    public static Item ROSEMARY = registerBlock(DeliciasBlockItemIds.ROSEMARY, DeliciasBlocks.ROSEMARY);

    public static Item ROSE = registerBlock(DeliciasBlockItemIds.ROSE, DeliciasBlocks.ROSE);

    private static Function<Item.Properties, Item> createBlockItemWithCustomItemName(final Block block) {
        return p -> new BlockItem(block, p);
    }

    private static Item registerBlock(final BlockItemId id, final Block block) {
        return registerBlock(id, block, BlockItem::new);
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final Item.Properties properties) {
        return registerBlock(id, block, BlockItem::new, properties);
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final UnaryOperator<Item.Properties> propertiesFunction) {
        return registerBlock(id, block, (b, p) -> new BlockItem(b, propertiesFunction.apply(p)));
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final Block... alternatives) {
        Item item = registerBlock(id, block);

        for (Block alternative : alternatives) {
            Item.BY_BLOCK.put(alternative, item);
        }

        return item;
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory) {
        return registerBlock(id, block, itemFactory, new Item.Properties());
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties) {
        return registerItem(id.item(), p -> itemFactory.apply(block, p), properties);
    }

    private static Item registerItem(final ResourceKey<Item> id, final Item.Properties properties) {
        return registerItem(id, Item::new, properties);
    }

    private static Item registerItem(final ResourceKey<Item> id) {
        return registerItem(id, Item::new, new Item.Properties());
    }

    private static Item registerItem(final BlockItemId id, final Function<Item.Properties, Item> itemFactory) {
        return registerItem(id.item(), itemFactory);
    }

    private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory) {
        return registerItem(id, itemFactory, new Item.Properties());
    }

    private static Item registerItem(final BlockItemId id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        return registerItem(id.item(), itemFactory, properties);
    }

    private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        Item item = itemFactory.apply(properties);
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void init() {}
}
