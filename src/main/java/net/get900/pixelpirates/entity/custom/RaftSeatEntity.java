package net.get900.pixelpirates.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class RaftSeatEntity extends Entity {

    public RaftSeatEntity(EntityType<? extends RaftSeatEntity> type, World world) {
        super(type, world);
        this.setNoGravity(true);
    }

    @Override
    protected void initDataTracker() {}

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {}

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {}

    @Override
    public void tick() {
        super.tick();

        // Optional: reposition to match parent raft
        if (getVehicle() != null) {
            Entity raft = this.getVehicle();
            this.setPosition(raft.getX(), raft.getY() + 0.5, raft.getZ());
        }
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        System.out.println("RaftSeatEntity: Player attempted to interact!");

        if (!this.getWorld().isClient && !this.getPassengerList().contains(player)) {
            player.startRiding(this);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public boolean canAddPassenger(Entity passenger) {
        return getPassengerList().isEmpty();
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this); // Used by default if custom sync isn't needed
    }

    @Override
    public boolean damage(net.minecraft.entity.damage.DamageSource source, float amount) {
        return false;
    }

    @Override
    public boolean shouldSave() {
        return true;
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public boolean isInvisible() {
        return false;
    }
}