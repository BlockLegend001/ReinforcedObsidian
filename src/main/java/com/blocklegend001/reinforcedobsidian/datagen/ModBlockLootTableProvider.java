package com.blocklegend001.reinforcedobsidian.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

import static com.blocklegend001.reinforcedobsidian.ReinforcedObsidian.REINFORCED_OBSIDIAN_BLOCK;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(REINFORCED_OBSIDIAN_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Set.of(REINFORCED_OBSIDIAN_BLOCK.get());
    }
}
