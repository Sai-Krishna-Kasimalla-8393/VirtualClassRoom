package com.example.SimpleStudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleStudentManagement.Model.Staff_Signup;

public interface Staff_Signup_Repository extends JpaRepository<Staff_Signup,Integer>{

	
	Staff_Signup findByEmailAndPassword(String email, String password);

}
