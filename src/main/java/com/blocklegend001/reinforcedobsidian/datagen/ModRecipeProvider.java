package com.blocklegend001.reinforcedobsidian.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Blocks;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.blocklegend001.reinforcedobsidian.ReinforcedObsidian.REINFORCED_OBSIDIAN_BLOCK;

public class ModRecipeProvider extends RecipeProvider {
    protected ModRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.BUILDING_BLOCKS, REINFORCED_OBSIDIAN_BLOCK.get())
                .pattern(" I ")
                .pattern("IOI")
                .pattern(" I ")
                .define('I', Blocks.IRON_BARS)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_iron_bars", has(Blocks.IRON_BARS))
                .unlockedBy("has_obsidian", has(Blocks.OBSIDIAN))
                .save(this.output);
    }

    public static MultiRegistryBootstrap create() {
        return new MultiRegistryBootstrap() {
            @Override
            public Set<ResourceKey<? extends Registry<?>>> requestedRegistries() {
                return Set.of(Registries.RECIPE, Registries.ADVANCEMENT);
            }

            @Override
            public void run(MultiRegistryBootstrap.BootstrapGetter registries) {
                new ModRecipeProvider(registries.get(Registries.RECIPE), registries.get(Registries.ADVANCEMENT)).buildRecipes();
            }
        };
    }
}
