package repository;

import entities.CategoryReport;
import entities.CustomerPaymentReport;
import entities.CustomerReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@ComponentScan("repository")
public class CustomerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createView(){
        String create_view = "" +
                "create view customer_rental_count as\n" +
                "select c.customer_id, c.first_name || ' ' || c.last_name as full_name, count(*) " +
                "as rent_count from rental r join customer c on r.customer_id = c.customer_id group by c.customer_id";
        try {
            this.jdbcTemplate.update(create_view);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public void createViewWithPayment(){
        String create_view = "create view customer_payment_amount as\n" +
                "select p.customer_id, c.first_name, c.last_name, sum(p.amount) from customer c join payment p \n" +
                "on c.customer_id = p.customer_id group by p.customer_id, c.first_name, c.last_name";
        try {
            this.jdbcTemplate.update(create_view);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public void createViewNonPayingCustomers(){
        String create_view = "CREATE VIEW customer_payment AS\n" +
                "SELECT c.customer_id, c.first_name\n" +
                "FROM customer c\n" +
                "LEFT JOIN payment p ON c.customer_id = p.customer_id\n" +
                "WHERE p.payment_id IS NULL;";
        try{
            this.jdbcTemplate.update(create_view);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public void createViewAvgPaymentCustomers(){
        String create_view = "CREATE VIEW payment_amount_customer AS\n" +
                "SELECT \n" +
                "    c.customer_id,\n" +
                "    c.first_name,\n" +
                "    AVG(p.amount) AS average_payment\n" +
                "FROM \n" +
                "    customer c\n" +
                "JOIN \n" +
                "    payment p ON c.customer_id = p.customer_id\n" +
                "GROUP BY \n" +
                "    c.customer_id, c.first_name\n" +
                "ORDER BY \n" +
                "    average_payment DESC";
        try {
            this.jdbcTemplate.update(create_view);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public List<CustomerReport> selectCustomerRentalCount(){
        String select = "select * from customer_rental_count";
        return this.jdbcTemplate.query(select, customerReportMapper);
    }

    public List<CustomerReport> selectCustomerWithPayment(){
        String select = "select * from customer_payment_amount";
        return this.jdbcTemplate.query(select, customerReportMapperWithPayment);
    }

    public List<CustomerReport> selectCustomerWithPayment(int limit){
        String select = "select * from customer_payment_amount limit "+limit;
        return this.jdbcTemplate.query(select, customerReportMapperWithPayment);
    }

    public List<CustomerPaymentReport> selectNonPayingCustomers(){
        String select = "select * from customer_payment";
        return this.jdbcTemplate.query(select, customerReportMapperWithNonPayingPayment);
    }

    public List<CustomerReport> selectAvgPaymentCustomers(){
        String select = "select * from payment_amount_customer";
        return this.jdbcTemplate.query(select, customerReportMapperWithPayment);
    }

    RowMapper<CustomerReport> customerReportMapper = new RowMapper<CustomerReport>() {
        @Override
        public CustomerReport
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomerReport customerReport = new CustomerReport();
            customerReport.setCustomerID(rs.getInt(1));
            customerReport.setFullName(rs.getString(2));
            customerReport.setRentalCount(rs.getInt(3));
            return customerReport;
        }
    };

    RowMapper<CustomerReport> customerReportMapperWithPayment = new RowMapper<CustomerReport>() {
        @Override
        public CustomerReport
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomerReport customerReport = new CustomerReport();
            customerReport.setCustomerID(rs.getInt(1));
            customerReport.setFullName(rs.getString(2));
            customerReport.setAmounts(rs.getDouble(3));
            return customerReport;
        }
    };

    RowMapper<CustomerPaymentReport> customerReportMapperWithNonPayingPayment = new RowMapper<CustomerPaymentReport>() {
        @Override
        public CustomerPaymentReport
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomerPaymentReport customerReport = new CustomerPaymentReport();
            customerReport.setCustomerID(rs.getInt(1));
            customerReport.setFirstName(rs.getString(2));
            return customerReport;
        }
    };
}
