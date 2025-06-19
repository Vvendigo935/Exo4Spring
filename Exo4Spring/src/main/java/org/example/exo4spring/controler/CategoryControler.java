package org.example.exo4spring.controler;

import org.example.exo4spring.service.BaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryControler {

    private final BaseService baseService;


    public CategoryControler(@Qualifier("categoryService") BaseService baseService) {
        this.baseService = baseService;
    }



}
