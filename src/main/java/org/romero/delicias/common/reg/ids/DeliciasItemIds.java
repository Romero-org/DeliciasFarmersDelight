package org.romero.delicias.common.reg.ids;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import org.romero.delicias.DeliciasFD;

public final class DeliciasItemIds {

    public static final ResourceKey<Item> OLIVES = create("olives");

    public static final ResourceKey<Item> OIL_BOTTLE = create("oil_bottle");

    public static final ResourceKey<Item> CALAMARI = create("calamari");

    public static final ResourceKey<Item> RAISINS = create("raisins");

    public static final ResourceKey<Item> RAISIN_BREAD = create("raisin_bread");

    public static final ResourceKey<Item> GARLIC_BREAD = create("garlic_bread");

    public static final ResourceKey<Item> ALIOLI = create("alioli");

    public static final ResourceKey<Item> CHORIZO = create("chorizo");

    public static final ResourceKey<Item> MORCILLA = create("morcilla");

    public static final ResourceKey<Item> CROQUETTE = create("croquette");

    // Should be placed
    public static final ResourceKey<Item> POTATO_TORTILLA = create("potato_tortilla");

    public static final ResourceKey<Item> POTATO_TORTILLA_SLICE = create("potato_tortilla_slice");

    // Should be placed
    public static final ResourceKey<Item> CHORIZO_TORTILLA = create("chorizo_tortilla");

    public static final ResourceKey<Item> CHORIZO_TORTILLA_SLICE = create("chorizo_tortilla_slice");

    public static final ResourceKey<Item> CHIPIRONES = create("chipirones");

    public static final ResourceKey<Item> FIDEUA = create("fideua");

    public static final ResourceKey<Item> BLACK_RICE = create("black_rice");

    public static final ResourceKey<Item> GAZPACHO = create("gazpacho");

    // Should be placed
    public static final ResourceKey<Item> PAELLA = create("paella");

    // Should be placed
    public static final ResourceKey<Item> BRAVA_POTATOES = create("brava_potatoes");

    public static final ResourceKey<Item> GRAPE_JUICE = create("grape_juice");

    public static final ResourceKey<Item> SANGRIA = create("sangria");

    public static final ResourceKey<Item> GRAPE_JAM = create("grape_jam");

    private DeliciasItemIds() {}

    private static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, DeliciasFD.id(name));
    }
}
