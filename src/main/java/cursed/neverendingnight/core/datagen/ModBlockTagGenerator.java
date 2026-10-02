package cursed.neverendingnight.core.datagen;

import cursed.neverendingnight.Neverendingnight;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Neverendingnight.MODID, existingFileHelper);
    }

    /**
     * This hurts my eyes.
     * - Codiak
     */
    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BlockTags.NEEDS_STONE_TOOL);
        this.tag(BlockTags.NEEDS_IRON_TOOL)

        ;
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)

        ;
        this.tag(BlockTags.MINEABLE_WITH_AXE)

        ;
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)

        ;
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)

        ;
        this.tag(BlockTags.FENCES)

        ;
        this.tag(BlockTags.FENCE_GATES)

        ;
        this.tag(BlockTags.WALLS)

        ;
    }
}
