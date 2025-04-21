package com.example.SimpleStudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleStudentManagement.Model.Courses;

public interface CourseRepository extends JpaRepository<Courses,Integer>{

}
