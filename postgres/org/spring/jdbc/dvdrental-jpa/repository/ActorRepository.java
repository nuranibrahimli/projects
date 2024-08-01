package repository;

import entities.ActorReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ActorRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public ActorRepository(JdbcTemplate jdbcTemplate) {
    }

    public void createView(){
        String create_view = "CREATE VIEW actor_film_count AS\n" +
                "SELECT a.actor_id, a.first_name, COUNT(fa.film_id) AS film_count\n" +
                "FROM actor a\n" +
                "JOIN film_actor fa ON a.actor_id = fa.actor_id\n" +
                "GROUP BY a.actor_id, a.first_name;";
        try {
            this.jdbcTemplate.update(create_view);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public List<ActorReport> selectActor(){
        String select = "select * from actor_film_count";
        return this.jdbcTemplate.query(select, actorReportMapper);
    }

    RowMapper<ActorReport> actorReportMapper = new RowMapper<ActorReport>() {
        @Override
        public ActorReport
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            ActorReport actorReport = new ActorReport();
            actorReport.setActorID(rs.getInt(1));
            actorReport.setFirstName(rs.getString(2));
            actorReport.setFilmCount(rs.getInt(3));
            return actorReport;
        }
    };

}
