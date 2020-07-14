package com.springbootjap.springbootjpa.service;

import com.springbootjap.springbootjpa.model.Student;
import com.springbootjap.springbootjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return this.studentRepository.findAll();
    }

    public Student getOne(Integer id) {
        return this.studentRepository.findById(id).get();
    }

    public Student add(Student student) {
        return this.studentRepository.save(student);
    }

    public Student update(Student student) {
        return this.studentRepository.save(student);
    }

    public Student delete(Integer id) {
        Student deletedStudent = this.studentRepository.findById(id).get();
        this.studentRepository.deleteById(id);
        return deletedStudent;
    }

    public List<Student> getStudentsByNameLike(String s) {
        return this.studentRepository.findByNameLike(s);
    }

    public List<Student> getStudentsByNameLikeAndAgeGreaterThan(String s, Integer a) {
        return this.studentRepository.findByAgeGreaterThanAndNameLike(a, s);
    }

    public Student getStudentByNameIgnoreCase(String s) {
        return this.studentRepository.findByNameIgnoreCase(s);
    }
}
