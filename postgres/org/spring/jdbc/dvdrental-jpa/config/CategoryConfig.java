package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.CategoryServices;

@Configuration
@ComponentScan(basePackages = {"repository", "services", "entities", "managers"})
public class CategoryConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CategoryConfig.class);
        CategoryServices services = context.getBean(CategoryServices.class);
    }
}
