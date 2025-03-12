package com.blocklegend001.reinforcedobisdian;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ReinforcedObsidian implements ModInitializer {
	public static final String MOD_ID = "reinforcedobsidian";

	public static Block REINFORCED_OBSIDIAN = new Block(QuiltBlockSettings.
			copyOf(Blocks.OBSIDIAN).
			requiresTool().
			strength(50.0f, 3600000.0f));
	public static BlockItem REINFORCED_OBSIDIAN_ITEM = new BlockItem(REINFORCED_OBSIDIAN, new QuiltItemSettings());

	public static final ItemGroup REINFORCED_OBSIDIAN_TAB = FabricItemGroup.builder()
			.icon(() -> new ItemStack(REINFORCED_OBSIDIAN_ITEM))
			.name(Text.translatable("itemGroup.reinforcedobsidian"))
			.entries((context, entries) -> {
				entries.addItem(REINFORCED_OBSIDIAN_ITEM);
			})
			.build();

	@Override
	public void onInitialize(ModContainer mod) {
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "reinforced_obsidian_block"), REINFORCED_OBSIDIAN);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "reinforced_obsidian_block"), REINFORCED_OBSIDIAN_ITEM);
		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "reincorced_obsidian_tab"), REINFORCED_OBSIDIAN_TAB);
	}
}
