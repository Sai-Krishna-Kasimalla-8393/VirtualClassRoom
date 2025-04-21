package com.example.SimpleStudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleStudentManagement.Model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer>{
	

}
