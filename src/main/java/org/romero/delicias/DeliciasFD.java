package org.romero.delicias;

import dev.yumi.mc.core.api.ModContainer;
import dev.yumi.mc.core.api.entrypoint.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.romero.delicias.common.reg.DeliciasBlocks;
import org.romero.delicias.common.reg.DeliciasCreativeModeTabs;
import org.romero.delicias.common.reg.DeliciasItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeliciasFD implements ModInitializer {

    public static final String MOD_ID = "delicias_farmersdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    };

    @Override
    public void onInitialize(ModContainer mod) {
        DeliciasBlocks.init();
        DeliciasItems.init();
        //neoforge pmo so bad
        Platform.INSTANCE.registerCreativeModeTabs(DeliciasCreativeModeTabs::init);
    }
}
