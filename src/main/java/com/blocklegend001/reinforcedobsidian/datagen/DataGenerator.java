package com.blocklegend001.reinforcedobsidian.datagen;

import com.blocklegend001.reinforcedobsidian.ReinforcedObsidian;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ReinforcedObsidian.MODID)
public class DataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        var builder = new RegistrySetBuilder()
                .add(Registries.LOOT_TABLE, new ModBlockLootTableProvider())
                .add(ModRecipeProvider.create());
        event.createReloadableRegistryObjects(builder);
        event.createProvider(ModBlockTagProvider::new);
        event.createProvider(ModModelProvider::new);
    }
}