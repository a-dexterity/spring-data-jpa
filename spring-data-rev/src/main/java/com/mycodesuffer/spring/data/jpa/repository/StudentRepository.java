package com.mycodesuffer.spring.data.jpa.repository;

import com.mycodesuffer.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByLastName(String lastName);

    public List<Student> findByEmailId(String emailId);

    public List<Student> findByStudentId(Long studentId);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameIsNotNullAndFirstNameNotNull(String firstName, String lastName);

    //JQPL
    @Query( "Select s from Student s where s.firstName = ?1")
    public Student findByStudentNameJPQL(String name);

    //Native Query
    @Query(
            value = "SELECT * FROM tbl_student s where s.first_name = ?1",
            nativeQuery = true
    )
    public Student findByStudentNameNative(String name);

}
