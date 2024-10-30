package net.jackthee.magicandthings.util;

import net.jackthee.magicandthings.MagicAndThings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> JEWEL_ORES = CreateTag("jewel_ores");

        private static TagKey<Block> CreateTag(String Name){
            return TagKey.of(RegistryKeys.BLOCK,new Identifier(MagicAndThings.MOD_ID,Name));
        }
    }
    public static class Items{
        private static TagKey<Item> CreateTag(String Name){
            return TagKey.of(RegistryKeys.ITEM,new Identifier(MagicAndThings.MOD_ID,Name));
        }
    }
}
