package com.blocklegend001.reinforcedobsidian.datagen;

import com.blocklegend001.reinforcedobsidian.ReinforcedObsidian;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

import static com.blocklegend001.reinforcedobsidian.ReinforcedObsidian.REINFORCED_OBSIDIAN_BLOCK;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider, ReinforcedObsidian.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(REINFORCED_OBSIDIAN_BLOCK.get().builtInRegistryHolder().key());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(REINFORCED_OBSIDIAN_BLOCK.get().builtInRegistryHolder().key());

        tag(BlockTags.WITHER_IMMUNE)
                .add(REINFORCED_OBSIDIAN_BLOCK.get().builtInRegistryHolder().key());
    }
}
