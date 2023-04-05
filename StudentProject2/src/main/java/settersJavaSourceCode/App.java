package settersJavaSourceCode;
;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student obj =  context.getBean(Student.class);
        System.out.println(obj);
    }
}
