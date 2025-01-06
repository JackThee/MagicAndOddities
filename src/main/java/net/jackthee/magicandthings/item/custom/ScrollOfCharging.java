package net.jackthee.magicandthings.item.custom;

import net.jackthee.magicandthings.status_effects.ModEffects;
import net.minecraft.particle.ParticleTypes;


public class ScrollOfCharging extends AreaOfEffectScrollAbstractItem {
    public ScrollOfCharging(Settings settings) {
        super(settings);
        effect = ModEffects.Charging.value();
        particle_type = ParticleTypes.ELECTRIC_SPARK;
    }

}
