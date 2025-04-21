package com.example.SimpleStudentManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marks {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private Integer studentId;
private String Name;
private String  department;
private int CoreJava;
private int jdbc;
private int HibernateJpa;
private int SpringMvc;
private int RestApi;
private int MySQl;
private int Devops;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Integer getStudentId() {
	return studentId;
}
public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}

public int getCoreJava() {
	return CoreJava;
}
public void setCoreJava(int coreJava) {
	CoreJava = coreJava;
}
public int getJdbc() {
	return jdbc;
}
public void setJdbc(int jdbc) {
	this.jdbc = jdbc;
}
public int getHibernateJpa() {
	return HibernateJpa;
}
public void setHibernateJpa(int hibernateJpa) {
	HibernateJpa = hibernateJpa;
}
public int getSpringMvc() {
	return SpringMvc;
}
public void setSpringMvc(int springMvc) {
	SpringMvc = springMvc;
}
public int getRestApi() {
	return RestApi;
}
public void setRestApi(int restApi) {
	RestApi = restApi;
}
public int getMySQl() {
	return MySQl;
}
public void setMySQl(int mySQl) {
	MySQl = mySQl;
}
public int getDevops() {
	return Devops;
}
public void setDevops(int devops) {
	Devops = devops;
}
public float getSGPA() {
	return SGPA;
}
public void setSGPA(float sGPA) {
	SGPA = sGPA;
}
public String getGrade() {
	return Grade;
}
public void setGrade(String grade) {
	Grade = grade;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
private float SGPA;
private String Grade;
}
