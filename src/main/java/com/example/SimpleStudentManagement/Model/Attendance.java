package com.example.SimpleStudentManagement.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer studentId;
    private String name;

    private LocalDate date;
    private String status;  // Alternatively, use an Enum
    private String remarks;
    private String subject;

    // Getters and Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
}
