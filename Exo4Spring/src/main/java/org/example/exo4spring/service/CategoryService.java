package org.example.exo4spring.service;

import org.example.exo4spring.entity.Category;
import org.example.exo4spring.entity.Recipe;
import org.example.exo4spring.util.Categ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements BaseService {

    private List<Category> categories = new ArrayList<>();
    private Long currentId = 1L;


    @Override
    public Recipe addRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return null;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return List.of();
    }

    @Override
    public Recipe updateRecipe(String name, List<String> ingredients, String instruction, Categ categ) {
        return null;
    }

    @Override
    public Recipe deleteRecipeById(Long id) {
        return null;
    }

    @Override
    public Category addCategory(Category category) {
        category.setId(currentId++);
        categories.add(category);
        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categories.stream().filter(category -> category.getId().equals(id)).findFirst().orElse(null);

    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category updateCategory(Categ name, String description) {
        Category categoryMod = new Category();
        categoryMod.setName(name);
        categoryMod.setDescription(description);
        return categoryMod;
    }

    @Override
    public Category deleteCategoryById(Long id) {
        Category category = getCategoryById(id);
        categories.remove(category);
        return null;
    }


}
