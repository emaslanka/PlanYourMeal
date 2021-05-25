package pl.coderslab.controllers;


import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    // ----Add meal ------------------------------------------------------------------
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

    //----List of meal ------------------------------------------------------------------------

    @GetMapping("/list")
    public String mealListForm (Model m){
        m.addAttribute("meal", new Meal());
        List<Meal> meals = mealRepository.findAll();
        m.addAttribute("meals", meals);
        return "list";
    }

    @PostMapping("/list")


    public String mealListPost (@ModelAttribute @Valid Meal meal , BindingResult violations, Model m ){

        if(violations.hasErrors()){
            return "list";
        }
        List<Meal> meals = mealRepository.findByCategoryAndTimeOfPrep(meal.getCategory(),meal.getTimeOfPrep());

        m.addAttribute("meals", meals);
        return "listResult";
    }
}
