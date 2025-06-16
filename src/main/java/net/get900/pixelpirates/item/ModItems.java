package net.get900.pixelpirates.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.block.ModBlocks;
import net.get900.pixelpirates.item.custom.GrogItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COIN = registerItem("coin", new Item(new FabricItemSettings()));
    public static final Item PIRATE_COIN = registerItem("pirate_coin", new Item(new FabricItemSettings()));
    public static final Item KRAKEN_INK = registerItem("kraken_ink", new Item(new FabricItemSettings()));
    public static final Item DYNAMITE = registerItem("dynamite", new Item(new FabricItemSettings()));
    public static final Item CANNON_BALL = registerItem("cannon_ball", new Item(new FabricItemSettings()));
    public static final Item SHIP = registerItem("ship", new Item(new FabricItemSettings()));
    public static final Item ROPE = registerItem("rope", new Item(new FabricItemSettings()));
    public static final Item CANNON = registerItem("cannon", new Item(new FabricItemSettings()));
    public static final Item SAIL = registerItem("sail", new Item(new FabricItemSettings()));
    public static final Item MAST_WITH_SAILS = registerItem("mast_with_sails", new Item(new FabricItemSettings()));
    public static final Item MAST = registerItem("mast", new Item(new FabricItemSettings()));

    //Special items

    //Food items
    public static final Item GROG = Registry.register(Registries.ITEM, new Identifier(PixelPirates.MOD_ID, "grog"),
            new GrogItem(new FabricItemSettings().maxCount(16).food(FoodComponents.HONEY_BOTTLE)));
    public static final Item COOKED_SHARK_MEAT = Registry.register(Registries.ITEM, new Identifier(PixelPirates.MOD_ID, "cooked_shark_meat"),
            new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_SHARK_MEAT)));
    public static final Item RAW_SHARK_MEAT = Registry.register(Registries.ITEM, new Identifier(PixelPirates.MOD_ID, "raw_shark_meat"),
            new Item(new FabricItemSettings().food(ModFoodComponents.RAW_SHARK_MEAT)));
    //Fuel items

    //Tool items

    //Armor items
    public static final Item PIRATE_HAT = registerItem("pirate_hat",
            new ArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, new FabricItemSettings().maxCount(1)));

    //Weapon items
    public static final Item CUTLASS = registerItem("cutlass",
            new SwordItem(ModToolMaterial.PIRATE,0, 0, new FabricItemSettings()));
    public static final Item DAGGER = registerItem("dagger",
            new SwordItem(ModToolMaterial.PIRATE,-3, 3f, new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(COIN);
        entries.add(PIRATE_COIN);
        entries.add(CUTLASS);
        entries.add(DAGGER);
        entries.add(DYNAMITE);
        entries.add(CANNON_BALL);
        entries.add(SHIP);
        entries.add(PIRATE_HAT);
        entries.add(ROPE);
        entries.add(RAW_SHARK_MEAT);
        entries.add(KRAKEN_INK);
        entries.add(CANNON);
        entries.add(SAIL);
        entries.add(MAST_WITH_SAILS);
        entries.add(MAST);
        entries.add(COOKED_SHARK_MEAT);

        entries.add(ModBlocks.GUNPOWDER_BARREL);
        entries.add(ModBlocks.GROG_BARREL);

        //Special items

        //Food items
        entries.add(GROG);
        //Fuel items

        //Tool items
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PixelPirates.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PixelPirates.LOGGER.info("Registering Mod Items for " + PixelPirates.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
