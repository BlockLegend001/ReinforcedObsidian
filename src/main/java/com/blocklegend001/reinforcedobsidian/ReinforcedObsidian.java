package com.blocklegend001.reinforcedobsidian;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(ReinforcedObsidian.MODID)
public class ReinforcedObsidian {

    public static final String MODID = "reinforcedobsidian";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<Block> REINFORCED_OBSIDIAN_BLOCK = BLOCKS.register("reinforced_obsidian_block", () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).
                    requiresCorrectToolForDrops().
                    strength(50.0f, 3600000.0f
                    )));

    public static final RegistryObject<Item> REINFORCED_OBSIDIAN_ITEM = ITEMS.register("reinforced_obsidian_block", () -> new BlockItem(REINFORCED_OBSIDIAN_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> REINFORCED_OBSIDIAN_TAB = CREATIVE_MODE_TABS.register("reinforcedobsidian", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.reinforcedobsidian"))
            .icon(() -> REINFORCED_OBSIDIAN_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(REINFORCED_OBSIDIAN_ITEM.get());
            }).build());

    public ReinforcedObsidian(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
