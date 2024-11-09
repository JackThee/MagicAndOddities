package net.jackthee.magicandthings.sound;

import net.jackthee.magicandthings.MagicAndThings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent VOID_ECHO_0 = registerSoundEvent("void_echo_0");



    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(MagicAndThings.MOD_ID,name);
        return Registry.register(Registries.SOUND_EVENT,id,SoundEvent.of(id));
    }


    public static void registerSounds(){
        MagicAndThings.LOGGER.info("Registering sounds for "+MagicAndThings.MOD_ID);

    }
}
