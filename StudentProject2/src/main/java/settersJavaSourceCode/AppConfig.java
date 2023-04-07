package settersJavaSourceCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Autowired
    private Address address;
    @Bean
    public Student student(){
        Student student = new Student();
        student.setAdd(address);
        student.setId(12);
        student.setName("lucia");
        student.setPh(List.of( phone2(), phone1()));
        return student;
    }

    @Bean
    public Phone phone1(){
        Phone phone1 = new Phone();
        phone1.setMob("123456");
        return phone1;
    }

    @Bean
    public Phone phone2(){
        Phone phone = new Phone();
        phone.setMob("654321");
        return phone;
    }

    @Bean
    public Address address(){
        Address add = new Address();
        add.setCity("Westmont");
        add.setCountry("USA");
        add.setState("IL");
        add.setZipCode("60559");
        return add;
    }
}
