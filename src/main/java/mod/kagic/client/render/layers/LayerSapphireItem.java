package mod.kagic.client.render.layers;

import mod.kagic.client.render.RenderSapphire;
import mod.kagic.entity.gem.EntitySapphire;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerSapphireItem implements LayerRenderer<EntitySapphire> {
	protected final RenderSapphire livingEntityRenderer;

	public LayerSapphireItem(RenderSapphire renderSapphire) {
		this.livingEntityRenderer = renderSapphire;
	}
	
	@Override
	public void doRenderLayer(EntitySapphire entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		boolean flag = entitylivingbaseIn.getPrimaryHand() == EnumHandSide.RIGHT;
		ItemStack itemstack = flag ? entitylivingbaseIn.getHeldItemOffhand() : entitylivingbaseIn.getHeldItemMainhand();
		ItemStack itemstack1 = flag ? entitylivingbaseIn.getHeldItemMainhand() : entitylivingbaseIn.getHeldItemOffhand();
		if (!itemstack.isEmpty() || !itemstack1.isEmpty()) {
			GlStateManager.pushMatrix();
			this.renderHeldItem(entitylivingbaseIn, itemstack1, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
			this.renderHeldItem(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
			GlStateManager.popMatrix();
		}
	}

	private void renderHeldItem(EntitySapphire entity, ItemStack stack, ItemCameraTransforms.TransformType camera, EnumHandSide handSide) {
		if (!stack.isEmpty()) {
			GlStateManager.pushMatrix();
			if (entity.isSneaking()) {
				GlStateManager.translate(0.0F, 0.2F, 0.0F);
			}
			this.setSide(handSide);
			GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
			boolean flag = handSide == EnumHandSide.LEFT;
			GlStateManager.translate((flag ? -1 : 1) / 16.0F, 0.125F, -0.6F);
			Minecraft.getMinecraft().getItemRenderer().renderItemSide(entity, stack, camera, flag);
			GlStateManager.popMatrix();
		}
	}

	protected void setSide(EnumHandSide side) {
		((ModelBiped) this.livingEntityRenderer.getMainModel()).postRenderArm(0.04F, side);
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}