package services;

import entities.CategoryReport;
import entities.CustomerReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServices {
    @Autowired
    CategoryRepository repository;

    public void selectFilmCount(){
        List<CategoryReport> reports = repository.selectCategoryFilmCount();
        for (CategoryReport category: reports){
            System.out.println(category.toString());
        }
    }
}
