package cursed.neverendingnight.core.speels;

import cursed.neverendingnight.core.util.QuadConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.lwjgl.system.MemoryUtil;

import java.util.List;

public class HealSpell extends AbstractSpell {
    @Override
    public int requiredTP() {
        return 30;
    }

    @Override
    public List<TagKey<Item>> requiredTag() {
        return List.of(ItemTags.LECTERN_BOOKS);
    }

    @Override
    public Component getName() {
        return Component.literal("Heal");
    }

    @Override
    protected QuadConsumer<Player, Entity, Level, Long> onCast() {
        return (player, entity, level, returnAddr) -> {
            player.heal(Math.min(player.getHealth() * 2, player.getMaxHealth()));
            // Set the byte at the return address to be 1/true
            MemoryUtil.memPutByte(returnAddr, (byte) 1);
        };
    }
}
