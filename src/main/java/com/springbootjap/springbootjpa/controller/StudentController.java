package com.springbootjap.springbootjpa.controller;

import com.springbootjap.springbootjpa.model.Student;
import com.springbootjap.springbootjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAll() {
        return this.studentService.getAll();
    }

    @GetMapping("/student")
    public Student getOne(@PathVariable("id") Integer id) {
        return this.studentService.getOne(id);
    }

    @PostMapping("/student")
    public Student add(@RequestBody Student student) {
        return this.studentService.add(student);
    }

    @PutMapping("/student")
    public Student update(@RequestBody Student student) {
        return this.studentService.update(student);
    }

    @DeleteMapping("/student/{id}")
    public Student delete(@PathVariable("id") Integer id) {
        return this.studentService.delete(id);
    }
}
