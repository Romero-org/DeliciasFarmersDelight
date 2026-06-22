package org.romero.delicias.fabric;

//? fabric {
import org.romero.delicias.DeliciasFD;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        DeliciasFD.init();
    }

}
//?}
