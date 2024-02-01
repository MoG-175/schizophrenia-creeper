package net.mog.schizophreniacreeper;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mog.schizophreniacreeper.entity.SchizoCreeperEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchizophreniaCreeper implements ModInitializer {
    public static final String MOD_ID = "schizophrenia-creeper";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final EntityType<SchizoCreeperEntity> SCHIZO_CREEPER =
            Registry.register(
                    Registries.ENTITY_TYPE,
                    new Identifier(MOD_ID, "schizo_creeper"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SchizoCreeperEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build()
            );
    
	@Override
	public void onInitialize() {
        FabricDefaultAttributeRegistry.register(SCHIZO_CREEPER, CreeperEntity.createCreeperAttributes());
    }
}