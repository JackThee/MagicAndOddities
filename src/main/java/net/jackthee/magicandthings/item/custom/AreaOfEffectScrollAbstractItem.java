package net.jackthee.magicandthings.item.custom;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public abstract class AreaOfEffectScrollAbstractItem extends Item {

    public AreaOfEffectScrollAbstractItem(Settings settings) {
        super(settings);
    }

    public static StatusEffect effect;
    public static ParticleEffect particle_type;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ItemStack heldItem = user.getHandItems().iterator().next();
            if (user.experienceLevel > 0) {
                user.addExperience(-10);
                AreaEffectCloudEntity effectCloud = new AreaEffectCloudEntity(user.getWorld(), user.getX(), user.getY(), user.getZ());
                effectCloud.addEffect(new StatusEffectInstance(effect, 10, 1, false, false, false));
                effectCloud.setRadius(5f);
                effectCloud.setDuration(100);
                effectCloud.setParticleType(particle_type);
                user.getWorld().spawnEntity(effectCloud);
                user.getItemCooldownManager().set(heldItem.getItem(), 800);
            }
        }


        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS,user.getHandItems().iterator().next());
    }
}
