package net.jackthee.magicandthings.blocks.custom;

import net.jackthee.magicandthings.blocks.ModBlocks;
import net.jackthee.magicandthings.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SkyPortalCoreBlock extends Block {
    public SkyPortalCoreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        BlockState first = world.getBlockState(pos.down(1));

        if (first == ModBlocks.RUBY_BLOCK.getDefaultState()){
            player.playSound(ModSounds.VOID_ECHO_0,1f,1f);


            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}
