package com.gdu_crud_demo.crud_demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gdu_crud_demo.crud_demo.DAO.StudentDAO;
import com.gdu_crud_demo.crud_demo.entity.Student;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO s) {
        return a -> {
//            findStudent(s);
           showAllStudent(s);
//            CreateStudent(s);
//                updateStudent(s);
            // deleteAllStudent(s);
        };
    }

    public void CreateStudent(StudentDAO studentDAO) {
        String firstName = "Nguyen2";
        String lastName = "Thanh3";
        String email = "K6mQ1@example.com";
        Student student = new Student(firstName, lastName, email);
        studentDAO.insert(student);
    }

    public void findStudent(StudentDAO studentDAO) {
        int id = 1;
        Student student = studentDAO.selectOne(id);
        System.out.println("Found Student: " + student);
    }

    public void showAllStudent(StudentDAO studentDAO) {
        List<Student> students = studentDAO.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void deleteAllStudent(StudentDAO studentDAO) {
        studentDAO.deleteAll();
    }

    public List<Student> findByFirstname(StudentDAO studentDAO) {
        String name = "Nguyen2";
        List<Student> students = studentDAO.findByName(name);
        return students;
    }
    public void updateStudent(StudentDAO studentDAO) {
        int id = 1;
        Student student = studentDAO.selectOne(id);
        student.setFirstname("Nguyenupdated");
        student.setLastname("Thanhupdated");
        student.setEmail("K6mQ1@example.com");
        studentDAO.update(student);
    }
    public void removeAllStudent(StudentDAO studentDAO) {
        studentDAO.deleteAll();
    }
}
