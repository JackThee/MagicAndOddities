package net.jackthee.magicandthings.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    RUBY(5,650,5.5f,2.5f,15,() -> Ingredient.ofItems(ModItems.RUBY));

    private final int MiningLevel;
    private final int ItemDurablility;
    private final float MiningSpeed;
    private final float AttackDamage;
    private final int Enchantablitity;
    private final Supplier<Ingredient> RepairIngredient;

    ModToolMaterial(int miningLevel, int itemDurablility, float miningSpeed, float attackDamage, int enchantablitity, Supplier<Ingredient> repairIngredient) {
        this.MiningLevel = miningLevel;
        this.ItemDurablility = itemDurablility;
        this.MiningSpeed = miningSpeed;
        this.AttackDamage = attackDamage;
        this.Enchantablitity = enchantablitity;
        this.RepairIngredient = repairIngredient;
    }


    @Override
    public int getDurability() {
        return this.ItemDurablility;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.MiningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.AttackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.MiningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.Enchantablitity;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.RepairIngredient.get();
    }
}
