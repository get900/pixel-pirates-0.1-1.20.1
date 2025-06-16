package net.get900.pixelpirates.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent RAW_SHARK_MEAT = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.3f)
            .meat()
            .build();

    public static final FoodComponent COOKED_SHARK_MEAT = new FoodComponent.Builder()
            .hunger(8)
            .saturationModifier(0.8f)
            .meat()
            .build();
}