package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Meal;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    // find meal by category and max time - those 2 values are required

    @Query("select m from Meal m where m.category = ?1 and m.timeOfPrep <= ?2")
    List<Meal> findByCategoryAndTimeOfPrep(Category category, int timeOfPrep);

}
