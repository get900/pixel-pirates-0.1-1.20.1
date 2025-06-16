package net.get900.pixelpirates.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

public class ModSounds {
    public static final Identifier BARREL_FUSE_ID = new Identifier("pixelpirates", "barrel_fuse");
    public static final SoundEvent BARREL_FUSE = SoundEvent.of(BARREL_FUSE_ID);

    public static final Identifier BARREL_EXPLOSION_ID = new Identifier("pixelpirates", "barrel_explosion");
    public static final SoundEvent BARREL_EXPLOSION = SoundEvent.of(BARREL_EXPLOSION_ID);

    public static final Identifier FUSE_EXTINGUISH_ID = new Identifier("pixelpirates", "fuse_extinguish");
    public static final SoundEvent FUSE_EXTINGUISH = SoundEvent.of(FUSE_EXTINGUISH_ID);

    public static void registerSounds() {
        Registry.register(Registries.SOUND_EVENT, BARREL_FUSE_ID, BARREL_FUSE);
        Registry.register(Registries.SOUND_EVENT, BARREL_EXPLOSION_ID, BARREL_EXPLOSION);
        Registry.register(Registries.SOUND_EVENT, FUSE_EXTINGUISH_ID, FUSE_EXTINGUISH);
    }
}