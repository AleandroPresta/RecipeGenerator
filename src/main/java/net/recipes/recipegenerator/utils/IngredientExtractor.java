package net.recipes.recipegenerator.utils;

import net.recipes.recipegenerator.entity.Ingredient;

import java.util.List;
import java.util.stream.Collectors;

public class IngredientExtractor {
    public static List<String> extract(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

}
