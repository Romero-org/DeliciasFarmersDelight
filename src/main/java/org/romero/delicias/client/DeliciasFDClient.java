package org.romero.delicias.client;

import dev.yumi.mc.core.api.ModContainer;
import dev.yumi.mc.core.api.entrypoint.client.ClientModInitializer;
import net.minecraft.client.renderer.RenderType;
import org.romero.delicias.Platform;
import org.romero.delicias.common.reg.DeliciasBlocks;

public class DeliciasFDClient implements ClientModInitializer {

    @Override
    public void onInitializeClient(ModContainer mod) {
        Platform.INSTANCE.registerRenderType(RenderType.cutout(),
                DeliciasBlocks.WILD_GARLIC,
                DeliciasBlocks.GARLIC,
                DeliciasBlocks.ROSEMARY,
                DeliciasBlocks.POTTED_ROSEMARY,
                DeliciasBlocks.ROSE,
                DeliciasBlocks.POTTED_ROSE
        );
    }
}
