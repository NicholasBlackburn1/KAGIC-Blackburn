package mod.kagic.client.render;

import mod.kagic.client.model.ModelBlueDiamond;
import mod.kagic.client.render.layers.LayerDiamondGlow;
import mod.kagic.entity.gem.EntityBlueDiamond;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderBlueDiamond extends RenderLivingBase<EntityBlueDiamond> {
	public RenderBlueDiamond() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelBlueDiamond(), 1.0F);
		this.addLayer(new LayerDiamondGlow(this));
	}
	@Override
	protected void preRenderCallback(EntityBlueDiamond entitylivingbaseIn, float partialTickTime) {
		GlStateManager.scale(3.0F, 3.0F, 3.0F);
	}
	@Override
	protected ResourceLocation getEntityTexture(EntityBlueDiamond entity) {
		return new ResourceLocation("ndbkagic:textures/entities/blue_diamond/blue_diamond_" + (entity.isHooded() ? "hooded" : "unhooded") + ".png");
	}
}
