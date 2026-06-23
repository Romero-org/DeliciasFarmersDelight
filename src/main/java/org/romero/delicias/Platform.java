package org.romero.delicias;

//? fabric {
import org.romero.delicias.fabric.FabricPlatformImpl;
//?}
//? neoforge {
/*import org.romero.delicias.neoforge.NeoForgePlatformImpl;
*///?}
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

import java.nio.file.Path;
import java.util.ArrayList;

public interface Platform {

    //? fabric {
    FabricPlatformImpl INSTANCE = new FabricPlatformImpl();
    //?}
    //? neoforge {
    /*NeoForgePlatformImpl INSTANCE = new NeoForgePlatformImpl(new ArrayList<>());
    *///?}


    boolean isModLoaded(String modid);
    String loader();
    Path getConfigDir();
    boolean isDevelopment();

    void registerRenderType(RenderType renderType, Block... blocks);

}
