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
    public static final Identifier REINFORCED_OBSIDIAN_BLOCK_ID = Identifier.fromNamespaceAndPath(MOD_ID, "reinforced_obsidian");
    public static final Identifier REINFORCED_OBSIDIAN_ITEM_ID = Identifier.fromNamespaceAndPath(MOD_ID, "reinforced_obsidian");

    public static final ResourceKey<Block> REINFORCED_OBSIDIAN_BLOCK_KEY =
            ResourceKey.create(Registries.BLOCK, REINFORCED_OBSIDIAN_BLOCK_ID);

    public static final ResourceKey<Item> REINFORCED_OBSIDIAN_ITEM_KEY =
            ResourceKey.create(Registries.ITEM, REINFORCED_OBSIDIAN_ITEM_ID);

    public static Block REINFORCED_OBSIDIAN = new Block(BlockBehaviour.Properties
            .ofFullCopy(Blocks.OBSIDIAN).
            requiresCorrectToolForDrops().
            strength(50.0f, 3600000.0f).
            setId(REINFORCED_OBSIDIAN_BLOCK_KEY));

    public static BlockItem REINFORCED_OBSIDIAN_ITEM = new BlockItem(REINFORCED_OBSIDIAN, new Item.Properties().
            setId(REINFORCED_OBSIDIAN_ITEM_KEY));

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
        Registry.register(BuiltInRegistries.BLOCK, REINFORCED_OBSIDIAN_BLOCK_KEY, REINFORCED_OBSIDIAN);
        Registry.register(BuiltInRegistries.ITEM, REINFORCED_OBSIDIAN_ITEM_KEY, REINFORCED_OBSIDIAN_ITEM);
    }
}