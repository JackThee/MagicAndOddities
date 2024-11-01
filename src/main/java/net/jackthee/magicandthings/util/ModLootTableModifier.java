package net.jackthee.magicandthings.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.jackthee.magicandthings.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifier {
    private static final Identifier BURIED_TREASURE_ID =
            new Identifier("minecraft","chests/buried_treasure");


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BURIED_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.11f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.RUBY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 7.5f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}