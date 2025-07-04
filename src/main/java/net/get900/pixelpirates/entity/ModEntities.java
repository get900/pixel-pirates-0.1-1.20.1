package net.get900.pixelpirates.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.entity.custom.RaftEntity;
import net.get900.pixelpirates.entity.custom.RaftSeatEntity;
import net.get900.pixelpirates.entity.custom.ShipEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<ShipEntity> SHIP = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(PixelPirates.MOD_ID, "ship"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ShipEntity::new)
                    .dimensions(EntityDimensions.fixed(2.0f, 1.5f))
                    .trackRangeBlocks(120)
                    .build()
    );

    public static final EntityType<RaftEntity> RAFT = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(PixelPirates.MOD_ID, "raft"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, RaftEntity::new)
                    .dimensions(EntityDimensions.fixed(7.0f, 0.25f))
                    .trackRangeBlocks(100)
                    .trackedUpdateRate(1)
                    .build()
    );

    public static final EntityType<RaftSeatEntity> RAFT_SEAT = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(PixelPirates.MOD_ID, "raft_seat"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, RaftSeatEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.25f)) // adjust for testing
                    .trackRangeBlocks(90)
                    .trackedUpdateRate(1)
                    .build()
    );

    public static void registerModEntities() {
        PixelPirates.LOGGER.info("Registering Mod Entities for " + PixelPirates.MOD_ID);
    }
}