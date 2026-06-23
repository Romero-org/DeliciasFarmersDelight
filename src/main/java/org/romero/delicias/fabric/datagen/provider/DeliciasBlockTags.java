package org.romero.delicias.fabric.datagen.provider;

//? fabric {
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.romero.delicias.common.reg.ids.DeliciasBlockItemIds;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public final class DeliciasBlockTags extends FabricTagProvider.BlockTagProvider {

    public DeliciasBlockTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.CROPS)
                .add(DeliciasBlockItemIds.GARLIC_CROP.block());
        tag(BlockTags.MAINTAINS_FARMLAND)
                .add(DeliciasBlockItemIds.GARLIC_CROP.block());
        tag(BlockTags.SMALL_FLOWERS)
                .add(DeliciasBlockItemIds.WILD_GARLIC.block())
                .add(DeliciasBlockItemIds.ROSEMARY.block())
                .add(DeliciasBlockItemIds.ROSE.block());
        tag(ModTags.Blocks.WILD_CROPS)
                .add(DeliciasBlockItemIds.WILD_GARLIC.block());
    }
}
//?}