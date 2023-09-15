package net.recipes.recipegenerator.mapper;

import net.recipes.recipegenerator.dto.RecipeDto;
import net.recipes.recipegenerator.entity.Recipe;

public class RecipeMapper {

    public static RecipeDto mapToRecipeDto(Recipe recipe) {
        return new RecipeDto(
                recipe.getId(),
                recipe.getName(),
                recipe.getIngredients()
        );
    }

    public static Recipe mapToRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        recipe.setIngredients(recipeDto.getIngredients());
        return recipe;
    }

}
