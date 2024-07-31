package entities;

import base.BaseEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("entities")
public class FilmReport extends BaseEntity {
    private int film_id;
    private String title;
    private long duration;

    // getter methods
    public int getFilm_id() {
        return film_id;
    }

    public String getTitle() {
        return title;
    }

    public long getDuration() {
        return duration;
    }

    // setter methods
    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "FilmReport{" +
                "film_id=" + film_id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
