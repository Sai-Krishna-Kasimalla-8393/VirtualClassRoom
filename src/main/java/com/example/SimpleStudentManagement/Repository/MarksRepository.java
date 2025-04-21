package com.example.SimpleStudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SimpleStudentManagement.Model.Marks;
import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Integer> {
    List<Marks> findByStudentId(Integer studentId);
}
