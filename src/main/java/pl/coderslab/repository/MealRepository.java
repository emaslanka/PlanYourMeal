package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Meal;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    // find meal by category and max time

   @Query("select m from Meal m where m.category = ?1 and m.timeOfPrep < ?1")
    List<Meal> findByCategoryAndTimeOfPrep(Category category, int timeOfPrep);

}
