package net.jackthee.magicandthings.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jackthee.magicandthings.MagicAndThings;
import net.jackthee.magicandthings.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,new Identifier(MagicAndThings.MOD_ID,
            "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                    entries.add(ModItems.RUBY);
                    entries.add(ModItems.RAW_RUBY);
                    entries.add(ModItems.TOMATO);
                    entries.add(ModItems.COAL_COKE);
                    entries.add(ModItems.RUBY_PICKAXE);
                    entries.add(ModItems.RUBY_AXE);
                    entries.add(ModItems.RUBY_HOE);
                    entries.add(ModItems.RUBY_SHOVEL);
                    entries.add(ModItems.RUBY_SWORD);
                    entries.add(ModItems.STEEL_INGOT);
                    entries.add(ModItems.STEEL_HELMET);
                    entries.add(ModItems.STEEL_CHESTPLATE);
                    entries.add(ModItems.STEEL_LEGGINGS);
                    entries.add(ModItems.STEEL_BOOTS);
                    entries.add(ModItems.PIG_IRON_INGOT);
                    entries.add(ModItems.STEEL_BLEND);

                    entries.add(ModItems.JEWEL_FINDER);
                    entries.add(ModItems.RUBY_STAFF);

                    entries.add(ModBlocks.RUBY_BLOCK);
                    entries.add(ModBlocks.RAW_RUBY_BLOCK);
                    entries.add(ModBlocks.CINNABAR_ORE);
                    entries.add(ModBlocks.DEEPSLATE_CINNABAR_ORE);
                    entries.add(ModBlocks.SOUND_BLOCK);

                    entries.add(ModBlocks.RUBY_SLAB);
                    entries.add(ModBlocks.RUBY_STAIRS);
                    entries.add(ModBlocks.RUBY_FENCE);
                    entries.add(ModBlocks.RUBY_FENCE_GATE);
                    entries.add(ModBlocks.RUBY_DOOR);
                    entries.add(ModBlocks.RUBY_TRAPDOOR);
                    entries.add(ModBlocks.RUBY_BUTTON);
                    entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                    entries.add(ModBlocks.RUBY_WALL);


                    }).build());

    public static void RegisterItemGroups(){
        MagicAndThings.LOGGER.info("Registering Item Groups Of: " + MagicAndThings.MOD_ID);
    }
}
