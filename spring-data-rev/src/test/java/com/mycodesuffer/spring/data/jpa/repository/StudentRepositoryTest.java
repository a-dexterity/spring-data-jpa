package com.mycodesuffer.spring.data.jpa.repository;

import com.mycodesuffer.spring.data.jpa.entity.Guardian;
import com.mycodesuffer.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Guardian guard = Guardian.builder()
                .name("acd")
                .email("acdk@gmail.com")
                .phoneNo("9955778844")
                .build();


        Student student = Student.builder()
                .emailId("abc@gmail.com")
                .firstName("abc")
                .lastName("def")
                .guardian(guard)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

}