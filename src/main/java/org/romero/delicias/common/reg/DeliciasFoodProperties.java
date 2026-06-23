package org.romero.delicias.common.reg;

import net.minecraft.world.food.FoodProperties;

public final class DeliciasFoodProperties {

    private DeliciasFoodProperties() {}

    public static final FoodProperties GARLIC = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).build();
}
