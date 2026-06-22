package org.romero.delicias.neoforge;

//? neoforge {
/*import org.romero.delicias.DeliciasFD;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(DeliciasFD.MOD_ID)
public class NeoforgeEntrypoint {

    public NeoforgeEntrypoint() {
        DeliciasFD.init();
    }

    @EventBusSubscriber(modid = DeliciasFD.MOD_ID, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            DeliciasFD.LOG.info("Initializing {} Client", DeliciasFD.MOD_ID);
        }
    }

}
*///?}
