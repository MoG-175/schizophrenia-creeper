package net.mog.schizophreniacreeper.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class SchizoCreeperEntity extends CreeperEntity {
    public SchizoCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canExplosionDestroyBlock(Explosion explosion, BlockView world, BlockPos pos, BlockState state, float explosionPower) {
        return false;
    }
    @Override
    public boolean canTakeDamage() {
        return false;
    }
    
//    @Override
//    public boolean shouldRender(double distance) {
//        List<? extends PlayerEntity> allPlayers = this.getWorld().getPlayers();
//        return allPlayers.stream().map(x -> x.hasStatusEffect(SchizophreniaCreeper.SCHIZO));
//    }
}
