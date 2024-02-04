package net.mog.schizophreniacreeper.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;

import java.util.Objects;
import java.util.UUID;

public class SchizoCreeperEntity extends CreeperEntity {
    private int currentFuseTime;
    public UUID Owner = null;
    
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

    @Override
    public void tick() {
        if (this.isAlive()) {
            int i;
            if (this.isIgnited()) {
                this.setFuseSpeed(1);
            }
            if ((i = this.getFuseSpeed()) > 0 && this.currentFuseTime == 0) {
                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0f, 0.5f);
                this.emitGameEvent(GameEvent.PRIME_FUSE);
            }
            this.currentFuseTime += i;
            if (this.currentFuseTime < 0) {
                this.currentFuseTime = 0;
            }
            int fuseTime = 30;
            if (this.currentFuseTime >= fuseTime) {
                this.currentFuseTime = fuseTime;
                this.explode();
            }
        }
        super.tick();
    }

    private void explode() {
        if (!this.getWorld().isClient) {
            this.dead = true;
            this.discard();
        }
    }
    
    @Override
    public boolean shouldRender(double distance) {
        if (Owner == null) {
            return super.shouldRender(distance);
        } else {
            return this.getWorld().isClient && Objects.requireNonNull(this.getWorld().getClosestPlayer(this, 1000f)).getUuid().equals(Owner);
        }
    }
}
