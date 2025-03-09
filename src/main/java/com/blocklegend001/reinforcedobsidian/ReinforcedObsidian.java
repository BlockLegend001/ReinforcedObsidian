package com.blocklegend001.reinforcedobsidian;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ReinforcedObsidian implements ModInitializer {
    public static final String MOD_ID = "reinforcedobsidian";

    public static Block REINFORCED_OBSIDIAN = new Block(Block.Settings.
            copy(Blocks.OBSIDIAN).
            requiresTool().
            strength(50.0f, 3600000.0f));
    public static BlockItem REINFORCED_OBSIDIAN_ITEM = new BlockItem(REINFORCED_OBSIDIAN, new Item.Settings());

    public static final ItemGroup REINFORCED_OBSIDIAN_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(REINFORCED_OBSIDIAN_ITEM))
            .displayName(Text.translatable("itemGroup.reinforcedobsidian"))
            .entries((context, entries) -> {
                entries.add(REINFORCED_OBSIDIAN_ITEM);
            })
            .build();

    @Override
    public void onInitialize() {
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "reinforced_obsidian_block"), REINFORCED_OBSIDIAN);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "reinforced_obsidian_block"), REINFORCED_OBSIDIAN_ITEM);
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "reincorced_obsidian_tab"), REINFORCED_OBSIDIAN_TAB);
    }
}
