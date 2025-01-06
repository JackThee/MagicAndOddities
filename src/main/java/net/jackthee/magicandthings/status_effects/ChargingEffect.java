package net.jackthee.magicandthings.status_effects;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

public class ChargingEffect extends StatusEffect {
    protected ChargingEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x1e16c5);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the effect every tick
        return true;
    }

    /*@Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addExperience(1 << amplifier); // Higher amplifier gives you experience faster
        }

        super.applyUpdateEffect(entity, amplifier);
    }*/

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        LightningEntity lighting = new LightningEntity(EntityType.LIGHTNING_BOLT, entity.getWorld());
        lighting.setPosition(entity.getX(),entity.getY(),entity.getZ());
        entity.getWorld().spawnEntity(lighting);
        if (amplifier > 0)
        {
            StatusEffectInstance effectInstance = new StatusEffectInstance(ModEffects.Charging.value(),10, amplifier - 1, false, false);
            entity.addStatusEffect(effectInstance);
        }
    }
}
