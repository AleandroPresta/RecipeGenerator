package net.recipes.recipegenerator.utils;

import net.recipes.recipegenerator.entity.Ingredient;
import org.junit.jupiter.api.Test;
import utils.IngredientExtractor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientExtractorTest {

    @Test
    public void testExtract() {
        List<Ingredient> ingredientList = List.of(
                new Ingredient(1L, "Flour"),
                new Ingredient(2L, "Sugar"),
                new Ingredient(3L, "Eggs")
        );

        List<String> expectedNames = List.of("Flour", "Sugar", "Eggs");
        List<String> actualNames = IngredientExtractor.extract(ingredientList);

        assertEquals(expectedNames, actualNames);
    }
}
