package repository;

import entities.CategoryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@ComponentScan("repository")
public class CategoryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createView(){
        String createView = "" +
                "create view category_film_count as\n" +
                "select c.category_id, c.name, count(*)  from category c join film_category fc on " +
                "c.category_id = fc.category_id group by c.category_id order by c.category_id";
        try {
            this.jdbcTemplate.update(createView);
        }catch (DataIntegrityViolationException e){
            System.out.println("error: "+e.getMessage());
        }
    }

    public List<CategoryReport> selectCategoryFilmCount(){
        String select = "select * from category_film_count";
        return this.jdbcTemplate.query(select, categoryReportMapper);
    }

    RowMapper<CategoryReport> categoryReportMapper = new RowMapper<CategoryReport>() {
        @Override
        public CategoryReport
        mapRow(ResultSet rs, int rowNum) throws SQLException {
            CategoryReport categoryReport = new CategoryReport();
            categoryReport.setCategoryID(rs.getInt(1));
            categoryReport.setName(rs.getString(2));
            categoryReport.setFilmCount(rs.getInt(3));
            return categoryReport;
        }
    };

}
