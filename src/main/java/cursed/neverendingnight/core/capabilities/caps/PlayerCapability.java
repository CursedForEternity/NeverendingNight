/* (C) TAMA Studios 2025 */
package cursed.neverendingnight.core.capabilities.caps;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import cursed.neverendingnight.core.capabilities.interfaces.IPlayerCap;
import cursed.neverendingnight.core.speels.AbstractSpell;
import cursed.neverendingnight.core.speels.FireballSpell;

public class PlayerCapability implements IPlayerCap {
	Player player;
	int TP = 0;

	public PlayerCapability(Entity player) {
		this.player = (Player) player;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		// MAKE SURE YOU CHECK IF AN NBT TAG EXISTS BEFORE ATTEMPTING TO JUST GRAB IT!
		// If you try grabbing an NBT value that does not exist, the dedicated server ***WILL*** kick the player when they join for either "NullPointerException" or `p_123812_ doesn't contain value "tp"`
		this.TP = nbt.contains("tp") ? nbt.getInt("tp") : 0;
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag tag = new CompoundTag();
		tag.putInt("tp", this.TP);
		return tag;
	}

	@Override
	public AbstractSpell getSelectedSpell() {
		return new FireballSpell();
	}

	@Override
	public void setSelectedSpell(AbstractSpell spell) {

	}
}
