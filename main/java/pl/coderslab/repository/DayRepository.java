package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Day;


public interface DayRepository extends JpaRepository<Day, Long> {
}
