package repository;

import entities.MostRentedMovies;
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
public class MostRentedMoviesRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createView(){
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

    public List<MostRentedMovies> selectMostRentedMovies(){
        String select = "select * from most_rented_movies";
        return this.jdbcTemplate.query(select, moviesReportMapper);
    }

    public List<MostRentedMovies> selectMostRentedMovies(int limit){
        String select = "select * from most_rented_movies limit "+limit;
        return this.jdbcTemplate.query(select, moviesReportMapper);
    }




    RowMapper<MostRentedMovies> moviesReportMapper = new RowMapper<MostRentedMovies>() {
        @Override
        public MostRentedMovies
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            MostRentedMovies movies = new MostRentedMovies();
            movies.setFilmID(rs.getInt(1));
            movies.setTitle(rs.getString(2));
            movies.setRentalCount(rs.getInt(3));
            return movies;
        }
    };
}
