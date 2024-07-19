
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class FilmDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<Film> filmRowMapper = (rs, rowNum) -> {
        Film film = new Film();
        film.setFilmId(rs.getInt("film_id"));
        film.setTitle(rs.getString("title"));
        film.setDescription(rs.getString("description"));
        film.setReleaseYear(rs.getInt("release_year"));
        film.setLanguageId(rs.getInt("language_id"));
        film.setRentalDuration(rs.getInt("rental_duration"));
        film.setRentalRate(rs.getBigDecimal("rental_rate"));
        film.setLength(rs.getInt("length"));
        film.setReplacementCost(rs.getBigDecimal("replacement_cost"));
        film.setRating(rs.getString("rating"));
        film.setLastUpdate(rs.getTimestamp("last_update").toLocalDateTime());
        film.setSpecialFeatures(rs.getString("special_features"));
        film.setFulltext(rs.getString("fulltext"));
        return film;
    };

    public Film getFilmById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM film WHERE film_id = ?",
                new Object[]{id}, filmRowMapper);
    }
}