package org.romero.delicias.common.reg;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.romero.delicias.common.reg.ids.DeliciasCreativeModeTabIds;

public final class DeliciasCreativeModeTabs {

    private DeliciasCreativeModeTabs() {}

    private static CreativeModeTab.Builder creativeModeTabBuilder() {
        return //? fabric {
                CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0);
        //?} neoforge {
        /*CreativeModeTab.builder();
         *///?}
    }

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, DeliciasCreativeModeTabIds.DELICIAS_FD, creativeModeTabBuilder().title(Component.translatable("itemGroup.delicias_farmersdelight.delicias_fd")).icon(() -> new ItemStack(DeliciasItems.OIL_BOTTLE)).displayItems(((itemDisplayParameters, output) -> {
            output.accept(DeliciasItems.WILD_GARLIC);
            output.accept(DeliciasItems.GARLIC);
            output.accept(DeliciasItems.OLIVES);
            output.accept(DeliciasItems.OIL_BOTTLE);
            output.accept(DeliciasItems.CALAMARI);
            output.accept(DeliciasItems.RAISINS);
            output.accept(DeliciasItems.RAISIN_BREAD);
            output.accept(DeliciasItems.GARLIC_BREAD);
            output.accept(DeliciasItems.ALIOLI);
            output.accept(DeliciasItems.CHORIZO);
            output.accept(DeliciasItems.MORZILLA);
            output.accept(DeliciasItems.CROQUETTE);
            output.accept(DeliciasItems.POTATO_TORTILLA);
            output.accept(DeliciasItems.POTATO_TORTILLA_SLICE);
            output.accept(DeliciasItems.CHORIZO_TORTILLA);
            output.accept(DeliciasItems.CHORIZO_TORTILLA_SLICE);
            output.accept(DeliciasItems.CHIPIRONES);
            output.accept(DeliciasItems.FIDEUA);
            output.accept(DeliciasItems.BLACK_RICE);
            output.accept(DeliciasItems.GAZPACHO);
            output.accept(DeliciasItems.PAELLA);
            output.accept(DeliciasItems.BRAVA_POTATOES);
            output.accept(DeliciasItems.GRAPE_JUICE);
            output.accept(DeliciasItems.SANGRIA);
            output.accept(DeliciasItems.GRAPE_JAM);
            output.accept(DeliciasItems.ROSEMARY);
            output.accept(DeliciasItems.ROSE);
        })).build());
    }
}
