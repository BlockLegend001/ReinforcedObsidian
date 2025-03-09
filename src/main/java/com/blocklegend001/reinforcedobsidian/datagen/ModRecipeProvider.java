package com.blocklegend001.reinforcedobsidian.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

import static com.blocklegend001.reinforcedobsidian.ReinforcedObsidian.REINFORCED_OBSIDIAN_BLOCK;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, REINFORCED_OBSIDIAN_BLOCK.get())
                .pattern(" I ")
                .pattern("IOI")
                .pattern(" I ")
                .define('I', Blocks.IRON_BARS)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_iron_bars", has(Blocks.IRON_BARS))
                .unlockedBy("has_obsidian", has(Blocks.OBSIDIAN))
                .save(recipeOutput);
    }
}
