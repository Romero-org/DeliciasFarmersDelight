package org.romero.delicias.common.reg;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.romero.delicias.common.reg.ids.DeliciasBlockItemIds;
import org.romero.delicias.common.reg.ids.DeliciasItemIds;
import org.romero.delicias.common.util.BlockItemId;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public final class DeliciasItems {

    private DeliciasItems() {}

    public static Item WILD_GARLIC = registerBlock(DeliciasBlockItemIds.WILD_GARLIC, DeliciasBlocks.WILD_GARLIC);

    public static Item GARLIC = registerItem(DeliciasBlockItemIds.GARLIC_CROP, createBlockItemWithCustomItemName(DeliciasBlocks.GARLIC), ModItems.foodItem(DeliciasFoodProperties.GARLIC));

    public static Item OLIVES = registerItem(DeliciasItemIds.OLIVES, ModItems.foodItem(DeliciasFoodProperties.OLIVES));

    public static Item OIL_BOTTLE = registerItem(DeliciasItemIds.OIL_BOTTLE, (props) -> new DrinkableItem(props, true, false), ModItems.drinkItem().food(DeliciasFoodProperties.OIL_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16));

    public static Item CALAMARI = registerItem(DeliciasItemIds.CALAMARI, ModItems.foodItem(DeliciasFoodProperties.CALAMARI));

    public static Item RAISINS = registerItem(DeliciasItemIds.RAISINS, ModItems.foodItem(DeliciasFoodProperties.RAISINS));

    public static Item RAISIN_BREAD = registerItem(DeliciasItemIds.RAISIN_BREAD, ModItems.foodItem(DeliciasFoodProperties.RAISIN_BREAD));

    public static Item GARLIC_BREAD = registerItem(DeliciasItemIds.GARLIC_BREAD, ModItems.foodItem(DeliciasFoodProperties.GARLIC_BREAD));

    public static Item ALIOLI = registerItem(DeliciasItemIds.ALIOLI, ModItems.foodItem(DeliciasFoodProperties.ALIOLI));

    public static Item CHORIZO = registerItem(DeliciasItemIds.CHORIZO, ModItems.foodItem(DeliciasFoodProperties.CHORIZO));

    public static Item MORCILLA = registerItem(DeliciasItemIds.MORCILLA, ModItems.foodItem(DeliciasFoodProperties.MORCILLA));

    public static Item CROQUETTE = registerItem(DeliciasItemIds.CROQUETTE, ModItems.foodItem(DeliciasFoodProperties.CROQUETTES));

    //Placeable
    public static Item POTATO_TORTILLA = registerItem(DeliciasItemIds.POTATO_TORTILLA);

    public static Item POTATO_TORTILLA_SLICE = registerItem(DeliciasItemIds.POTATO_TORTILLA_SLICE, ModItems.foodItem(DeliciasFoodProperties.POTATO_TORTILLA_SLICE));

    //Placeable
    public static Item CHORIZO_TORTILLA = registerItem(DeliciasItemIds.CHORIZO_TORTILLA);

    public static Item CHORIZO_TORTILLA_SLICE = registerItem(DeliciasItemIds.CHORIZO_TORTILLA_SLICE, ModItems.foodItem(DeliciasFoodProperties.CHORIZO_TORTILLA_SLICE));

    public static Item CHIPIRONES = registerItem(DeliciasItemIds.CHIPIRONES, ModItems.foodItem(DeliciasFoodProperties.CHIPIRONES));

    public static Item FIDEUA = registerItem(DeliciasItemIds.FIDEUA, ModItems.foodItem(DeliciasFoodProperties.FIDEUA));

    public static Item BLACK_RICE = registerItem(DeliciasItemIds.BLACK_RICE, ModItems.foodItem(DeliciasFoodProperties.BLACK_RICE));

    public static Item GAZPACHO = registerItem(DeliciasItemIds.GAZPACHO, ModItems.foodItem(DeliciasFoodProperties.GAZPACHO));

    public static Item PAELLA = registerItem(DeliciasItemIds.PAELLA, ModItems.foodItem(DeliciasFoodProperties.PAELLA));

    public static Item BRAVA_POTATOES = registerItem(DeliciasItemIds.BRAVA_POTATOES, ModItems.foodItem(DeliciasFoodProperties.BRAVA_POTATOES));

    public static Item GRAPE_JUICE = registerItem(DeliciasItemIds.GRAPE_JUICE, (props) -> new DrinkableItem(props, true, false), ModItems.foodItem(DeliciasFoodProperties.GRAPE_JUICE));

    public static Item SANGRIA = registerItem(DeliciasItemIds.SANGRIA, (props) -> new DrinkableItem(props, true, false), ModItems.foodItem(DeliciasFoodProperties.SANGRIA));

    public static Item GRAPE_JAM = registerItem(DeliciasItemIds.GRAPE_JAM, ModItems.foodItem(DeliciasFoodProperties.GRAPE_JAM));

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
