package org.example.exo4spring.controler;

import jakarta.validation.Valid;
import jdk.jfr.Category;
import org.example.exo4spring.entity.Recipe;
import org.example.exo4spring.service.BaseService;
import org.example.exo4spring.service.RecipeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class RecipeControler {

private final BaseService<Recipe> baseService;

    @GetMapping
    public String homePage(){
        return "home";
    }

    public RecipeControler(@Qualifier("recipeService") RecipeService baseService){
        this.baseService = baseService;
    }

    @GetMapping("/list") // listing of all
    public String goTolist(Model model){
        List<Recipe> recipes = baseService.getAll();
        model.addAttribute("recipes",recipes);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String goDetailPage(@PathVariable("id") Long id, Model model){
        Recipe recipe = baseService.getById(id);
        model.addAttribute("recipe",recipe);
        return "detail";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("recipe",new Recipe());
        return "form";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult){
        baseService.add(recipe);
        if(bindingResult.hasErrors()){
            return "form";
        }else {
            return "form-confirm";
        }
    }






}
