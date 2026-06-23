package org.romero.delicias.fabric.datagen.provider;

//? fabric {
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.romero.delicias.common.reg.DeliciasBlocks;

public final class DeliciasBlockStateProvider extends FabricModelProvider {

    public DeliciasBlockStateProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createCrossBlockWithDefaultItem(DeliciasBlocks.WILD_GARLIC, BlockModelGenerators.TintState.NOT_TINTED);
        blockStateModelGenerator.createPlant(DeliciasBlocks.ROSEMARY, DeliciasBlocks.POTTED_ROSEMARY, BlockModelGenerators.TintState.NOT_TINTED);
        blockStateModelGenerator.createPlant(DeliciasBlocks.ROSE, DeliciasBlocks.POTTED_ROSE, BlockModelGenerators.TintState.NOT_TINTED);
        blockStateModelGenerator.createCropBlock(DeliciasBlocks.GARLIC, BlockStateProperties.AGE_7,0, 0, 1, 1, 2, 2, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }
}
//?}