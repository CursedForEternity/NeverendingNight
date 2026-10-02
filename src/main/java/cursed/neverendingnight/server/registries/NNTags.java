package cursed.neverendingnight.server.registries;

import cursed.neverendingnight.Neverendingnight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class NNTags {
    public static final TagKey<Item> RUDE_BUSTER_HOLDER = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Neverendingnight.MODID, "rude_buster_holder"));

}
