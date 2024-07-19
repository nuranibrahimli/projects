
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LanguageDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<Language> languageRowMapper = (rs, rowNum) -> {
        Language language = new Language();
        language.setLanguageId(rs.getInt("language_id"));
        language.setName(rs.getString("name"));
        language.setLastUpdate(rs.getTimestamp("last_update").toLocalDateTime());
        return language;
    };

    public List<Language> getAllLanguages() {
        return jdbcTemplate.query("SELECT * FROM language", languageRowMapper);
    }
}