package cursed.neverendingnight.core.speels;

import cursed.neverendingnight.core.util.QuadConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.lwjgl.system.MemoryUtil;

import java.util.List;

public abstract class AbstractSpell {
    // Since we can't use static inside an abstract, or objects, and we need a form of static to check the result of the spell which is cast via consumer, we'll use direct memory management using MemoryUtil
    private long returnAddress = -1;
    /**
     * @return The List of Tag's required to cast this spell
     * Basically, if the players held item has at least one of the tags returned by this, they may cast the spell
     * If list returned is empty, the spell can be cast at any time regardless of held item
     */
    public abstract List<TagKey<Item>> requiredTag();

    /**
     * @return a QuadConsumer which will be executed based on `onCast().accept(caster, castedAt, level, returnAddr);`
     * This gets executed when the spell is cast
     */
    protected abstract QuadConsumer<Player, Entity, Level, Long> onCast();

    /**
     * @return The name to be displayed
     */
    public abstract Component getName();

    /**
     * @return Amount of TP required to cast the spell
     */
    public abstract int requiredTP();

    /**
     * Casts a spell
     * @param player You're a wizard player! (The player casting the spell)
     * @param targeted The entity targetted (Leave null if no target)
     * @param level The level the player is in
     * @return Whether the cast was successful
     */
    public boolean cast(Player player, Entity targeted, Level level) {
        // Allocate 1 byte to the return address
        returnAddress = MemoryUtil.nmemAlloc(Byte.BYTES);
        onCast().accept(player, targeted, level, returnAddress);
        // Save the returned value into a boolean
        boolean returned = MemoryUtil.memGetBoolean(returnAddress);
        // Free the memory used by the return address
        MemoryUtil.nmemFree(returnAddress);
        returnAddress = -1;

        return returned;
    }
}
