package net.get900.pixelpirates.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PIXELPIRATES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PixelPirates.MOD_ID,"pixelpirates"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pixelpirates"))
                    .icon(() -> new ItemStack(ModItems.COIN)).entries((displayContext, entries) -> {
                        entries.add(ModItems.COIN);
                        entries.add(ModItems.PIRATE_COIN);
                        entries.add(ModItems.CUTLASS);
                        entries.add(ModItems.DAGGER);
                        entries.add(ModItems.DYNAMITE);
                        entries.add(ModItems.CANNON_BALL);
                        entries.add(ModItems.SHIP_ITEM);
                        //entries.add(ModItems.PIRATE_HAT);
                        entries.add(ModItems.GROG);
                        entries.add(ModItems.ROPE);
                        entries.add(ModItems.RAW_SHARK_MEAT);
                        entries.add(ModItems.KRAKEN_INK);
                        entries.add(ModItems.CANNON);
                        entries.add(ModItems.SAIL);
                        entries.add(ModItems.MAST_WITH_SAILS);
                        entries.add(ModItems.MAST);
                        entries.add(ModItems.COOKED_SHARK_MEAT);

                        entries.add(ModBlocks.GUNPOWDER_BARREL);
                        entries.add(ModBlocks.GROG_BARREL);

                    }).build());



    public static void registerItemGroups() {
        PixelPirates.LOGGER.info("Registering Item Groups for " + PixelPirates.MOD_ID);
    }
}
