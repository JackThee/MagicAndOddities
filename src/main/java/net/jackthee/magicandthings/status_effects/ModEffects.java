package net.jackthee.magicandthings.status_effects;

import net.jackthee.magicandthings.MagicAndThings;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> Charging;
    static {
        Charging = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MagicAndThings.MOD_ID, "charging"), new ChargingEffect());
    }

    public static void register_mod_effects()
    {
        MagicAndThings.LOGGER.info("Registering Effects For: " + MagicAndThings.MOD_ID);
    }


}
