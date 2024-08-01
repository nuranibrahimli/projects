package entities;

import base.BaseEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("entities")
public class MostRentedMovies extends BaseEntity {
    private int filmID;
    private String title;
    private int rentalCount;

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRentalCount() {
        return rentalCount;
    }

    public void setRentalCount(int rentalCount) {
        this.rentalCount = rentalCount;
    }

    @Override
    public String toString() {
        return "MostRentedMovies{" +
                "filmID=" + filmID +
                ", title='" + title + '\'' +
                ", rentalCount=" + rentalCount +
                '}';
    }
}
