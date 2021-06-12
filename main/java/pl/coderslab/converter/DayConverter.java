package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Day;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.DayRepository;

public class DayConverter implements Converter<String, Day> {

    @Autowired
    private DayRepository dayRepository;

    @Override
    public Day convert(String id) {
        return dayRepository.getOne(Long.parseLong(id));
    }
}
