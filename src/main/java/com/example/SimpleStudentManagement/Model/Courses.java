package com.example.SimpleStudentManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Courses {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private int course_id;
private String course_name;
private String tutor_name;;
private float price;
private String Duration;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCourse_id() {
	return course_id;
}
public void setCourse_id(int course_id) {
	this.course_id = course_id;
}

public String getCourse_name() {
	return course_name;
}
public void setCourse_name(String course_name) {
	this.course_name = course_name;
}
public String getTutor_name() {
	return tutor_name;
}
public void setTutor_name(String tutor_name) {
	this.tutor_name = tutor_name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getDuration() {
	return Duration;
}
public void setDuration(String duration) {
	Duration = duration;
}

}
