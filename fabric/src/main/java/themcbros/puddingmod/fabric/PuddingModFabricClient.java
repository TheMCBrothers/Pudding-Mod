package themcbros.puddingmod.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import themcbros.puddingmod.PuddingMod;

import java.util.function.Function;

public class PuddingModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        setupFluidRendering(FabricFluidInit.STILL_PUDDING, FabricFluidInit.FLOWING_PUDDING,
                new ResourceLocation(PuddingMod.MOD_ID, "pudding"), -1);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), FabricFluidInit.STILL_PUDDING, FabricFluidInit.FLOWING_PUDDING);
    }

    public static void setupFluidRendering(final Fluid still, final Fluid flowing, final ResourceLocation textureFluidId, final int color) {
        final ResourceLocation stillSpriteId = new ResourceLocation(textureFluidId.getNamespace(), "block/" + textureFluidId.getPath() + "_still");
        final ResourceLocation flowingSpriteId = new ResourceLocation(textureFluidId.getNamespace(), "block/" + textureFluidId.getPath() + "_flow");

        // If they're not already present, add the sprites to the block atlas
        ClientSpriteRegistryCallback.event(TextureAtlas.LOCATION_BLOCKS).register((atlasTexture, registry) -> {
            registry.register(stillSpriteId);
            registry.register(flowingSpriteId);
        });

        final ResourceLocation fluidId = Registry.FLUID.getKey(still);
        final ResourceLocation listenerId = new ResourceLocation(fluidId.getNamespace(), fluidId.getPath() + "_reload_listener");

        final TextureAtlasSprite[] fluidSprites = {null, null};

        ResourceManagerHelper.get(PackType.CLIENT_RESOURCES).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return listenerId;
            }

            /**
             * Get the sprites from the block atlas when resources are reloaded
             */
            @Override
            public void onResourceManagerReload(ResourceManager resourceManager) {
                final Function<ResourceLocation, TextureAtlasSprite> atlas = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS);
                fluidSprites[0] = atlas.apply(stillSpriteId);
                fluidSprites[1] = atlas.apply(flowingSpriteId);
            }
        });

        // The FluidRenderer gets the sprites and color from a FluidRenderHandler during rendering
        final FluidRenderHandler renderHandler = new FluidRenderHandler() {
            @Override
            public TextureAtlasSprite[] getFluidSprites(BlockAndTintGetter view, BlockPos pos, FluidState state) {
                return fluidSprites;
            }

            @Override
            public int getFluidColor(BlockAndTintGetter view, BlockPos pos, FluidState state) {
                return color;
            }
        };

        FluidRenderHandlerRegistry.INSTANCE.register(still, renderHandler);
        FluidRenderHandlerRegistry.INSTANCE.register(flowing, renderHandler);
    }
}
