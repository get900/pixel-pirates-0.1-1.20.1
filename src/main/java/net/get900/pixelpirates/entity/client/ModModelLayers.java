package net.get900.pixelpirates.entity.client;


import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.get900.pixelpirates.PixelPirates;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer SHIP =
            new EntityModelLayer(new Identifier(PixelPirates.MOD_ID, "ship"), "main");

    public static final EntityModelLayer RAFT =
                new EntityModelLayer(new Identifier(PixelPirates.MOD_ID, "raft"), "main");

    public static final EntityModelLayer RAFT_SEAT =
            new EntityModelLayer(new Identifier(PixelPirates.MOD_ID, "raft_seat"), "main");

    public static void registerModelLayers() {
        }

}