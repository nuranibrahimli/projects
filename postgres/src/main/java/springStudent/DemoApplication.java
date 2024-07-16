package springStudent;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
// Main class
public class DemoApplication
{
    // Main driver method
    public static void main(String[] args)
    {
        // Creating object in a spring container (Beans)
//        BeanFactory factory = new ClassPathXmlApplicationContext("bean-factory-demo.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factory-demo.xml");
        Student student = (Student) context.getBean("student");

        System.out.println(student);
    }
}

