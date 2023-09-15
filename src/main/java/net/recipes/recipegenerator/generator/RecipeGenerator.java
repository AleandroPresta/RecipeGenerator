package net.recipes.recipegenerator.generator;

import net.recipes.recipegenerator.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeGenerator {

    public static List<Recipe> findPossibleRecipes(List<Recipe> possibleRecipes, List<String> availableIngredients) {
        List<Recipe> possibleMatches = new ArrayList<>();

        for (Recipe recipe : possibleRecipes) {
            if (canBeCreatedWithIngredients(recipe, availableIngredients)) {
                possibleMatches.add(recipe);
            }
        }

        return possibleMatches;
    }

    public static boolean canBeCreatedWithIngredients(Recipe recipe, List<String> availableIngredients) {
        // Check if all ingredients in the recipe are present in the list of available ingredients
        return availableIngredients.containsAll(recipe.getIngredients());
    }
}
