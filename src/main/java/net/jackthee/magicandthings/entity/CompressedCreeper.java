package net.jackthee.magicandthings.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class CompressedCreeper extends PathAwareEntity {

    public CompressedCreeper(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}
