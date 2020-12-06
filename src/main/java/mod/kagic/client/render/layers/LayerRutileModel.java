package mod.kagic.client.render.layers;

import mod.kagic.client.render.RenderRutile;
import mod.kagic.entity.EntityGem;
import mod.kagic.entity.gem.EntityRutile;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class LayerRutileModel implements LayerRenderer<EntityRutile> {
	private final RenderRutile gemRenderer;

	public LayerRutileModel(RenderRutile gemRenderer) {
		this.gemRenderer = gemRenderer;
	}
	
	@Override
	public void doRenderLayer(EntityRutile gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.gemRenderer.bindTexture(this.getTexture(gem));
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableBlend();
		this.gemRenderer.getModel(gem.isDefective()).setModelAttributes(this.gemRenderer.getMainModel());
		this.gemRenderer.getModel(gem.isDefective()).render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}
	
	public ResourceLocation getTexture(EntityGem gem) {
		return new ResourceLocation("ndbkagic:textures/entities/rutile/rutile.png");
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
	
}
