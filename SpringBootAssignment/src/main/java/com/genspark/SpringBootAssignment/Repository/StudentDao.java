package com.genspark.SpringBootAssignment.Repository;

import com.genspark.SpringBootAssignment.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

    @Query(value = "Select * from students where address like %?1%", nativeQuery = true)
    List<Student> findStudentsByAddress(String address);

    @Query(value = "Select * from students where course like %?1%", nativeQuery = true)
    List<Student> findStudentsByCourse(String course);

    @Query(value = "Select * from students where name like %?1%", nativeQuery = true)
    List<Student> findStudentsByName(String name);
}
