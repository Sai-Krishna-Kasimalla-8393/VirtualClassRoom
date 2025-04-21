package com.example.SimpleStudentManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student_Login {

    @Id
    
    private int StuId;

    public int getStuId() {
		return StuId;
	}

	public void setStuId(int stuId) {
		StuId = stuId;
	}

	private String email;
    private String password;

    // Getters and Setters
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
