package config;

import repository.ActorRepository;
import repository.StoreStaffRepository;
import services.ActorServices;
import services.LanguageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import services.StoreStaffService;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"services", "repository", "entities"})
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    @Profile("prod")
    public DataSource prodDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdrental");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public ActorRepository actorRepository(JdbcTemplate jdbcTemplate) {
        return new ActorRepository(jdbcTemplate);

    }

    @Bean
    public StoreStaffRepository storeStaffRepository(JdbcTemplate jdbcTemplate) {
        return new StoreStaffRepository(jdbcTemplate);
    }

    @Bean
    public StoreStaffService storeStaffService(StoreStaffRepository storeStaffRepository) {
        return new StoreStaffService(storeStaffRepository);
    }
//
//    @Bean
//    public ActorServices actorServices(ActorRepository actorRepository) {
//        return new ActorServices(actorRepository);
//    }
//
//    @Bean
//    public LanguageService languageService(JdbcTemplate jdbcTemplate) {
//        return new LanguageService(jdbcTemplate);
//    }
}