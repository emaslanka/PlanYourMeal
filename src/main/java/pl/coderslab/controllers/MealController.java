package pl.coderslab.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Meal;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.MealRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/meal")
public class MealController {

    private MealRepository mealRepository;
    private CategoryRepository categoryRepository;

    public MealController(MealRepository mealRepository, CategoryRepository categoryRepository) {
        this.mealRepository = mealRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/add")
    public String add(Model m){
        m.addAttribute("meal", new Meal());
        return "addmeal";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute @Valid Meal meal, BindingResult violations){
        if(violations.hasErrors()){
            return "addmeal";
        }
        mealRepository.save(meal);
        return "index";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }
}
