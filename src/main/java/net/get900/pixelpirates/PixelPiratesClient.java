package net.get900.pixelpirates;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.entity.client.*;

public class PixelPiratesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelLayers.registerModelLayers();
        EntityRendererRegistry.register(ModEntities.SHIP, ShipEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHIP, ModelShip::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RAFT, RaftEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAFT, RaftModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RAFT_SEAT, RaftSeatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAFT_SEAT, RaftSeatModel::getTexturedModelData
        );
    }
}
