package com.example.SimpleStudentManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleStudentManagement.Model.Student_Signup;

public interface Student_Signup_Repository extends JpaRepository<Student_Signup,Integer>{

	Student_Signup findByEmailAndPassword(String email, String password);
	
	List<Student_Signup> findBystudentId(int stuId);


}
