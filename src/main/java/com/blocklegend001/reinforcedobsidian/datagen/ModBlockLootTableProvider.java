package com.blocklegend001.reinforcedobsidian.datagen;

import com.blocklegend001.reinforcedobsidian.ReinforcedObsidian;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.blocklegend001.reinforcedobsidian.ReinforcedObsidian.REINFORCED_OBSIDIAN_BLOCK;

public class ModBlockLootTableProvider extends LootTableProvider {

    public ModBlockLootTableProvider() {
        super(Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootSubProvider::new, LootContextParamSets.BLOCK)
        ));
    }

    private record ModLootables(LootTableSubProvider.Context output) implements LootTableSubProvider {
        @Override
        public void run() {

        }
    }


    private static class ModBlockLootSubProvider extends BlockLootSubProvider {
        protected ModBlockLootSubProvider(LootTableSubProvider.Context context) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), context);
        }

        @Override
        protected void generate() {
            dropSelf(REINFORCED_OBSIDIAN_BLOCK.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ReinforcedObsidian.BLOCKS.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toList());
        }
    }
}