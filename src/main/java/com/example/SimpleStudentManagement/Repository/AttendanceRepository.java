package com.example.SimpleStudentManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleStudentManagement.Model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer>{
 List<Attendance> findByStudentId(Integer studentId);
}
