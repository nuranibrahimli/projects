import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private static final Logger logger = LoggerFactory.getLogger(LanguageService.class);

    private final LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }


    public void insert(Language language) {
        repository.insert(language);
        logger.info("Inserted language: {}", language);
    }

    public Optional<Language> findById(Integer id) {
        logger.info("Finding language by id: {}", id);
        return repository.findById(id);
    }

    public List<Language> findAll() {
        logger.info("Finding all languages");
        return repository.findAll();
    }
}