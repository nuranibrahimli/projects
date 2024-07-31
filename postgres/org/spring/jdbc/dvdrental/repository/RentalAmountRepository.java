package repository;

import entities.PaymentReport;
import entities.RentalAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RentalAmountRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createView(){
        String create_view = "CREATE VIEW rental_sum_amount AS\n" +
                "SELECT \n" +
                "    r.rental_id,\n" +
                "    SUM(p.amount) AS total_payment\n" +
                "FROM \n" +
                "    rental r\n" +
                "JOIN \n" +
                "    payment p ON r.rental_id = p.rental_id\n" +
                "GROUP BY \n" +
                "    r.rental_id\n" +
                "ORDER BY \n" +
                "    r.rental_id;";
        try {
            this.jdbcTemplate.update(create_view);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public List<RentalAmount> selectRentalAmounts(){
        String select = "select * from rental_sum_amount";
        return this.jdbcTemplate.query(select, rentalAmountRowMapper);
    }

    RowMapper<RentalAmount> rentalAmountRowMapper = new RowMapper<RentalAmount>() {
        @Override
        public RentalAmount
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            RentalAmount rentalAmount = new RentalAmount();
            rentalAmount.setRentalID(rs.getInt(1));
            rentalAmount.setAmount(rs.getDouble(2));
            return rentalAmount;
        }
    };
}
