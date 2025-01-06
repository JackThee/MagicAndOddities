package net.jackthee.magicandthings.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.jackthee.magicandthings.MagicAndThings;
import net.jackthee.magicandthings.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancemetsProvider extends FabricAdvancementProvider {


    public ModAdvancemetsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rawRuby = Advancement.Builder.create()
                .display(
                        ModItems.RAW_RUBY,
                            Text.literal("Red Shiny Rocks"),
                            Text.literal("Find A Ruby"),
                            new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )

                    .criterion("got_ruby", InventoryChangedCriterion.Conditions.items(ModItems.RAW_RUBY))
                    .build(consumer, MagicAndThings.MOD_ID + "/raw_ruby");
        Advancement furyScroll = Advancement.Builder.create().display(ModItems.SCROLL_OF_FURY,Text.literal("Scroll Of Fury"),Text.literal("Scroll Of Fury"),new Identifier("textures/gui/advancements/backgrounds/adventure.png"),AdvancementFrame.TASK,true,true,false).criterion("got_fury_scroll",InventoryChangedCriterion.Conditions.items(ModItems.SCROLL_OF_FURY)).build(consumer, MagicAndThings.MOD_ID+"/fury_scroll");
        Advancement feedingScroll = Advancement.Builder.create().display(ModItems.SCROLL_OF_FEEDING,Text.literal("Scroll Of Feeding"),Text.literal("Scroll Of Feeding"),new Identifier("textures/gui/advancements/backgrounds/adventure.png"),AdvancementFrame.TASK,true,true,false).criterion("got_feeding_scroll",InventoryChangedCriterion.Conditions.items(ModItems.SCROLL_OF_FEEDING)).build(consumer, MagicAndThings.MOD_ID+"/feeding_scroll");
        Advancement healingScroll = Advancement.Builder.create().display(ModItems.SCROLL_OF_HEALING,Text.literal("Scroll Of Healing"),Text.literal("Scroll Of Healing"),new Identifier("textures/gui/advancements/backgrounds/adventure.png"),AdvancementFrame.TASK,true,true,false).criterion("got_healing_scroll",InventoryChangedCriterion.Conditions.items(ModItems.SCROLL_OF_HEALING)).build(consumer, MagicAndThings.MOD_ID+"/healing_scroll");
        Advancement chargingScroll = Advancement.Builder.create().display(ModItems.SCROLL_OF_CHARGING,Text.literal("Scroll Of Charging"),Text.literal("Scroll Of Charging"),new Identifier("textures/gui/advancements/backgrounds/adventure.png"),AdvancementFrame.TASK,true,true,false).criterion("got_healing_scroll",InventoryChangedCriterion.Conditions.items(ModItems.SCROLL_OF_HEALING)).build(consumer, MagicAndThings.MOD_ID+"/charging_scroll");
        }


}

