package com.blocklegend001.reinforcedobsidian.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

import static com.blocklegend001.reinforcedobsidian.ReinforcedObsidian.REINFORCED_OBSIDIAN;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.BUILDING_BLOCKS, REINFORCED_OBSIDIAN)
                        .pattern(" I ")
                        .pattern("IOI")
                        .pattern(" I ")
                        .define('I', Blocks.IRON_BARS)
                        .define('O', Blocks.OBSIDIAN)
                        .unlockedBy("has_obsidian", has(Blocks.OBSIDIAN))
                        .unlockedBy("has_iron_bars", has(Blocks.IRON_BARS))
                        .save(output);
            };
        };
    }
}