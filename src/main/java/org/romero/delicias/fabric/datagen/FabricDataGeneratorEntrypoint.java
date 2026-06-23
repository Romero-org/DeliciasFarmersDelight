package org.romero.delicias.fabric.datagen;

//? fabric {
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.romero.delicias.fabric.datagen.provider.DeliciasBlockStateProvider;
import org.romero.delicias.fabric.datagen.provider.DeliciasBlockTags;

public class FabricDataGeneratorEntrypoint implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        final FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(DeliciasBlockStateProvider::new);
        pack.addProvider(DeliciasBlockTags::new);
    }

}
//?}

