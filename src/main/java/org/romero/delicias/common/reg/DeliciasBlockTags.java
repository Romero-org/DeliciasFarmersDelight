package org.romero.delicias.common.reg;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.romero.delicias.DeliciasFD;

public final class DeliciasBlockTags {

    private DeliciasBlockTags() {}

    public static final TagKey<Block> TEST = create("test");

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, DeliciasFD.id(name));
    }
}
