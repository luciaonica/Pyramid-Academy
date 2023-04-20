package com.genspark.StudentManagementSystem.repository;

import com.genspark.StudentManagementSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT c.* FROM course c INNER JOIN student_course sc ON c.course_id = sc.course_id WHERE sc.user_id = :userId", nativeQuery = true)
    List<Course> findByUserId(@Param("userId") int userId);


}
