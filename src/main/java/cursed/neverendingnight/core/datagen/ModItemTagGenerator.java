package cursed.neverendingnight.core.datagen;

import cursed.neverendingnight.Neverendingnight;
import cursed.neverendingnight.server.registries.NNTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Neverendingnight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(NNTags.RUDE_BUSTER_HOLDER)
                .add(Items.DIAMOND_AXE)
                .add(Items.GOLDEN_AXE)
                .add(Items.IRON_AXE)
                .add(Items.STONE_AXE)
                .add(Items.NETHERITE_AXE)
                .add(Items.WOODEN_AXE)
                .add(Items.STICK)
        ;
    }
}
