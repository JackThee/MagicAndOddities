package net.jackthee.magicandthings.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jackthee.magicandthings.blocks.ModBlocks;
import net.jackthee.magicandthings.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool rubyPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CINNABAR_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CINNABAR_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SKY_PORTAL_CORE);
        rubyPool.button(ModBlocks.RUBY_BUTTON);
        rubyPool.slab(ModBlocks.RUBY_SLAB);
        rubyPool.stairs(ModBlocks.RUBY_STAIRS);
        rubyPool.wall(ModBlocks.RUBY_WALL);
        rubyPool.fence(ModBlocks.RUBY_FENCE);
        rubyPool.fenceGate(ModBlocks.RUBY_FENCE_GATE);
        rubyPool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAPDOOR);

        blockStateModelGenerator.registerSimpleState(ModBlocks.GEM_POLISHING_STATION);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHINY_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.COAL_COKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JEWEL_FINDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCROLL_OF_FEEDING, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCROLL_OF_HEALING, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCROLL_OF_FURY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCROLL_OF_CHARGING, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_BLEND, Models.GENERATED);
        itemModelGenerator.register(ModItems.PIG_IRON_INGOT, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_BOOTS));
    }
}
