package net.jackthee.magicandthings.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jackthee.magicandthings.blocks.ModBlocks;
import net.jackthee.magicandthings.util.ModTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.JEWEL_ORES).add(ModBlocks.CINNABAR_ORE).add(ModBlocks.DEEPSLATE_CINNABAR_ORE);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CINNABAR_ORE)
                .add(ModBlocks.DEEPSLATE_CINNABAR_ORE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RAW_RUBY_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.CINNABAR_ORE)
                .add(ModBlocks.DEEPSLATE_CINNABAR_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)

            ;
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)

            ;
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,new Identifier("fabric","needs_tool_level_4")))

            ;
    }
}
