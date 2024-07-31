package repository;

import entities.CustomerReport;
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
public class StaffRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createView(){
        String create_view = "" +
                "create view sum_staff_amount as\n" +
                "select p.staff_id, s.first_name || ' ' || s.last_name as full_name, sum(p.amount) \n" +
                "from staff s join payment p on s.staff_id=p.staff_id group by p.staff_id, s.first_name, s.last_name";
        try {
            this.jdbcTemplate.update(create_view);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public List<StaffReport> selectStaffAmountSum(){
        String select = "select * from sum_staff_amount";
        return this.jdbcTemplate.query(select, staffReportMapper);
    }

    RowMapper<StaffReport> staffReportMapper = new RowMapper<StaffReport>() {
        @Override
        public StaffReport
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            StaffReport staffReport = new StaffReport();
            staffReport.setStaff_id(rs.getInt(1));
            staffReport.setFull_name(rs.getString(2));
            staffReport.setAmount(rs.getDouble(3));
            return staffReport;
        }
    };
}
