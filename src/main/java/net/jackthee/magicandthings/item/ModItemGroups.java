package net.jackthee.magicandthings.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jackthee.magicandthings.MagicAndThings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,new Identifier(MagicAndThings.MOD_ID,
            "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {

                    }).build());

    public static void RegisterItemGroups(){
        MagicAndThings.LOGGER.info("Registering Item Groups Of: " + MagicAndThings.MOD_ID);
    }
}
