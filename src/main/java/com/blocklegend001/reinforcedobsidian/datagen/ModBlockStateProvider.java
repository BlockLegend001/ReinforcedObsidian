package com.blocklegend001.reinforcedobsidian.datagen;

import com.blocklegend001.reinforcedobsidian.ReinforcedObsidian;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        String block = ReinforcedObsidian.REINFORCED_OBSIDIAN_BLOCK.getId().getPath();

        ModelFile blockModel = models().cubeAll(block, ResourceLocation.fromNamespaceAndPath(ReinforcedObsidian.MODID, "block/" + block));

        simpleBlockWithItem(ReinforcedObsidian.REINFORCED_OBSIDIAN_BLOCK.get(), blockModel);
    }

    @Override
    public String getName() {
        return "ReinforcedObsidian Blockstates";
    }
}
