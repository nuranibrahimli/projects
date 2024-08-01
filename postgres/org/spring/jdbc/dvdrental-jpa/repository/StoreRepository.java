package repository;

import entities.StoreReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StoreRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createView(){
        String createView = "CREATE VIEW total_store_revenue as\n" +
                "SELECT s.store_id,  COALESCE(SUM(p.amount), 0) AS total_revenue\n" +
                "FROM store s\n" +
                "LEFT JOIN payment p ON s.manager_staff_id = p.staff_id\n" +
                "GROUP BY s.store_id";
        try {
            this.jdbcTemplate.update(createView);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public List<StoreReport> selectStoreWithRevenue(){
        String select = "select * from total_store_revenue";
        return this.jdbcTemplate.query(select, storeReportMapper);
    }


    RowMapper<StoreReport> storeReportMapper = new RowMapper<StoreReport>() {
        @Override
        public StoreReport
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            StoreReport storeReport = new StoreReport();
            storeReport.setStoreID(rs.getInt(1));
            storeReport.setTotalRevenue(rs.getDouble(2));
            return storeReport;
        }
    };


}
