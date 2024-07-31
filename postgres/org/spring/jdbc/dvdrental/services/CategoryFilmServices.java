package services;

import entities.CategoryFilmRentalReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryFilmRepository;

import java.util.List;

@Service
public class CategoryFilmServices {
    @Autowired
    CategoryFilmRepository repository;

    public void selectCategoryFilm(){
        List<CategoryFilmRentalReport> reports = repository.selectAvgRentalDuration();
        for(CategoryFilmRentalReport film: reports){
            System.out.println(film.toString());
        }
    }
}
