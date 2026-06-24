package org.romero.delicias.fabric;

//? fabric {
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import org.romero.delicias.common.reg.DeliciasItems;
import vectorwing.farmersdelight.common.tag.ModTags;

public class FabricEntrypoint implements ModInitializer {

    private static final ResourceKey<LootTable> SQUID_LOOT_TABLE_ID = vanillaLootKey("entities/squid");
    private static final ResourceKey<LootTable> GLOW_SQUID_LOOT_TABLE_ID = vanillaLootKey("entities/glow_squid");

    private static ResourceKey<LootTable> vanillaLootKey(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace(path));
    }

    @Override
    public void onInitialize() {
        // https://github.com/MehVahdJukaar/FarmersDelightRefabricated/blob/f2ebb75a078264b9b3d90e6fbcb2c5f637759604/src/main/java/vectorwing/farmersdelight/refabricated/LootModificationEvents.java#L158
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin()) {
                if (SQUID_LOOT_TABLE_ID == key || GLOW_SQUID_LOOT_TABLE_ID == key) {
                    tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(DeliciasItems.CALAMARI)
                            .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                                            EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES))
                                    )).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(false))))
                                    .and(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(registries, 0.5F, 0.1F)))));
                }
            }
        });
    }
}
//?}