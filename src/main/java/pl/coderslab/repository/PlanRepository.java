package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
