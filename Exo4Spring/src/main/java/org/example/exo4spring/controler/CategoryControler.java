package org.example.exo4spring.controler;

import jakarta.validation.Valid;
import org.example.exo4spring.entity.Category;
import org.example.exo4spring.entity.Recipe;
import org.example.exo4spring.service.BaseService;
import org.example.exo4spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryControler {

    private final CategoryService baseService;


    public CategoryControler(@Qualifier("categoryService") CategoryService baseService) {
        this.baseService = baseService;
    }



    @GetMapping("/formcat")
    public String form(Model model){
        model.addAttribute("category",new Category());
        return "formcat";
    }

    @PostMapping("/addCat")
    public String add(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult){
        baseService.add(category);
        if(bindingResult.hasErrors()){
            return "formcat";
        }else {
            return "form-confirm";
        }
    }

}
