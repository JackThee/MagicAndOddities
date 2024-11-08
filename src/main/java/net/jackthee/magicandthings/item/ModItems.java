package net.jackthee.magicandthings.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jackthee.magicandthings.MagicAndThings;
import net.jackthee.magicandthings.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = RegisterItem("ruby",new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = RegisterItem("raw_ruby",new Item(new FabricItemSettings()));
    public static final Item TOMATO = RegisterItem("tomato",new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item COAL_COKE = RegisterItem("coal_coke",new Item(new FabricItemSettings()));
    public static final Item STEEL_INGOT = RegisterItem("steel_ingot",new Item(new FabricItemSettings()));
    public static final Item STEEL_BLEND = RegisterItem("steel_blend",new Item(new FabricItemSettings()));
    public static final Item PIG_IRON_INGOT = RegisterItem("pig_iron_ingot",new Item(new FabricItemSettings()));

    public static final Item JEWEL_FINDER = RegisterItem("jewel_finder",new JewelFinderItem(new FabricItemSettings().maxDamage(64)));
    public static final Item SCROLL_OF_FEEDING = RegisterItem("scroll_of_feeding",new ScrollOfFeedingItem(new FabricItemSettings().maxDamage(64)));
    public static final Item SCROLL_OF_HEALING = RegisterItem("scroll_of_healing",new ScrollOfHealingItem(new FabricItemSettings().maxDamage(64)));
    public static final Item SCROLL_OF_FURY = RegisterItem("scroll_of_fury",new ScrollOfFuryItem(new FabricItemSettings().maxDamage(64)));

    public static final Item RUBY_STAFF = RegisterItem("ruby_staff",new Item(new FabricItemSettings().maxCount(1)));

    public static final Item RUBY_PICKAXE = RegisterItem("ruby_pickaxe",new PickaxeItem(ModToolMaterial.RUBY,0,-2.5f, new FabricItemSettings()));
    public static final Item RUBY_AXE = RegisterItem("ruby_axe",new AxeItem(ModToolMaterial.RUBY,3,-3.1f, new FabricItemSettings()));
    public static final Item RUBY_SWORD = RegisterItem("ruby_sword",new SwordItem(ModToolMaterial.RUBY,3,-2.1f, new FabricItemSettings()));
    public static final Item RUBY_HOE = RegisterItem("ruby_hoe",new HoeItem(ModToolMaterial.RUBY,0,0f, new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = RegisterItem("ruby_shovel",new ShovelItem(ModToolMaterial.RUBY,0,-2.5f, new FabricItemSettings()));

    public static final Item STEEL_HELMET = RegisterItem("steel_helmet",new ModArmourItem(ModArmourMaterials.STEEL,ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item STEEL_CHESTPLATE = RegisterItem("steel_chestplate",new ArmorItem(ModArmourMaterials.STEEL,ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item STEEL_LEGGINGS = RegisterItem("steel_leggings",new ArmorItem(ModArmourMaterials.STEEL,ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item STEEL_BOOTS = RegisterItem("steel_boots",new ArmorItem(ModArmourMaterials.STEEL,ArmorItem.Type.BOOTS, new FabricItemSettings()));

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
