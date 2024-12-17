package net.jackthee.magicandthings.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.jackthee.magicandthings.MagicAndThings;

public class ModEntities {

    public static final EntityType<CompressedCreeper> COMPRESSED_CREEPER = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("magicandthings", "compressed_creeper"),
            EntityType.Builder.create(CompressedCreeper::new, SpawnGroup.MONSTER).setDimensions(0.75f,0.75f).build("compressed_creeper")
    );

    public static void RegisterModEntities(){
        MagicAndThings.LOGGER.info("Registering Blocks for: " + MagicAndThings.MOD_ID);
    }

}
