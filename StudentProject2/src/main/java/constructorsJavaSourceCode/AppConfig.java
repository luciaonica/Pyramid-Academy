package constructorsJavaSourceCode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public constructorsJavaSourceCode.Student getStudent(){
        return new Student(12, "Lucia", List.of(getPhone1(), getPhone()), getAddress());

    }

    @Bean
    public constructorsJavaSourceCode.Address getAddress(){
        return new Address("Westmont","IL","USA", "60559");
    }

    @Bean
    public constructorsJavaSourceCode.Phone getPhone(){
        return new Phone("123456");
    }

    @Bean
    public constructorsJavaSourceCode.Phone getPhone1(){
        return new Phone("987654");
    }

}