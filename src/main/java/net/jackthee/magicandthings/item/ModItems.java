package net.jackthee.magicandthings.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jackthee.magicandthings.MagicAndThings;
import net.jackthee.magicandthings.item.custom.JewelFinderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = RegisterItem("ruby",new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = RegisterItem("raw_ruby",new Item(new FabricItemSettings()));
    public static final Item TOMATO = RegisterItem("tomato",new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item COAL_COKE = RegisterItem("coal_coke",new Item(new FabricItemSettings()));

    public static final Item JEWEL_FINDER = RegisterItem("jewel_finder",new JewelFinderItem(new FabricItemSettings().maxDamage(64)));

    public static final Item RUBY_STAFF = RegisterItem("ruby_staff",new Item(new FabricItemSettings().maxCount(1)));

    private static void AddItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }


    private static Item RegisterItem(String Name,Item item){
        return Registry.register(Registries.ITEM,new Identifier(MagicAndThings.MOD_ID,Name),item);
    }

    public static void registerModItems(){
        MagicAndThings.LOGGER.info("RegisteringModItems" + MagicAndThings.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::AddItemsToIngredientItemGroup);

    }
}
