package org.example.exo4spring.service;

import org.example.exo4spring.entity.Recipe;
import org.example.exo4spring.util.Categ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("recipeService")
public class RecipeService implements BaseService<Recipe> {

    private List<Recipe> recipes = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public Recipe add(Recipe recipe) {
        recipe.setId(currentId++);
        recipes.add(recipe);
        return recipe;
    }

    @Override
    public Recipe getById(Long id) {
        return recipes.stream().filter(recipe -> recipe.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Recipe> getAll() {
        return recipes;
    }

    @Override
    public Recipe update(Recipe recipe) {
        recipes.get(recipes.indexOf(recipe)).setName(recipe.getName());
        recipes.get(recipes.indexOf(recipe)).setInstruction(recipe.getInstruction());
        recipes.get(recipes.indexOf(recipe)).setIngredients(recipe.getIngredients());
        recipes.get(recipes.indexOf(recipe)).setCateg(recipe.getCateg());
        return recipe;
    }

    @Override
    public Recipe delete(Long id) {
        Recipe recipe = getById(id);
        recipes.remove(recipe);
        return null;
    }

}