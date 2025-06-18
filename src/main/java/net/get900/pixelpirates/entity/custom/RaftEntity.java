package net.get900.pixelpirates.entity.custom;

import net.get900.pixelpirates.entity.ModEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RaftEntity extends Entity {

    public RaftEntity(EntityType<? extends RaftEntity> type, World world) {
        super(type, world);
        this.setNoGravity(true);
        this.setCustomName(Text.literal("Raft"));
        this.setCustomNameVisible(true);
    }
    private boolean seatSpawned = false;

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

        if (!this.getWorld().isClient && !seatSpawned) {
            RaftSeatEntity seat = new RaftSeatEntity(ModEntities.RAFT_SEAT, this.getWorld());
            seat.setPosition(this.getX(), this.getY() + 1.7, this.getZ());
            this.getWorld().spawnEntity(seat);

            if (!this.getWorld().getPlayers().isEmpty()) {
                PlayerEntity firstPlayer = this.getWorld().getPlayers().get(0);
                firstPlayer.startRiding(seat);
            }

            seatSpawned = true;
        }

        // Move forward a bit (example)
        Vec3d forward = this.getRotationVec(0.0F).multiply(0.00);
        this.setVelocity(forward);
        this.move(MovementType.SELF, this.getVelocity());

        // Custom passenger positioning
        //if (!this.getPassengerList().isEmpty()) {
           // Entity passenger = this.getFirstPassenger();
           // if (passenger != null) {
             //   double yOffset = this.getY() + 0;
             //   double xOffset = this.getX() - 3.0;
             //   double zOffset = this.getZ() - 3.0;
              //  passenger.setPosition(this.getX(), yOffset, zOffset);
          //  }
      //  }
    }

    @Override
    public boolean collidesWith(Entity other) {
        return canCollide(this, other);
    }

    public static boolean canCollide(Entity entity, Entity other) {
        return (other.isCollidable() || other.isPushable()) && !entity.isConnectedThroughVehicle(other);
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
    public boolean damage(DamageSource source, float amount) {
        if (!this.getWorld().isClient) {
            this.remove(RemovalReason.KILLED);
        }
        return super.damage(source, amount);
    }

    @Override
    public boolean canAddPassenger(Entity passenger) {
        return true; // or add custom filtering if needed
    }

    @Override
    public LivingEntity getControllingPassenger() {
        return this.getFirstPassenger() instanceof LivingEntity livingEntity ? livingEntity : null;
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        return ActionResult.PASS; // let other entities (like the seat) handle clicks
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

}