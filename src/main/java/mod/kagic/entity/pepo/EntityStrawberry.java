package mod.kagic.entity.pepo;

import mod.kagic.entity.EntityPepo;
import mod.kagic.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityStrawberry extends EntityPepo {
	public EntityStrawberry(World worldIn) {
		super(new ItemStack(ModItems.STRAWBERRY_SLICE), worldIn);
	}
	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			int total = this.rand.nextInt(5) + 3;
			for (int i = 0; i < total; ++i) {
				this.entityDropItem(this.dropItem, 0.0F);
			}
		}
	}
}
