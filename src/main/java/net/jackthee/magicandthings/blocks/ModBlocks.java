package net.jackthee.magicandthings.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jackthee.magicandthings.MagicAndThings;
import net.jackthee.magicandthings.blocks.custom.SoundBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block RUBY_BLOCK = RegisterBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_RUBY_BLOCK = RegisterBlock("raw_ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block CINNABAR_ORE = RegisterBlock("cinnabar_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(3.5f), UniformIntProvider.create(0,5)));

    public static final Block DEEPSLATE_CINNABAR_ORE = RegisterBlock("deepslate_cinnabar_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(5.5f), UniformIntProvider.create(0,5)));

    public static final Block SOUND_BLOCK = RegisterBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block RUBY_STAIRS = RegisterBlock("ruby_stairs",
            new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_SLAB = RegisterBlock("ruby_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_BUTTON = RegisterBlock("ruby_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK),BlockSetType.IRON,10,true));
    public static final Block RUBY_PRESSURE_PLATE = RegisterBlock("ruby_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK),BlockSetType.IRON));

    public static final Block RUBY_FENCE = RegisterBlock("ruby_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_FENCE_GATE = RegisterBlock("ruby_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK),WoodType.CHERRY));
    public static final Block RUBY_WALL = RegisterBlock("ruby_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_DOOR = RegisterBlock("ruby_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK),BlockSetType.STONE));
    public static final Block RUBY_TRAPDOOR = RegisterBlock("ruby_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK),BlockSetType.STONE));




    private static Block RegisterBlock(String Name,Block Block){
        RegisterBlockItem(Name,Block);
        return Registry.register(Registries.BLOCK,new Identifier(MagicAndThings.MOD_ID,Name),Block);
    }

    private static Item RegisterBlockItem(String Name, Block Block){
        return Registry.register(Registries.ITEM,new Identifier(MagicAndThings.MOD_ID,Name)
                ,new BlockItem(Block,new FabricItemSettings()));
    }



    public static void RegisterModBlocks(){
        MagicAndThings.LOGGER.info("Registering Blocks for: "+ MagicAndThings.MOD_ID);
    }
}
