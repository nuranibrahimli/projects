import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class TestProfile {
    private static final Logger logger = LoggerFactory.getLogger(TestProfile.class);

    public static void main(String[] args) {
        logger.info("Starting the application");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("prod"); // Set active profile
        logger.info("Set active profile {}", environment.getActiveProfiles()[0]);

        context.register(ProfileConfig.class);
        context.scan("org.spring.jdbc.dvdrental");
        context.refresh();

        LanguageService service = context.getBean(LanguageService.class);


        Language language = new Language();
        language.setName("English");

        service.insert(language);
        logger.info("Inserted language: {}", language.getName());

        Language retrievedLanguage = service.findById(1).orElse(null);
        logger.info("Retrieved language: {}", retrievedLanguage);

        logger.info("All languages:");
        service.findAll().forEach(lang -> logger.info(lang.toString()));

        context.close();
        logger.info("Application finished");
    }
}