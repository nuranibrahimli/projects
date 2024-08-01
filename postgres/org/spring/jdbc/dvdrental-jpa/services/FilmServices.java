package services;

import entities.FilmReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FilmRepository;

import java.util.List;

@Service
public class FilmServices {
    @Autowired
    FilmRepository repository;

    public void selectFilmWithRentalDuration(){
        List<FilmReport> reports = repository.selectFilmDuration();
        for(FilmReport film: reports){
            System.out.println(film.toString());
        }
    }

    public void selectMoviesNotRented(){
        List<FilmReport> reports = repository.selectMoviesNotRented();
        for(FilmReport film: reports){
            System.out.println(film.toString());
        }
    }
}
