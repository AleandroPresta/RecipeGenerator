package net.recipes.recipegenerator.generator;

import net.recipes.recipegenerator.entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeGeneratorTest {

    private Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = new Recipe();
    }

    @Test
    void testIngredients() {

        List<String> ingredients = List.of("flour", "sugar", "eggs");
        recipe.setIngredients(ingredients);

        List<String> retrievedIngredients = recipe.getIngredients();

        assertEquals(ingredients, retrievedIngredients, "Ingredients should match.");
    }

    @Test
    void testFindPossibleRecipes() {

        List<String> availableIngredients = List.of("flour", "sugar", "eggs", "milk", "chocolate");

        Recipe recipe1 = new Recipe(1L, "Recipe 1", List.of("flour", "sugar", "eggs"));
        Recipe recipe2 = new Recipe(2L, "Recipe 2", List.of("chocolate", "milk", "sugar"));
        Recipe recipe3 = new Recipe(3L, "Recipe 3", List.of("flour", "sugar", "milk", "vanilla"));

        List<Recipe> possibleRecipes = List.of(recipe1, recipe2, recipe3);

        List<Recipe> possibleMatches = RecipeGenerator.findPossibleRecipes(possibleRecipes, availableIngredients);

        assertEquals(2, possibleMatches.size(), "There should be 2 possible matches.");
        assertTrue(possibleMatches.contains(recipe1), "Recipe 1 should be a possible match.");
        assertTrue(possibleMatches.contains(recipe2), "Recipe 2 should be a possible match.");
        assertFalse(possibleMatches.contains(recipe3), "Recipe 3 should not be a possible match.");
    }
}
