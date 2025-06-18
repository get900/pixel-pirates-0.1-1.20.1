package net.get900.pixelpirates.item.custom;

import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.entity.custom.RaftEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.registry.tag.FluidTags;

public class RaftItem extends Item {

    public RaftItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        BlockPos playerPos = user.getBlockPos();

        boolean isInWater = world.getFluidState(playerPos).isIn(FluidTags.WATER);
        boolean hasSpaceAbove = world.getBlockState(playerPos.up()).isAir();

        if (!isInWater || !hasSpaceAbove) {
            return TypedActionResult.fail(stack);
        }

        if (!world.isClient) {
            RaftEntity raft = new RaftEntity(ModEntities.RAFT, world);
            raft.refreshPositionAndAngles(
                    user.getX(), user.getY() + 1.0, user.getZ(),
                    user.getYaw(), 0
            );
            world.spawnEntity(raft);

            if (!user.isCreative()) {
                stack.decrement(1);
            }
        }

        return TypedActionResult.success(stack, world.isClient);
    }
}