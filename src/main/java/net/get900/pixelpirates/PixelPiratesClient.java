package net.get900.pixelpirates;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.networking.v1.EntityTrackingEvents;
import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.entity.client.*;
import net.get900.pixelpirates.entity.custom.RaftEntity;
import net.get900.pixelpirates.entity.custom.RaftSeatEntity;
import net.minecraft.entity.Entity;

import java.util.WeakHashMap;

public class PixelPiratesClient implements ClientModInitializer {
    private static final WeakHashMap<Integer, Boolean> mountedMap = new WeakHashMap<>();

    @Override
    public void onInitializeClient() {
        ModModelLayers.registerModelLayers();

        // Register renderers
        EntityRendererRegistry.register(ModEntities.SHIP, ShipEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHIP, ModelShip::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RAFT, RaftEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAFT, RaftModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RAFT_SEAT, RaftSeatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAFT_SEAT, RaftSeatModel::getTexturedModelData);

        // Debug log for seat tracking
        EntityTrackingEvents.START_TRACKING.register((entity, player) -> {
            if (entity instanceof RaftSeatEntity seat) {
                System.out.println("Client started tracking seat: " + seat.getId());
            }
        });

        // Safe mounting logic (optional for RaftSeatEntity setup)
        // If we later remove RaftSeatEntity in favor of direct riding, this can be removed.
    }
}