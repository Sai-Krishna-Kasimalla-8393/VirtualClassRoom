package com.example.SimpleStudentManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleStudentManagement.Model.JoinCourse;

public interface JoinCourseRepository extends JpaRepository<JoinCourse,Integer>{

	
	    List<JoinCourse> findByStudentid(Integer studentid);
	}

	


