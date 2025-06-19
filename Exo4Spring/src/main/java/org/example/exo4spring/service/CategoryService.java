package org.example.exo4spring.service;

import org.example.exo4spring.entity.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements BaseService {

    private List<Category> categories = new ArrayList<>();
    private Long currentId = 1L;


    @Override
    public Category add(Category category) {
        category.setId(currentId++);
        categories.add(category);
        return category;
    }

    @Override
    public Category getById(Long id) {
        return categories.stream().filter(category -> category.getId().equals(id)).findFirst().orElse(null);

    }

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Category update(Category category) {
categories.get(categories.indexOf(category)).setName(category.getName());
categories.get(categories.indexOf(category)).setDescription(category.getDescription());
        return category;
    }

    @Override
    public Category delete(Long id) {
        Category category = getById(id);
        categories.remove(category);
        return null;
    }


}
