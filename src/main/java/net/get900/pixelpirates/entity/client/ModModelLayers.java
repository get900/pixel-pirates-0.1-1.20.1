package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.PixelPirates;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer SHIP =
            new EntityModelLayer(new Identifier(PixelPirates.MOD_ID, "ship"), "main");
}