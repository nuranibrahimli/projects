package services;

import entities.MostRentedMovies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MostRentedMoviesRepository;

import java.util.List;

@Service
public class MoviesServices {
    @Autowired
    MostRentedMoviesRepository repository;

    public void selectMovies(){
        List<MostRentedMovies> movies = repository.selectMostRentedMovies();
        for(MostRentedMovies movie: movies){
            System.out.println(movie.toString());
        }
    }

    public void selectMovies(int limit){
        List<MostRentedMovies> movies = repository.selectMostRentedMovies(limit);
        for(MostRentedMovies movie: movies){
            System.out.println(movie.toString());
        }
    }
}
