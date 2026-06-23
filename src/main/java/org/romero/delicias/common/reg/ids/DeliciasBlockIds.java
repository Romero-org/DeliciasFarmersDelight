package org.romero.delicias.common.reg.ids;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import org.romero.delicias.DeliciasFD;

public final class DeliciasBlockIds {

    public static final ResourceKey<Block> POTTED_ROSEMARY = create("potted_rosemary");
    public static final ResourceKey<Block> POTTED_ROSE = create("potted_rose");

    private DeliciasBlockIds() {}

    private static ResourceKey<Block> create(String name) {
        return ResourceKey.create(Registries.BLOCK, DeliciasFD.id(name));
    }
}
