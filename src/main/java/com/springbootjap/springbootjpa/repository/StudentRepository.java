package com.springbootjap.springbootjpa.repository;

import com.springbootjap.springbootjpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameLike(String s);
    List<Student> findByAgeGreaterThanAndNameLike(Integer age, String s);
    Student findByNameIgnoreCase(String s);
}
