package pl.coderslab.controllers;


import org.hibernate.Hibernate;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Meal;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.MealRepository;

import javax.transaction.Transactional;
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
    @Transactional
    public String add(Model m) {
        m.addAttribute("meal", new Meal());
        return "addmeal";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public String addPost(@ModelAttribute @Valid Meal meal, BindingResult violations, Model m) {
        if (violations.hasErrors()) {
            return "addmealerror";
        }
        mealRepository.save(meal);
        return "redirect:./list";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    //----List of meal ------------------------------------------------------------------------

    @GetMapping("/list")
    public String mealListForm(Model m) {
        m.addAttribute("meal", new Meal());
        List<Meal> meals = mealRepository.findAll();
        m.addAttribute("meals", meals);
        return "list";
    }

    @PostMapping("/list")
    public String mealListPost(@ModelAttribute @Valid Meal meal, BindingResult violations, Model m) {

        if (violations.hasErrors()) {
            return "list";
        }
        List<Meal> meals = mealRepository.findByCategoryAndTimeOfPrep(meal.getCategory(), meal.getTimeOfPrep());

        m.addAttribute("meals", meals);
        return "listResult";
    }


    //---------------------------------Edit------------------------------------------------------------------

    @GetMapping("/edit/{id}")
    @Transactional
    public String editMeal(Model m, @PathVariable long id) {
        Meal meal = mealRepository.getOne(id);
        Hibernate.initialize(meal.getCategory());
        m.addAttribute("meal", meal);
        return "editMeal";
    }

    @PostMapping("/edit/{id}")
    @Transactional
    public String editMealPost(@ModelAttribute Meal meal, @PathVariable long id) {
        mealRepository.save(meal);
        return "redirect:../list";
    }

    //---------------------------delete--------------------------------------------------------------------------

    @GetMapping("/delete/{id}")
    @Transactional
    public String deleteMeal(Model m, @PathVariable long id) {
        Meal meal = mealRepository.getOne(id);
        Hibernate.initialize(meal.getCategory());
        mealRepository.delete(meal);
        return "redirect:../list";
    }


}
