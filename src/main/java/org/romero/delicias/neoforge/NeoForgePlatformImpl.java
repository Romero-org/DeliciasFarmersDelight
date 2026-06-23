package org.romero.delicias.neoforge;

//? neoforge {
/*import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.jspecify.annotations.Nullable;
import org.romero.delicias.Platform;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

public record NeoForgePlatformImpl(List<Consumer<IEventBus>> lateActions) implements Platform {
    public static @Nullable IEventBus EVENT_BUS = null;

    @Override
    public boolean isModLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    @Override
    public String loader() {
        return "neoforge";
    }

    @Override
    public Path getConfigDir() {
        return FMLPaths.CONFIGDIR.get();
    }

    @Override
    public boolean isDevelopment() {
        //? if >= 26.1 {
        /^return !FMLEnvironment.isProduction();
        ^///?} else {
		return !FMLEnvironment.production;
		//?}
    }

    @Override
    public void registerRenderType(RenderType renderType, Block... blocks) {
        addLateAction(bus -> bus.addListener(FMLClientSetupEvent.class, e -> {
            for (Block block : blocks) {
                ItemBlockRenderTypes.setRenderLayer(block, renderType);
            }
        }));
    }

    public void addLateAction(Consumer<IEventBus> consumer) {
        if (EVENT_BUS != null) {
            consumer.accept(EVENT_BUS);
        } else {
            this.lateActions.add(consumer);
        }
    }
}
*///?}