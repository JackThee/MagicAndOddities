package net.jackthee.magicandthings;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.jackthee.magicandthings.blocks.ModBlocks;
import net.jackthee.magicandthings.blocks.entity.ModBlockEntities;
import net.jackthee.magicandthings.features.ModFeatures;
import net.jackthee.magicandthings.item.ModItemGroups;
import net.jackthee.magicandthings.item.ModItems;
import net.jackthee.magicandthings.recipe.ModRecipes;
import net.jackthee.magicandthings.screen.ModScreenHandlers;
import net.jackthee.magicandthings.sound.ModSounds;
import net.jackthee.magicandthings.util.ModLootTableModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagicAndThings implements ModInitializer {


	public static final String MOD_ID = "magicandthings";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.RegisterItemGroups();
		ModItems.registerModItems();
		ModBlocks.RegisterModBlocks();
		FuelRegistry.INSTANCE.add(ModItems.COAL_COKE,1000);
		ModLootTableModifier.modifyLootTables();
		ModBlockEntities.RegisterBlockEntities();
		ModScreenHandlers.RegisterScreenHandlers();
		ModRecipes.RegisterRecipes();
		ModFeatures.RegisterFeatures();
		ModSounds.registerSounds();
		ModEntities.RegisterModEntities();
	}
}