package org.romero.delicias.neoforge;

//? neoforge {
/*import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.romero.delicias.DeliciasFD;
import org.romero.delicias.Platform;
import org.romero.delicias.client.DeliciasFDClient;

@Mod(DeliciasFD.MOD_ID)
public class NeoforgeEntrypoint {

    public NeoforgeEntrypoint(IEventBus modBus) {
        NeoForgePlatformImpl.EVENT_BUS = modBus;
        for (var a : Platform.INSTANCE.lateActions()) {
            a.accept(modBus);
        }
        Platform.INSTANCE.lateActions().clear();
    }
}
*///?}