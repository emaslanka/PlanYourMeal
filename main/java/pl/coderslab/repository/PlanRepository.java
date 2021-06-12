package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Plan;
import java.time.LocalDate;
import java.util.List;


public interface PlanRepository extends JpaRepository<Plan, Long> {


    // find Plans between two specific dates

    @Query("select p from Plan p where p.date between ?1 and ?2")
    List<Plan> findBetweenDates(LocalDate date1, LocalDate date2);
}
