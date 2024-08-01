package repository;

import entities.FilmReport;
import entities.StaffReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FilmRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createView(){
        String create_view = "" +
                "CREATE OR REPLACE VIEW movies_not_rented AS\n" +
                "SELECT f.film_id, f.title, f.length\n" +
                "FROM film f\n" +
                "LEFT JOIN rental r ON f.film_id = r.film_id\n" +
                "AND r.rental_date >= CURRENT_DATE - INTERVAL '1 month'\n" +
                "WHERE r.film_id IS NULL ORDER BY f.film_id;";
        try {
            this.jdbcTemplate.update(create_view);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public void createMostRentedView(){
        String create_view = "" +
                "CREATE VIEW most_rented_movies as\n" +
                "SELECT \n" +
                "    f.film_id, \n" +
                "    f.title, \n" +
                "    COUNT(r.film_id) AS rental_count\n" +
                "FROM \n" +
                "    film f\n" +
                "JOIN \n" +
                "    rental r ON f.film_id = r.film_id\n" +
                "GROUP BY \n" +
                "    f.film_id, f.title\n" +
                "ORDER BY \n" +
                "    rental_count DESC;";
        try {
            this.jdbcTemplate.update(create_view);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public List<FilmReport> selectFilmDuration(){
        String select = "select * from film_avg_date";
        return this.jdbcTemplate.query(select, filmReportMapper);
    }

    public List<FilmReport> selectMoviesNotRented(){
        String select = "select * from movies_not_rented";
        return this.jdbcTemplate.query(select, filmReportMapper);
    }

    RowMapper<FilmReport> filmReportMapper = new RowMapper<FilmReport>() {
        @Override
        public FilmReport
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            FilmReport filmReport = new FilmReport();
            filmReport.setFilm_id(rs.getInt(1));
            filmReport.setTitle(rs.getString(2));
            filmReport.setDuration(rs.getLong(3));
            return filmReport;
        }
    };
}
