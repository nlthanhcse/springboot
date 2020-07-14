package com.springbootjap.springbootjpa;

import com.springbootjap.springbootjpa.model.Student;
import com.springbootjap.springbootjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SpringbootjpaApplication implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootjpaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        getStudentsByNameLike();
//        getStudentsByNameLikeAndAgeGreaterThan();
        getStudentByName();
    }

    private void getStudentByName() {
        System.out.println(this.studentService.getStudentByNameIgnoreCase("nguyễn Văn Lâm"));
    }

    private void getStudentsByNameLike() {
        List<Student> students = this.studentService. getStudentsByNameLike("%a%");
        students.forEach(System.out::println);
    }

    private void getStudentsByNameLikeAndAgeGreaterThan() {
        List<Student> students = this.studentService. getStudentsByNameLikeAndAgeGreaterThan("%a%", 25);
        students.forEach(System.out::println);
    }
}
