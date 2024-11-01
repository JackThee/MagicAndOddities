package net.jackthee.magicandthings.item.custom;

import net.jackthee.magicandthings.MagicAndThings;
import net.jackthee.magicandthings.item.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmourMaterials implements ArmorMaterial {
    STEEL("steel",33,new int[] {3,8,6,3},10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,2f,0f,()->Ingredient.ofItems(ModItems.STEEL_INGOT)),
    RUBY("ruby",27,new int[] {5,10,8,5},23, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,3f,0.1f,()->Ingredient.ofItems(ModItems.RUBY));



    private final String Name;
    private final int DurabilityMultiplier;
    private final int[] ProtectionAmmounts;
    private final int Enchantablility;
    private final SoundEvent EquipSound;
    private final float Toughness;
    private final float KnockBackResistance;
    private final Supplier<Ingredient> RepairIngredient;

    private final static int[] BASE_DURABILITY = {13,16,15,13};

    ModArmourMaterials(String name, int durabilityMultiplier, int[] protectionAmmounts, int enchantablility, SoundEvent equipSound, float toughness, float knockBackResistance, Supplier<Ingredient> repairIngredient) {
        this.Name = name;
        this.DurabilityMultiplier = durabilityMultiplier;
        this.ProtectionAmmounts = protectionAmmounts;
        this.Enchantablility = enchantablility;
        this.EquipSound = equipSound;
        this.Toughness = toughness;
        this.KnockBackResistance = knockBackResistance;
        this.RepairIngredient = repairIngredient;
    }


    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()]*this.DurabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return ProtectionAmmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.Enchantablility;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.EquipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.RepairIngredient.get();
    }

    @Override
    public String getName() {
        return MagicAndThings.MOD_ID+":"+this.Name;
    }

    @Override
    public float getToughness() {
        return this.Toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.KnockBackResistance;
    }
}
