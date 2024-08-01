package entities;

import base.BaseEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component
@ComponentScan("entities")
public class CategoryFilmRentalReport extends BaseEntity {
    private String categoryName;
    private String filmTitle;
    private double avgRentalDuration;

    // getter methods
    public String getCategoryName() {
        return categoryName;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public double getAvgRentalDuration() {
        return avgRentalDuration;
    }

    // setter methods
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public void setAvgRentalDuration(double avgRentalDuration) {
        this.avgRentalDuration = avgRentalDuration;
    }

    @Override
    public String toString() {
        return "CategoryFilmRentalReport{" +
                "categoryName='" + categoryName + '\'' +
                ", filmTitle='" + filmTitle + '\'' +
                ", avgRentalDuration=" + avgRentalDuration +
                '}';
    }
}
