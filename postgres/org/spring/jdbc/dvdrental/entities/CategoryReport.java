package entities;

import base.BaseEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("enities")
public class CategoryReport extends BaseEntity {
    private int categoryID;
    private String name;
    private int filmCount;

    // getter methods
    public int getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public int getFilmCount() {
        return filmCount;
    }

    // setter methods
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFilmCount(int filmCount) {
        this.filmCount = filmCount;
    }

    @Override
    public String toString() {
        return "CategoryReport{" +
                "category id=" + categoryID +
                ", name='" + name + '\'' +
                ", filmCount=" + filmCount +
                '}';
    }
}
