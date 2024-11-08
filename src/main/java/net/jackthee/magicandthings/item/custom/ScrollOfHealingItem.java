package net.jackthee.magicandthings.item.custom;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScrollOfHealingItem extends Item {

    public ScrollOfHealingItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack heldItem = user.getHandItems().iterator().next();
        if (user.experienceLevel > 0){
            user.addExperience(-10);
            AreaEffectCloudEntity effectCloud = new AreaEffectCloudEntity(user.getWorld(), user.getX(), user.getY(), user.getZ());
            effectCloud.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,10,1,false,false,false));
            effectCloud.setRadius(3f);
            effectCloud.setDuration(200);
            effectCloud.setParticleType(ParticleTypes.HEART);
            user.getWorld().spawnEntity(effectCloud);
            user.getItemCooldownManager().set(heldItem.getItem(),800);
        }
    TypedActionResult<ItemStack> result = new TypedActionResult<ItemStack>(ActionResult.SUCCESS,heldItem);


        return result;
    }
}
