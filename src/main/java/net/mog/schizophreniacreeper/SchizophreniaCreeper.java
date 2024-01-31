package net.mog.schizophreniacreeper;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mog.schizophreniacreeper.entity.SchizoCreeperEntity;

public class SchizophreniaCreeper implements ModInitializer {
    public static final String MOD_ID = "schizophrenia-creeper";
    
    public static final EntityType<SchizoCreeperEntity> SCHIZO_CREEPER = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "schizo_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, SchizoCreeperEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build()
    );
    
	@Override
	public void onInitialize() {
        
    }
}