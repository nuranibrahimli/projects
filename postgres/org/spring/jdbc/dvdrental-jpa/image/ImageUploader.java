package image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ImageUploader {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ImageUploader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void uploadImage(String filePath, String username) throws IOException {
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileData = new byte[(int) file.length()];
            fis.read(fileData);

            String sql = "UPDATE staff SET picture = ? WHERE username = ?";
            jdbcTemplate.update(sql, fileData, username);
        }
    }
}