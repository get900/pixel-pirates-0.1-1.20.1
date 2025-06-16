package net.get900.pixelpirates;

import net.fabricmc.api.ModInitializer;
import net.get900.pixelpirates.block.ModBlocks;
import net.get900.pixelpirates.item.ModItemGroups;
import net.get900.pixelpirates.item.ModItems;
import net.get900.pixelpirates.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PixelPirates implements ModInitializer {
	public static final String MOD_ID = "pixelpirates";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();
	}
}