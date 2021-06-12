package pl.coderslab.controllers;


import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Day;
import pl.coderslab.entity.Meal;
import pl.coderslab.entity.Plan;
import pl.coderslab.repository.DayRepository;
import pl.coderslab.repository.MealRepository;
import pl.coderslab.repository.PlanRepository;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
@RequestMapping("/plan")
public class PlanController {

    private MealRepository mealRepository;
    private PlanRepository planRepository;
    private DayRepository dayRepository;

    public PlanController(MealRepository mealRepository, PlanRepository planRepository, DayRepository dayRepository) {
        this.mealRepository = mealRepository;
        this.planRepository = planRepository;
        this.dayRepository = dayRepository;
    }

    // ----Add plan ------------------------------------------------------------------
    @GetMapping(value = "/add")
    public String add(Model m) {
        m.addAttribute("plan", new Plan());
        return "addplan";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute @Valid Plan plan, BindingResult violations,Model m) {

        if(violations.hasErrors()){
            m.addAttribute("plan", new Plan());
            return "addplan";
        }

        planRepository.save(plan);
        return "index";
    }

    @ModelAttribute("meals")
    public List<Meal> meals() {
        return mealRepository.findAll();
    }

    @ModelAttribute("days")
    public List<Day> days() {
        return dayRepository.findAll();
    }


    //--------------Display list---------------------------------------
    @GetMapping("/list")
    public String planList() {
        return "planlistform";
    }

    @PostMapping("/list")
    @Transactional
    public String planList(HttpServletRequest request, Model m) {
        LocalDate date_1 = LocalDate.parse(request.getParameter("date1"));
        LocalDate date_2 = LocalDate.parse(request.getParameter("date2"));

        List<Plan> plans = planRepository.findBetweenDates(date_1, date_2);

        for (Plan p : plans
        ) {
            Hibernate.initialize(p.getDay());
            Hibernate.initialize(p.getMeals());
        }
        m.addAttribute("plans", plans);

        return "planListResult";
    }

    //---------------------------------Edit------------------------------------------------------------------

    @GetMapping("/edit/{id}")
    @Transactional
    public String editPlan(Model m, @PathVariable long id) {
        Plan plan = planRepository.getOne(id);
        Hibernate.initialize(plan.getMeals());
        m.addAttribute("plan", plan);
        return "editplan";
    }

    @PostMapping("/edit/{id}")
    @Transactional
    public String editPlanPost(@ModelAttribute Plan plan, @PathVariable long id) {
        planRepository.save(plan);
        return "list";
    }

    //---------------------------delete--------------------------------------------------------------------------

    @GetMapping("/delete/{id}")
    @Transactional
    public String deletePlan(Model m, @PathVariable long id) {
        Plan plan = planRepository.getOne(id);
        Hibernate.initialize(plan.getMeals());
        planRepository.delete(plan);

        return "index";
    }


}
