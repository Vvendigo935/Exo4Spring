package org.example.exo4spring.service;

import org.example.exo4spring.entity.Category;
import org.example.exo4spring.entity.Recipe;
import org.example.exo4spring.util.Categ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService implements BaseService{

    private List<Recipe> recipes = new ArrayList<>();
    private Long currentId = 1L;

@Override
public Recipe addRecipe(Recipe recipe) {
        recipe.setId(currentId++);
        recipes.add(recipe);
        return recipe;
    }

    @Override
    public Recipe getRecipeById(Long id) {
         return recipes.stream().filter(recipe -> recipe.getId().equals(id)).findFirst().orElse(null);

    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    @Override
    public Recipe updateRecipe(String name, List<String> ingredients, String instruction, Categ categ) {
    Recipe recipeMod = new Recipe();
    recipeMod.setName(name);
    recipeMod.setIngredients(ingredients);
    recipeMod.setInstruction(instruction);
    recipeMod.setCateg(categ);
    return recipeMod;
    }

    @Override
    public Recipe deleteRecipeById(Long id) {
    Recipe recipe = getRecipeById(id);
    recipes.remove(recipe);
    return null;
    }

    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public Category updateCategory(Categ name, String description) {
        return null;
    }

    @Override
    public Category deleteCategoryById(Long id) {
        return null;
    }


}
