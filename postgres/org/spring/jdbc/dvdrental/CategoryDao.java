import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoryDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<Category> categoryRowMapper = (rs, rowNum) -> {
        Category category = new Category();
        category.setCategoryId(rs.getInt("category_id"));
        category.setName(rs.getString("name"));
        category.setLastUpdate(rs.getTimestamp("last_update").toLocalDateTime());
        return category;
    };

    public List<Category> getAllCategories() {
        return jdbcTemplate.query("SELECT * FROM category", categoryRowMapper);
    }

    public Category getCategoryById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM category WHERE category_id = ?",
                new Object[]{id}, categoryRowMapper);
    }
}