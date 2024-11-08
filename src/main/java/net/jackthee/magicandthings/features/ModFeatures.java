package net.jackthee.magicandthings.features;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jackthee.magicandthings.MagicAndThings;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModFeatures {

    public static final RegistryKey<PlacedFeature> CINNABAR_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE,
            Identifier.of(MagicAndThings.MOD_ID,"ore_cinnabar"));



    public static void RegisterFeatures(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,CINNABAR_ORE_PLACED_KEY);
    }
}
