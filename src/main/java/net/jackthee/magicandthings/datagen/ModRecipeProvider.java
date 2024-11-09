package net.jackthee.magicandthings.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jackthee.magicandthings.blocks.ModBlocks;
import net.jackthee.magicandthings.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY);
    private static final List<ItemConvertible> STEEL_DUST_SMELTABLES = List.of(ModItems.STEEL_BLEND);
    private static final List<ItemConvertible> STEEL_INGOT_SMELTABLES = List.of(ModItems.PIG_IRON_INGOT);
    private static final List<ItemConvertible> COAL_SMELTABLES = List.of(Items.COAL);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {


        offerBlasting(consumer, STEEL_DUST_SMELTABLES, RecipeCategory.MISC,ModItems.PIG_IRON_INGOT,2.0f,600,"steel");
        offerBlasting(consumer, STEEL_INGOT_SMELTABLES, RecipeCategory.MISC,ModItems.STEEL_INGOT,2.0f,600,"steel");
        offerBlasting(consumer, COAL_SMELTABLES, RecipeCategory.MISC,ModItems.COAL_COKE,2.0f,600,"steel");

        offerReversibleCompactingRecipes(consumer,RecipeCategory.BUILDING_BLOCKS,ModItems.RUBY,RecipeCategory.DECORATIONS,ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(consumer,RecipeCategory.BUILDING_BLOCKS,ModItems.RAW_RUBY,RecipeCategory.DECORATIONS,ModBlocks.RAW_RUBY_BLOCK);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.STEEL_BLEND,9)
                .input(ModItems.COAL_COKE)
                .input(ModItems.COAL_COKE)
                .input(Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT),conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.COAL_COKE),conditionsFromItem(ModItems.COAL_COKE))
                .offerTo(consumer,new Identifier(getRecipeName(ModItems.STEEL_BLEND)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.GEM_POLISHING_STATION,9)
                .input('#',ModItems.PIG_IRON_INGOT)
                .pattern(" # ")
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(ModItems.PIG_IRON_INGOT),conditionsFromItem(ModItems.PIG_IRON_INGOT))
                .offerTo(consumer,new Identifier(getRecipeName(ModBlocks.GEM_POLISHING_STATION.asItem())));


    }
}
