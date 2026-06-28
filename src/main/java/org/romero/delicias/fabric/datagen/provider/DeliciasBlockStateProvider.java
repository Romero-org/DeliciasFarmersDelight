package org.romero.delicias.fabric.datagen.provider;

//? fabric {
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.romero.delicias.DeliciasFD;
import org.romero.delicias.common.reg.DeliciasBlocks;
import org.romero.delicias.common.reg.DeliciasItems;

import static net.minecraft.data.models.BlockModelGenerators.createSimpleBlock;

public final class DeliciasBlockStateProvider extends FabricModelProvider {

    public DeliciasBlockStateProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createCrossBlockWithDefaultItem(DeliciasBlocks.WILD_GARLIC, BlockModelGenerators.TintState.NOT_TINTED);
        blockStateModelGenerator.createCrossBlockWithDefaultItem(DeliciasBlocks.ROSEMARY, BlockModelGenerators.TintState.NOT_TINTED);
        generateLonelyFlowerPot(blockStateModelGenerator, DeliciasBlocks.POTTED_ROSEMARY, DeliciasFD.id("block/rosemary_flower_pot"));
        blockStateModelGenerator.createPlant(DeliciasBlocks.ROSE, DeliciasBlocks.POTTED_ROSE, BlockModelGenerators.TintState.NOT_TINTED);
        blockStateModelGenerator.createCropBlock(DeliciasBlocks.GARLIC, BlockStateProperties.AGE_7,0, 0, 1, 1, 2, 2, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(DeliciasItems.OLIVES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.OIL_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.CALAMARI, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.RAISINS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.RAISIN_BREAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.GARLIC_BREAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.ALIOLI, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.CHORIZO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.MORCILLA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.CROQUETTE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.POTATO_TORTILLA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.POTATO_TORTILLA_SLICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.CHORIZO_TORTILLA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.CHORIZO_TORTILLA_SLICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.CHIPIRONES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.FIDEUA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.BLACK_RICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.GAZPACHO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.PAELLA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.BRAVA_POTATOES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.GRAPE_JUICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.SANGRIA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(DeliciasItems.GRAPE_JAM, ModelTemplates.FLAT_ITEM);
    }

    private static void generateLonelyFlowerPot(BlockModelGenerators blockStateModelGenerator, Block block, ResourceLocation textureId) {
        TextureMapping textureMapping = TextureMapping.plant(textureId);
        ResourceLocation resourceLocation = BlockModelGenerators.TintState.NOT_TINTED.getCrossPot().create(block, textureMapping, blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(createSimpleBlock(block, resourceLocation));
    }
}
//?}