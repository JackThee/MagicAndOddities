package net.jackthee.magicandthings.item.custom;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScrollOfFuryItem extends Item {

    public ScrollOfFuryItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack heldItem = user.getHandItems().iterator().next();
        if (user.experienceLevel > 0){
            user.addExperience(-10);
            user.damage(new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(DamageTypes.INDIRECT_MAGIC)),2f);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,400,4,false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,400,1,false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,400,1,false,false,false));
            user.getItemCooldownManager().set(heldItem.getItem(),1600);
        }
    TypedActionResult<ItemStack> result = new TypedActionResult<ItemStack>(ActionResult.SUCCESS,heldItem);


        return result;
    }
}
