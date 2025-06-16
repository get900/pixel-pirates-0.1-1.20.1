package net.get900.pixelpirates.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.block.custom.GrogBarrelBlock;
import net.get900.pixelpirates.block.custom.GunpowderBarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block GUNPOWDER_BARREL = registerBlock("gunpowder_barrel",
            new GunpowderBarrelBlock(FabricBlockSettings.copyOf(Blocks.BARREL)));
    public static final Block GROG_BARREL = registerBlock("grog_barrel",
            new GrogBarrelBlock(FabricBlockSettings.copyOf(Blocks.BARREL)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(PixelPirates.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(PixelPirates.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        PixelPirates.LOGGER.info("Registering ModBlocks for " + PixelPirates.MOD_ID);
    }
}
