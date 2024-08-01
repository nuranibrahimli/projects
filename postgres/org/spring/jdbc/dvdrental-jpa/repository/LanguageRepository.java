package repository;

import entities.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class LanguageRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LanguageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Language language) {
        String sql = "INSERT INTO language (name) VALUES (?)";
        jdbcTemplate.update(sql, language.getName());
    }

    public Optional<Language> findById(Integer id) {
        String sql = "SELECT language_id, name FROM language WHERE language_id = ?";
        try {
            Language language = jdbcTemplate.queryForObject(sql, new Object[]{id}, new LanguageRowMapper());
            return Optional.ofNullable(language);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Language> findAll() {
        String sql = "SELECT language_id, name FROM language";
        return jdbcTemplate.query(sql, new LanguageRowMapper());
    }

    private static class LanguageRowMapper implements RowMapper<Language> {
        @Override
        public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
            Language language = new Language();
            language.setId(rs.getInt("language_id"));
            language.setName(rs.getString("name"));
            return language;
        }
    }
}