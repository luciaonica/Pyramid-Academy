package settersJavaSourceCode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Student getStudent(){
        return new Student();
    }

    @Bean
    public Address getAddress(){
        return new Address();
    }

    @Bean
    public Phone getPhone(){
        return new Phone();
    }
}
