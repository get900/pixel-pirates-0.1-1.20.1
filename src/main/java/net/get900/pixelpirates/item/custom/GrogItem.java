package net.get900.pixelpirates.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GrogItem extends Item {
    public GrogItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            player.getItemCooldownManager().set(this, 20);
            stack.decrement(1); // consume grog

            // Apply drunken effects
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 15 * 20, 1)); // 15s
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 10 * 20, 0));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 10 * 20, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 20, 0));
        }

        player.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1.0F, 1.0F);
        return TypedActionResult.success(stack, world.isClient());
    }
}