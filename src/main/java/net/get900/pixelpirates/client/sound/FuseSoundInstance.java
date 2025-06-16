package net.get900.pixelpirates.client.sound;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundEvent;

import java.util.HashMap;
import java.util.Map;

public class FuseSoundInstance extends PositionedSoundInstance {
    private static final Map<BlockPos, FuseSoundInstance> ACTIVE_FUSES = new HashMap<>();
    private final BlockPos fusePos;

    public FuseSoundInstance(SoundEvent soundEvent, BlockPos pos) {
        super(soundEvent.getId(), SoundCategory.BLOCKS,
                1.0f, 1.0f,
                SoundInstance.createRandom(),
                true, 0,
                SoundInstance.AttenuationType.LINEAR,
                pos.getX() + 0.5f,
                pos.getY() + 0.5f,
                pos.getZ() + 0.5f,
                false);
        this.fusePos = pos;
        ACTIVE_FUSES.put(pos, this);
    }

    public static void stopFuseAt(BlockPos pos) {
        FuseSoundInstance instance = ACTIVE_FUSES.remove(pos);
        if (instance != null) {
            MinecraftClient.getInstance().getSoundManager().stop(instance);
        }
    }

    public static void stopAllFuses() {
        for (FuseSoundInstance instance : ACTIVE_FUSES.values()) {
            MinecraftClient.getInstance().getSoundManager().stop(instance);
        }
        ACTIVE_FUSES.clear();
    }
}