package net.get900.pixelpirates.block.custom;

import net.get900.pixelpirates.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class GunpowderBarrelBlock extends Block {
    public static final BooleanProperty LIT = Properties.LIT;
    private static final int FUSE_TICKS = 160; // 8 seconds (20 ticks per second)

    public GunpowderBarrelBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(LIT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.fullCube();
    }

    public void ignite(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (!state.get(LIT)) {
            world.setBlockState(pos, state.with(LIT, true), 3);
            world.updateNeighborsAlways(pos, this);

            if (!world.isClient) {
                ((ServerWorld) world).scheduleBlockTick(pos, this, FUSE_TICKS);
            }

            world.playSound(null, pos, ModSounds.BARREL_FUSE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        if (state.get(LIT)) {
            world.removeBlock(pos, false);
            world.createExplosion(null,
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    6.0F,
                    false,
                    World.ExplosionSourceType.BLOCK);
            world.playSound(null, pos, ModSounds.BARREL_EXPLOSION, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                              Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();

        // Ignite with flint and steel
        if (!state.get(LIT) && item == Items.FLINT_AND_STEEL) {
            ignite(world, pos);
            itemStack.damage(1, player, (p) -> p.sendToolBreakStatus(hand));
            return ActionResult.SUCCESS;
        }

        // Extinguish with water bucket
        if (state.get(LIT) && item == Items.WATER_BUCKET) {
            world.setBlockState(pos, state.with(LIT, false), 3);
            world.updateNeighborsAlways(pos, this);
            world.playSound(null, pos, ModSounds.FUSE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!player.isCreative()) {
                player.setStackInHand(hand, new ItemStack(Items.BUCKET));
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}