package org.romero.delicias.common.reg;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.romero.delicias.common.blocks.GarlicBlock;
import org.romero.delicias.common.reg.ids.DeliciasBlockIds;
import org.romero.delicias.common.reg.ids.DeliciasBlockItemIds;
import org.romero.delicias.common.util.BlockItemId;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Function;

public final class DeliciasBlocks {

    private DeliciasBlocks() {}

    public static final Block WILD_GARLIC = register(DeliciasBlockItemIds.WILD_GARLIC,
            (props) -> new WildCropBlock(MobEffects.SLOW_FALLING, 30, props), BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));

    public static final Block GARLIC = register(
            DeliciasBlockItemIds.GARLIC_CROP,
            GarlicBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)
    );

    public static final Block ROSEMARY = register(DeliciasBlockItemIds.ROSEMARY,
            TallGrassBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.FERN).offsetType(BlockBehaviour.OffsetType.XZ));

    public static final Block POTTED_ROSEMARY = register(DeliciasBlockIds.POTTED_ROSEMARY,
            (props) -> new FlowerPotBlock(ROSEMARY, props), flowerPotProperties());

    public static final Block ROSE = register(DeliciasBlockItemIds.ROSE,
            (props) -> new FlowerBlock(MobEffects.DAMAGE_BOOST, 30, props), BlockBehaviour.Properties.ofFullCopy(Blocks.FERN).offsetType(BlockBehaviour.OffsetType.XZ));

    public static final Block POTTED_ROSE = register(DeliciasBlockIds.POTTED_ROSE,
            (props) -> new FlowerPotBlock(ROSE, props), flowerPotProperties());

    private static BlockBehaviour.Properties flowerPotProperties() {
        return BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
    }

    private static Block register(final BlockItemId id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        return register(id.block(), factory, properties);
    }

    private static Block register(final ResourceKey<Block> id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        Block block = factory.apply(properties);
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void init() {}
}
