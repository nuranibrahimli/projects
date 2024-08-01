package repository;

import entities.StoreStaffReport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StoreStaffRepository {
    private final JdbcTemplate jdbcTemplate;

    public StoreStaffRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<StoreStaffReport> getStaffCountByStore() {
        String sql = "SELECT store.store_id, COUNT(staff.staff_id) as staff_count " +
                "FROM store " +
                "LEFT JOIN staff ON store.store_id = staff.store_id " +
                "GROUP BY store.store_id " +
                "ORDER BY store.store_id";

        return this.jdbcTemplate.query(sql, storeStaffReportMapper);
    }

    private final RowMapper<StoreStaffReport> storeStaffReportMapper = (rs, rowNum) -> {
        StoreStaffReport report = new StoreStaffReport();
        report.setStoreId(rs.getInt("store_id"));
        report.setStaffCount(rs.getInt("staff_count"));
        return report;
    };
}