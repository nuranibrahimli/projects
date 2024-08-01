package repository;

import entities.CustomerReport;
import entities.PaymentReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PaymentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createView(){
        String createView = "" +
                "CREATE VIEW rental_list_for_month as\n" +
                "SELECT \n" +
                "    DATE_TRUNC('month', rental_date) AS rental_month,\n" +
                "    COUNT(*) AS rental_count\n" +
                "FROM rental\n" +
                "GROUP BY rental_month\n" +
                "ORDER BY rental_month;";
        try {
            this.jdbcTemplate.update(createView);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public List<PaymentReport> selectPaymentForMonthCount(){
        String select = "select * from rental_list_for_month";
        return this.jdbcTemplate.query(select, paymentReportMapper);
    }

    RowMapper<PaymentReport> paymentReportMapper = new RowMapper<PaymentReport>() {
        @Override
        public PaymentReport
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            PaymentReport paymentReport = new PaymentReport();
            paymentReport.setRentalMonth(rs.getString(1));
            paymentReport.setRentalCount(rs.getInt(2));
            return paymentReport;
        }
    };


}
