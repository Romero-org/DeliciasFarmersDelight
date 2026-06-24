package org.romero.delicias.common.reg;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public final class DeliciasFoodProperties {

    private DeliciasFoodProperties() {}

    public static final FoodProperties GARLIC = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).build();
    public static final FoodProperties OLIVES = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodProperties OIL_BOTTLE = new FoodProperties.Builder().nutrition(6).saturationModifier(0.1F).build();
    public static final FoodProperties CALAMARI = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodProperties RAISINS = new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F).fast().build();
}
