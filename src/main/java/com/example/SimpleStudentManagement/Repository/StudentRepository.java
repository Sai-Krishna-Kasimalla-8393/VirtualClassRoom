package com.example.SimpleStudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleStudentManagement.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
