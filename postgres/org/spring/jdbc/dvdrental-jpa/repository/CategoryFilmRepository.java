package repository;

import entities.CategoryFilmRentalReport;
import entities.FilmReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryFilmRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<CategoryFilmRentalReport> selectAvgRentalDuration(){
        String select = "select * from average_rental_duration";
        return this.jdbcTemplate.query(select, categoryFilmReportMapper);
    }

    RowMapper<CategoryFilmRentalReport> categoryFilmReportMapper = new RowMapper<CategoryFilmRentalReport>() {
        @Override
        public CategoryFilmRentalReport
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            CategoryFilmRentalReport categoryFilm = new CategoryFilmRentalReport();
            categoryFilm.setCategoryName(rs.getString(1));
            categoryFilm.setFilmTitle(rs.getString(2));
            categoryFilm.setAvgRentalDuration(rs.getDouble(3));
            return categoryFilm;
        }
    };
}
