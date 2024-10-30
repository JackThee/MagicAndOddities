package net.jackthee.magicandthings.item.custom;

import net.jackthee.magicandthings.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JewelFinderItem extends Item {

    public JewelFinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(!context.getWorld().isClient){
            BlockPos PositionClicked = context.getBlockPos();
            PlayerEntity Player = context.getPlayer();
            boolean FoundBlock = false;

            for (int i = 0; i < PositionClicked.getY()+64; i++) {
                BlockState State = context.getWorld().getBlockState(PositionClicked.down(i));

                if(IsValuableBlock(State)) {
                    OutputValuableCoordinates(PositionClicked.down(i),Player,State.getBlock());

                    FoundBlock = true;
                    break;
                }
            }
            if (!FoundBlock){
                Player.sendMessage(Text.literal("Failed to find blocks in range"),false);
            }
        }
        context.getStack().damage(1,context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void OutputValuableCoordinates(BlockPos BlockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " +block.asItem().getName().getString()+"at "
                +"("+BlockPos.getX()+","+BlockPos.getY()+","+BlockPos.getZ()+")"),false);
    }

    private boolean IsValuableBlock(BlockState State){
        return State.isIn(ModTags.Blocks.JEWEL_ORES);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.magicandthings.jewel_finder"));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
