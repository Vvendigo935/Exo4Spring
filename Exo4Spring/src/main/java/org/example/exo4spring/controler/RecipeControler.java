package org.example.exo4spring.controler;

import jakarta.validation.Valid;
import jdk.jfr.Category;
import org.example.exo4spring.entity.Recipe;
import org.example.exo4spring.service.BaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecipeControler {

private final BaseService baseService;


    public RecipeControler(@Qualifier("recipeService") BaseService baseService){
        this.baseService = baseService;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("recipe",new Recipe());
        return "form";
    }

    @PostMapping("/form")
    public String add(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }else {
            return "form-confirm";
        }
    }




}
