package org.example.exo4spring.service;

import org.example.exo4spring.entity.Category;
import org.example.exo4spring.entity.Recipe;
import org.example.exo4spring.util.Categ;

import java.util.List;

public interface BaseService {


    Recipe addRecipe(Recipe recipe);

    Recipe getRecipeById(Long id);

    List<Recipe> getAllRecipes();

    Recipe updateRecipe(String name, List<String> ingredients, String instruction, Categ categ);

    Recipe deleteRecipeById(Long id);



    Category addCategory(Category category);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();

    Category updateCategory(Categ name, String description);

    Category deleteCategoryById(Long id);
}
