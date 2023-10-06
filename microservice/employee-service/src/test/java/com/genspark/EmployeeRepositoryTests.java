package com.genspark;

import com.genspark.entity.Employee;
import com.genspark.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository repo;

    @Test
    public void testCreateEmployee(){
        Employee employee = new Employee();
        employee.setFullName("Victor Hugo");
        employee.setAddress("Les Contemplations");
        employee.setDepartmentId(1L);

        Employee savedEmployee = repo.save(employee);
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindByDepartmentId() {
        List<Employee> list = repo.findByDepartmentId(1l);
        System.out.println(list);
    }
}
