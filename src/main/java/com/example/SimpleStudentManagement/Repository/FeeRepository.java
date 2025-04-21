package com.example.SimpleStudentManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleStudentManagement.Model.Fee;

public interface FeeRepository extends JpaRepository<Fee,Integer>{
	List<Fee> findByStudentId(Integer studentId);
}
