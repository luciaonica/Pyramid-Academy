package constructorsJavaSourceCode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        constructorsJavaSourceCode.Student obj = (constructorsJavaSourceCode.Student) context.getBean(Student.class);
        System.out.println(obj);
    }
}
