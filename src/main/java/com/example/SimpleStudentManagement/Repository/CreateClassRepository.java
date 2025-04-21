package com.example.SimpleStudentManagement.Repository;

import com.example.SimpleStudentManagement.Model.CreateClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreateClassRepository extends JpaRepository<CreateClass, UUID> {
    // Additional query methods if needed
}
