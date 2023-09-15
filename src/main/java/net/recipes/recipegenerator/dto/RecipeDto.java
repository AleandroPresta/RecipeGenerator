package net.recipes.recipegenerator.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {

    private Long id;
    private String name;
    private List<String> ingredients;

}

