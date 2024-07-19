import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
//        Category category = new Category();
//        category.setCategoryId(1);
//        category.setName("Action");
//        category.setLastUpdate(LocalDateTime.now());
//
//        System.out.println("Category ID: " + category.getCategoryId());
//        System.out.println("Category Name: " + category.getName());
//        System.out.println("Last Update: " + category.getLastUpdate());
//
//        FilmCategory filmCategory = new FilmCategory();
//        filmCategory.setFilmId(1);
//        filmCategory.setCategoryId(1);
//        filmCategory.setLastUpdate(LocalDateTime.now());
//
//        System.out.println("Film ID: " + filmCategory.getFilmId());
//        System.out.println("Category ID: " + filmCategory.getCategoryId());
//        System.out.println("Last Update: " + filmCategory.getLastUpdate());

//        Film film = new Film();
//        film.setFilmId(1);
//        film.setTitle("Sample Film");
//        film.setDescription("A sample film description");
//        film.setReleaseYear(2023);
//        film.setLanguageId(1);
//        film.setRentalDuration(3);
//        film.setRentalRate(new BigDecimal("4.99"));
//        film.setLength(120);
//        film.setReplacementCost(new BigDecimal("19.99"));
//        film.setRating("PG-13");
//        film.setLastUpdate(LocalDateTime.now());
//        film.setSpecialFeatures("Trailers,Commentaries");
//        film.setFulltext("Sample fulltext");
//
//        System.out.println("Film ID: " + film.getFilmId());
//        System.out.println("Title: " + film.getTitle());
//        System.out.println("Release Year: " + film.getReleaseYear());
//        System.out.println("Rental Rate: " + film.getRentalRate());

//        Language language = new Language();
//        language.setLanguageId(1);
//        language.setName("English");
//        language.setLastUpdate(LocalDateTime.now());
//
//        System.out.println("Language ID: " + language.getLanguageId());
//        System.out.println("Language Name: " + language.getName());
//        System.out.println("Last Update: " + language.getLastUpdate());

        FilmActor filmActor = new FilmActor();
        filmActor.setActorId(1);
        filmActor.setFilmId(1);
        filmActor.setLastUpdate(LocalDateTime.now());

        System.out.println("Actor ID: " + filmActor.getActorId());
        System.out.println("Film ID: " + filmActor.getFilmId());
        System.out.println("Last Update: " + filmActor.getLastUpdate());
    }
}
