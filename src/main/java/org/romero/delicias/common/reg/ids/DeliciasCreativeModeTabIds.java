package org.romero.delicias.common.reg.ids;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import org.romero.delicias.DeliciasFD;

public final class DeliciasCreativeModeTabIds {

    public static final ResourceKey<CreativeModeTab> DELICIAS_FD = create("delicias_fd");

    private DeliciasCreativeModeTabIds() {}

    private static ResourceKey<CreativeModeTab> create(String name) {
        return ResourceKey.create(Registries.CREATIVE_MODE_TAB, DeliciasFD.id(name));
    }
}
