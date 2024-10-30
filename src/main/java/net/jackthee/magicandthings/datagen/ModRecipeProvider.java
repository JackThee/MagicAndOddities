package net.jackthee.magicandthings.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jackthee.magicandthings.blocks.ModBlocks;
import net.jackthee.magicandthings.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerSmelting(consumer,RUBY_SMELTABLES, RecipeCategory.MISC,ModItems.RUBY,2.0f,641,"ruby");
        offerBlasting(consumer,RUBY_SMELTABLES, RecipeCategory.MISC,ModItems.RUBY,2.0f,320,"ruby");

        offerReversibleCompactingRecipes(consumer,RecipeCategory.BUILDING_BLOCKS,ModItems.RUBY,RecipeCategory.DECORATIONS,ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(consumer,RecipeCategory.BUILDING_BLOCKS,ModItems.RAW_RUBY,RecipeCategory.DECORATIONS,ModBlocks.RAW_RUBY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.COAL_COKE,9)
                .pattern("###")
                .pattern("#C#")
                .pattern("###")
                .input('#', Items.COAL)
                .input('C', Items.COAL_BLOCK)
                .criterion(hasItem(ModItems.COAL_COKE),conditionsFromItem(ModItems.COAL_COKE))
                .criterion(hasItem(Items.COAL_BLOCK),conditionsFromItem(Items.COAL_BLOCK))
                .offerTo(consumer,new Identifier(getRecipeName(ModItems.COAL_COKE)));
    }
}
