
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FilmActorDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<FilmActor> filmActorRowMapper = (rs, rowNum) -> {
        FilmActor filmActor = new FilmActor();
        filmActor.setActorId(rs.getInt("actor_id"));
        filmActor.setFilmId(rs.getInt("film_id"));
        filmActor.setLastUpdate(rs.getTimestamp("last_update").toLocalDateTime());
        return filmActor;
    };

    public List<FilmActor> getFilmActorsByFilmId(int filmId) {
        return jdbcTemplate.query("SELECT * FROM film_actor WHERE film_id = ?",
                new Object[]{filmId}, filmActorRowMapper);
    }

    public List<FilmActor> getFilmActorsByActorId(int actorId) {
        return jdbcTemplate.query("SELECT * FROM film_actor WHERE actor_id = ?",
                new Object[]{actorId}, filmActorRowMapper);
    }

    public void insertFilmActor(FilmActor filmActor) {
        jdbcTemplate.update("INSERT INTO film_actor (actor_id, film_id, last_update) VALUES (?, ?, ?)",
                filmActor.getActorId(), filmActor.getFilmId(), filmActor.getLastUpdate());
    }

    public void deleteFilmActor(int actorId, int filmId) {
        jdbcTemplate.update("DELETE FROM film_actor WHERE actor_id = ? AND film_id = ?", actorId, filmId);
    }
}