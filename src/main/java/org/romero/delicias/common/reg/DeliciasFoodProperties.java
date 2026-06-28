package org.romero.delicias.common.reg;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.FoodValues;

public final class DeliciasFoodProperties {

    private DeliciasFoodProperties() {}

    public static final FoodProperties GARLIC = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).build();
    public static final FoodProperties OLIVES = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodProperties OIL_BOTTLE = new FoodProperties.Builder().alwaysEdible().nutrition(6).saturationModifier(0.1F).build();
    public static final FoodProperties CALAMARI = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodProperties RAISINS = new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F).fast().build();
    public static final FoodProperties RAISIN_BREAD = new FoodProperties.Builder().nutrition(6).saturationModifier(0.2F).build();
    public static final FoodProperties GARLIC_BREAD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4F).build();
    public static final FoodProperties ALIOLI = new FoodProperties.Builder().nutrition(5).saturationModifier(0.2F).effect(new MobEffectInstance(MobEffects.SATURATION, 20), 1.0F).build();
    //unique effect
    public static final FoodProperties CHORIZO = new FoodProperties.Builder().nutrition(6).saturationModifier(0.4F).build();
    public static final FoodProperties MORCILLA = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6F).build();
    public static final FoodProperties CROQUETTES = new FoodProperties.Builder().nutrition(3).saturationModifier(0.6F).fast().effect(FoodValues.nourishment(FoodValues.BRIEF_DURATION), 1.0F).build();
    public static final FoodProperties POTATO_TORTILLA_SLICE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).build();
    //unique chorizo effect
    public static final FoodProperties CHORIZO_TORTILLA_SLICE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).build();
    public static final FoodProperties CHIPIRONES = new FoodProperties.Builder().nutrition(12).saturationModifier(0.8F).effect(FoodValues.nourishment(FoodValues.MEDIUM_DURATION), 1.0F).build();
    public static final FoodProperties FIDEUA = new FoodProperties.Builder().nutrition(12).saturationModifier(0.8F).effect(FoodValues.nourishment(FoodValues.MEDIUM_DURATION), 1.0F).build();
    public static final FoodProperties BLACK_RICE = new FoodProperties.Builder().nutrition(12).saturationModifier(0.8F).effect(FoodValues.nourishment(FoodValues.MEDIUM_DURATION), 1.0F).build();
    public static final FoodProperties GAZPACHO = new FoodProperties.Builder().nutrition(12).saturationModifier(0.8F).effect(FoodValues.nourishment(FoodValues.MEDIUM_DURATION), 1.0F).build();
    public static final FoodProperties PAELLA = new FoodProperties.Builder().nutrition(14).saturationModifier(0.75F).effect(FoodValues.nourishment(FoodValues.LONG_DURATION), 1.0F).build();
    public static final FoodProperties BRAVA_POTATOES = new FoodProperties.Builder().nutrition(14).saturationModifier(0.75F).effect(FoodValues.nourishment(FoodValues.LONG_DURATION), 1.0F).build();
    //Sweet heart 1 min
    public static final FoodProperties GRAPE_JUICE = new FoodProperties.Builder().alwaysEdible().build();
    //Sweet heart, tipsy intoxication
    public static final FoodProperties SANGRIA = new FoodProperties.Builder().alwaysEdible().build();
    //Sweet heart 1 min
    public static final FoodProperties GRAPE_JAM = new FoodProperties.Builder().alwaysEdible().nutrition(3).saturationModifier(0.1F).build();
}
