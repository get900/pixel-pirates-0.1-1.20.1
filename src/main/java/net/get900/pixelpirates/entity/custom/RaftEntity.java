package net.get900.pixelpirates.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class RaftEntity extends BoatEntity {
    private boolean sailsLowered = false;
    private float movementSpeed = 0.04f;
    private float targetYaw;

    public RaftEntity(EntityType<? extends BoatEntity> type, World world) {
        super(type, world);
        this.setCustomName(Text.literal("Raft"));
        this.setNoGravity(true);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient) return;

        // Continuously update targetYaw if a player is riding and sails are lowered
        if (sailsLowered && this.hasPassengers() && this.getFirstPassenger() instanceof PlayerEntity player) {
            this.targetYaw = player.getYaw();
        }

        // Smoothly rotate toward the target yaw
        float yawDiff = MathHelper.wrapDegrees(this.targetYaw - this.getYaw());
        this.setYaw(this.getYaw() + yawDiff * 0.05f);  // Adjust rotation speed as needed

        // Move forward if sails are lowered
        if (sailsLowered) {
            Vec3d forward = this.getRotationVector().normalize().multiply(movementSpeed);
            this.move(MovementType.SELF, forward);
        } else {
            this.setVelocity(Vec3d.ZERO); // Prevent drift when sails are raised
        }
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (player.isSneaking()) {
            this.sailsLowered = !this.sailsLowered;
            this.setCustomName(Text.literal("Sails " + (sailsLowered ? "Down" : "Up")));

            // Set new targetYaw based on player's current yaw when sails go down
            if (sailsLowered && this.hasPassengers() && this.getFirstPassenger() instanceof PlayerEntity rider) {
                this.targetYaw = rider.getYaw();
            }

            return ActionResult.SUCCESS;
        }

        if (!player.hasVehicle()) {
            player.startRiding(this);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putBoolean("SailsLowered", sailsLowered);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        sailsLowered = nbt.getBoolean("SailsLowered");
    }

    @Override
    public EntitySpawnS2CPacket createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    public void setTargetYaw(float yaw) {
        this.targetYaw = yaw;
    }
}
