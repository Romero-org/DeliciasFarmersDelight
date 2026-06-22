package org.romero.delicias;

import dev.yumi.mc.core.api.ModContainer;
import dev.yumi.mc.core.api.entrypoint.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeliciasFD implements ModInitializer {

    public static final String MOD_ID = "delicias_farmersdelight";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    };

    @Override
    public void onInitialize(ModContainer mod) {
        LOG.info("Initializing {} on {}", MOD_ID, Platform.INSTANCE.loader());

        Registry.register(BuiltInRegistries.ITEM, id("test"), new Item(new Item.Properties()));
    }
}
