package image;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ImageUploader uploader = context.getBean(ImageUploader.class);

        try {
            uploader.uploadImage("/home/nuran/Pictures/Screenshots/Ke.png", "my.png");
            System.out.println("Şəkil uğurla yükləndi.");
        } catch (IOException e) {
            System.err.println("Xəta baş verdi: " + e.getMessage());
            e.printStackTrace();
        }

        context.close();
    }
}
