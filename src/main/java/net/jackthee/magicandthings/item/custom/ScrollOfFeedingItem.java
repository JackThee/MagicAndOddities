package net.jackthee.magicandthings.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.EffectCommand;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScrollOfFeedingItem extends Item {

    public ScrollOfFeedingItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ItemStack heldItem = user.getHandItems().iterator().next();
            if (user.experienceLevel > 0) {
                user.addExperience(-10);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 100, 4, false, false, false));
                user.getItemCooldownManager().set(heldItem.getItem(), 800);
            }



        }
        TypedActionResult<ItemStack> result = new TypedActionResult<ItemStack>(ActionResult.SUCCESS, user.getHandItems().iterator().next());
        return result;
    }
}
