package mod.kagic.client.render;

import mod.kagic.client.model.corrupted.ModelCorruptedQuartz;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.client.render.layers.LayerHair;
import mod.kagic.client.render.layers.LayerSkin;
import mod.kagic.entity.gem.corrupted.EntityCorruptedAmethyst;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;

public class RenderCorruptedAmethyst extends RenderLiving<EntityCorruptedAmethyst> {

	public RenderCorruptedAmethyst() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelCorruptedQuartz(), 2F);
		
		this.addLayer(new LayerSkin(this, 0F, "corrupted/amethyst"));
		this.addLayer(new LayerHair(this, 0F, "corrupted/amethyst"));
		this.addLayer(new LayerGemPlacement(this, "corrupted/amethyst"));
		/*
		 * if (KAGIC.isBirthday()) { this.addLayer(new
		 * LayerBirthdayHat(this)); } else if
		 * (KAGIC.isHalloween()) { this.addLayer(new
		 * LayerWitchHat(this)); }
		 */
	}
	
	@Override
	protected void preRenderCallback(EntityCorruptedAmethyst amethyst, float partialTickTime) {
		GlStateManager.scale(2F, 2F, 2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCorruptedAmethyst amethyst) {
		return new ResourceLocation("ndbkagic:textures/entities/corrupted/amethyst/amethyst.png");
	}
}
