package net.jackthee.magicandthings.recipe;

import net.jackthee.magicandthings.MagicAndThings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void RegisterRecipes(){
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(MagicAndThings.MOD_ID,GemPolishingRecipe.Serializer.ID),GemPolishingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE,new Identifier(MagicAndThings.MOD_ID,GemPolishingRecipe.Type.ID),GemPolishingRecipe.Type.INSTANCE);
    }
}
