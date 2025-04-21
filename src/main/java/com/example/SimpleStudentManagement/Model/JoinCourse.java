
package com.example.SimpleStudentManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JoinCourse {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private int studentid;
private String StudentName;
private String studentemail;
private String coursename;
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStudentName() {
	return StudentName;
}
public void setStudentName(String studentName) {
	StudentName = studentName;
}
public String getStudentemail() {
	return studentemail;
}
public void setStudentemail(String studentemail) {
	this.studentemail = studentemail;
}

public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}




}
