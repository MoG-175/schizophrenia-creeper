package net.mog.schizophreniacreeper;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.mog.schizophreniacreeper.entity.SchizoCreeperRenderer;

public class SchizophreniaCreeperClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(SchizophreniaCreeper.SCHIZO_CREEPER, SchizoCreeperRenderer::new);
    }
}
