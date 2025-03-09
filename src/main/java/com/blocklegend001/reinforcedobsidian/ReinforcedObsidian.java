package com.blocklegend001.reinforcedobsidian;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(ReinforcedObsidian.MODID)
public class ReinforcedObsidian {
    public static final String MODID = "reinforcedobsidian";

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredBlock<Block> REINFORCED_OBSIDIAN_BLOCK = BLOCKS.registerSimpleBlock("reinforced_obsidian_block", BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).
            strength(50.0f, 3600000.0f).
            requiresCorrectToolForDrops());

    public static final DeferredItem<BlockItem> REINFORCED_OBSIDIAN_ITEM = ITEMS.register("reinforced_obsidian_block", () -> new BlockItem(REINFORCED_OBSIDIAN_BLOCK.get(), new Item.Properties()));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> REINFORCED_OBSIDIAN_TAB = CREATIVE_MODE_TABS.register("reinforcedobsidian", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.reinforcedobsidian"))
            .icon(() -> REINFORCED_OBSIDIAN_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(REINFORCED_OBSIDIAN_ITEM.get());
            }).build());

    public ReinforcedObsidian(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
