package net.get900.pixelpirates;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.entity.client.ModModelLayers;
import net.get900.pixelpirates.entity.client.ModelShip;
import net.get900.pixelpirates.entity.client.RaftModel;
import net.get900.pixelpirates.entity.client.ShipEntityRenderer;
import net.get900.pixelpirates.entity.client.RaftEntityRenderer;

public class PixelPiratesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SHIP, ShipEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHIP, ModelShip::getTexturedModelData);
        ModModelLayers.registerModelLayers();
        EntityRendererRegistry.register(ModEntities.RAFT, RaftEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAFT, RaftModel::getTexturedModelData);
    }
}
