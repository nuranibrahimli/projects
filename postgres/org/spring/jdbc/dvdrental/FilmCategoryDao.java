
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FilmCategoryDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<FilmCategory> filmCategoryRowMapper = (rs, rowNum) -> {
        FilmCategory filmCategory = new FilmCategory();
        filmCategory.setFilmId(rs.getInt("film_id"));
        filmCategory.setCategoryId(rs.getInt("category_id"));
        filmCategory.setLastUpdate(rs.getTimestamp("last_update").toLocalDateTime());
        return filmCategory;
    };

    public List<FilmCategory> getFilmCategoriesByFilmId(int filmId) {
        return jdbcTemplate.query("SELECT * FROM film_category WHERE film_id = ?",
                new Object[]{filmId}, filmCategoryRowMapper);
    }
}