package repository;

import entities.ActiveRentals;
import entities.ActorReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ActiveRentalsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ActiveRentals> selectActiveRentalsCount(){
        String select = "select * from active_rentals_count";
        return this.jdbcTemplate.query(select, activeRentalsRowMapper);
    }

    public ActiveRentals activeRentals(){
        String select = "select * from active_rentals_count";
        return this.jdbcTemplate.queryForObject(select, activeRentalsRowMapper);
    }

    RowMapper<ActiveRentals> activeRentalsRowMapper = new RowMapper<ActiveRentals>() {
        @Override
        public ActiveRentals
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            ActiveRentals activeRentals = new ActiveRentals();
            activeRentals.setActiveRentalCount(rs.getInt(1));
            return activeRentals;
        }
    };

}
