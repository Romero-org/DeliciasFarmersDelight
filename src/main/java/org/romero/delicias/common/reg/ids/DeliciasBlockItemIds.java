package org.romero.delicias.common.reg.ids;

import org.romero.delicias.DeliciasFD;
import org.romero.delicias.common.util.BlockItemId;

public final class DeliciasBlockItemIds {

    private DeliciasBlockItemIds() {}

    public static final BlockItemId WILD_GARLIC = create("wild_garlic");
    public static final BlockItemId GARLIC_CROP = create("garlics", "garlic");
    public static final BlockItemId ROSEMARY = create("rosemary");
    public static final BlockItemId ROSE = create("rose");

    private static BlockItemId create(String blockName, String itemName) {
        return BlockItemId.create(DeliciasFD.id(blockName), DeliciasFD.id(itemName));
    }

    private static BlockItemId create(String name) {
        return BlockItemId.create(DeliciasFD.id(name), DeliciasFD.id(name));
    }
}
