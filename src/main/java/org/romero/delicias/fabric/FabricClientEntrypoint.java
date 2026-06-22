package org.romero.delicias.fabric;

//? fabric {
import org.romero.delicias.DeliciasFD;
import net.fabricmc.api.ClientModInitializer;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        DeliciasFD.LOG.info("Initializing {} Client", DeliciasFD.MOD_ID);
    }

}
//?}