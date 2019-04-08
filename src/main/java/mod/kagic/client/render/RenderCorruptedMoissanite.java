package mod.kagic.client.render;

import java.util.Iterator;

import mod.kagic.client.model.ModelAgate;
import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.model.corrupted.ModelMoissanite;
import mod.kagic.client.render.layers.LayerAgateBand;
import mod.kagic.client.render.layers.LayerAgateHair;
import mod.kagic.client.render.layers.LayerAgateItem;
import mod.kagic.client.render.layers.LayerBirthdayHat;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.client.render.layers.LayerInsignia;
import mod.kagic.client.render.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.layers.LayerQuartzCape;
import mod.kagic.client.render.layers.LayerUniform;
import mod.kagic.client.render.layers.LayerVisor;
import mod.kagic.client.render.layers.LayerWitchHat;
import mod.kagic.entity.gem.EntityAgate;
import mod.kagic.entity.gem.EntityAmethyst;
import mod.kagic.entity.gem.GemPlacements;
import mod.kagic.entity.gem.corrupted.EntityCorruptedMoissanite;
import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderCorruptedMoissanite extends RenderGemBase<EntityCorruptedMoissanite> {

	public RenderCorruptedMoissanite() {
        super(Minecraft.getMinecraft().getRenderManager(), new ModelMoissanite(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityCorruptedMoissanite moissanite, float partialTickTime) {
		GlStateManager.scale(2F, 2F, 2F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCorruptedMoissanite moissanite) {
		return new ResourceLocation("kagic:textures/entities/corrupted/moissanite/moissanite.png");
	}
}
