package net.mog.schizophreniacreeper.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.mog.schizophreniacreeper.SchizophreniaCreeper;
import net.mog.schizophreniacreeper.entity.SchizoCreeperEntity;

import java.util.Random;

public class SchizophreniaStatusEffect extends StatusEffect {
    private final Random rn = new Random();

    public SchizophreniaStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL, // whether beneficial or harmful for entities
                0x50C878); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            Entity SchizoCreeperEntity = new SchizoCreeperEntity(EntityType.CREEPER, entity.getWorld());
            int chance = 1_000;
//            CommandManager commandManager = Objects.requireNonNull(entity.getServer()).getCommandManager();
            if (rn.nextInt(0, chance) == 0) {
                entity.getWorld().spawnEntity(SchizoCreeperEntity);
                SchizoCreeperEntity.updatePosition(entity.getX(), entity.getY(), entity.getZ());
//                commandManager.execute(MinecraftServer.,"effect give " + SchizoCreeperEntity.getUuidAsString() + " minecraft:weakness infinite 255");
                SchizophreniaCreeper.LOGGER.info("YES");
            }
        }
    }
}
