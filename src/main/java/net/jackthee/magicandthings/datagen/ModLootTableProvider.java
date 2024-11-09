package net.jackthee.magicandthings.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jackthee.magicandthings.MagicAndThings;
import net.jackthee.magicandthings.blocks.ModBlocks;
import net.jackthee.magicandthings.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.RAW_RUBY_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);
        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);
        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_WALL);

        addDrop(ModBlocks.RUBY_SLAB,slabDrops(ModBlocks.RUBY_SLAB));
        addDrop(ModBlocks.RUBY_DOOR,doorDrops(ModBlocks.RUBY_DOOR));

        addDrop(ModBlocks.CINNABAR_ORE,gemOreDrops(ModBlocks.CINNABAR_ORE, ModItems.RAW_RUBY,0f,1.5f));
        addDrop(ModBlocks.DEEPSLATE_CINNABAR_ORE,gemOreDrops(ModBlocks.DEEPSLATE_CINNABAR_ORE, ModItems.RAW_RUBY,0f,3.0f));
    }


    public LootTable.Builder gemOreDrops(Block drop, Item Jewel,float Min,float Max) {
                return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(Jewel).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(Min, Max))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));



    }
}
