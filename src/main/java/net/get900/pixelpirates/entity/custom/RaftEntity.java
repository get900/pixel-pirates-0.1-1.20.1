package net.get900.pixelpirates.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RaftEntity extends Entity {

    public static final EntityType<RaftEntity> RAFT = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("pixelpirates", "raft"),
            EntityType.Builder.create(RaftEntity::new, SpawnGroup.MISC)
                    .setDimensions(2.8f, 1.2f) // Size should match your model (X,Z = width/length; Y = height)
                    .maxTrackingRange(90)
                    .trackingTickInterval(1)
                    .build("raft")
    );

    public RaftEntity(EntityType<? extends RaftEntity> type, World world) {
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
    public void tick() {
        super.tick();

        // Move forward a bit (example)
        Vec3d forward = this.getRotationVec(1.0F).multiply(0.05);
        this.setVelocity(forward);
        this.move(MovementType.SELF, this.getVelocity());

        // Custom passenger positioning
        if (!this.getPassengerList().isEmpty()) {
            Entity passenger = this.getFirstPassenger();
            if (passenger != null) {
                double yOffset = this.getY() + 0.5;
                double xOffset = this.getX();
                double zOffset = this.getZ();
                passenger.setPosition(xOffset, yOffset, zOffset);
            }
        }
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
    public boolean damage(DamageSource source, float amount) {
        if (!this.getWorld().isClient) {
            this.remove(RemovalReason.KILLED);
        }
        return super.damage(source, amount);
    }

    @Override
    public boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().isEmpty(); // One rider for now
    }
}