package net.get900.pixelpirates.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShipEntity extends Entity {

    public ShipEntity(EntityType<? extends ShipEntity> type, World world) {
        super(type, world);
        this.setNoGravity(true);
    }

    @Override
    protected void initDataTracker() {
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
    }

    @Override
    public boolean collidesWith(Entity other) {
        return true;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().isEmpty();
    }

    @Override
    public void tick() {
        super.tick();

        Vec3d forward = this.getRotationVec(1.0F).multiply(0.05);
        this.setVelocity(forward);
        this.move(MovementType.SELF, this.getVelocity());

        if (!this.getPassengerList().isEmpty()) {
            Entity passenger = this.getFirstPassenger();
            if (passenger != null) {
                double yOffset = this.getY() + 1.25;
                float yaw = this.getYaw() * 0.017453292F;
                double xOffset = MathHelper.sin(-yaw) * 0.4;
                double zOffset = MathHelper.cos(-yaw) * 0.4;
                passenger.setPosition(this.getX() + xOffset, yOffset, this.getZ() + zOffset);
            }
        }
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (!this.getWorld().isClient) {
            this.remove(RemovalReason.KILLED);
        }
        return super.damage(source, amount);
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient) {
            player.startRiding(this);
        }
        return ActionResult.SUCCESS;
    }

    public boolean canBeRiddenInWater() {
        return true;
    }
}