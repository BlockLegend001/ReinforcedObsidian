package com.blocklegend001.reinforcedobsidian;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class ReinforcedObsidian implements ModInitializer {
    public static final String MOD_ID = "reinforcedobsidian";

    public static Block REINFORCED_OBSIDIAN = new Block(BlockBehaviour.Properties
            .ofFullCopy(Blocks.OBSIDIAN).
            requiresCorrectToolForDrops().
            strength(50.0f, 3600000.0f).
            setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, "reinforced_obsidian_block"))));

    public static BlockItem REINFORCED_OBSIDIAN_ITEM = new BlockItem(REINFORCED_OBSIDIAN, new Item.Properties().
            setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "reinforced_obsidian_block"))));

    public static final CreativeModeTab REINFORCED_OBSIDIAN_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MOD_ID, "reinforced_obsidian_tab"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(REINFORCED_OBSIDIAN_ITEM))
            .title(Component.translatable("itemGroup.reinforcedobsidian"))
            .displayItems((context, entries) -> {
                entries.accept(REINFORCED_OBSIDIAN_ITEM);
            })
            .build());

    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, "reinforced_obsidian_block"), REINFORCED_OBSIDIAN);
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "reinforced_obsidian_block"), REINFORCED_OBSIDIAN_ITEM);
    }
}