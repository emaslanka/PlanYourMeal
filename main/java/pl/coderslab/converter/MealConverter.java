package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Meal;
import pl.coderslab.repository.MealRepository;

public class MealConverter implements Converter<String, Meal> {

    @Autowired
    private MealRepository mealRepository;

    @Override
    public Meal convert(String id) {
        return mealRepository.getOne(Long.parseLong(id));
    }
}
