/* (C) TAMA Studios 2025 */
package cursed.neverendingnight.core.capabilities.interfaces;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;
import cursed.neverendingnight.core.speels.AbstractSpell;

public interface IPlayerCap extends INBTSerializable<CompoundTag> {
    AbstractSpell getSelectedSpell();

    void setSelectedSpell(AbstractSpell spell);
}
