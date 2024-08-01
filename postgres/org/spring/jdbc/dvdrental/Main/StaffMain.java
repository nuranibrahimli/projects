package Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.ProfileConfig;
import services.StoreStaffService;
import services.ActorServices;

public class StaffMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(ProfileConfig.class);
        context.refresh();

        StoreStaffService storeStaffService = context.getBean(StoreStaffService.class);
        System.out.println("\nStore staff counts:");
        storeStaffService.selectStoreWithStaffCount();

        context.close();
    }
}
