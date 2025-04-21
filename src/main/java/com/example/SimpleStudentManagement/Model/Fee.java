package com.example.SimpleStudentManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int studentId;
	private String name;
	private String Branch;
	private float Fee;
	private float FeeBalance;
	private float BuildingFee;
	private float CollegeFee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public float getFee() {
		return Fee;
	}
	public void setFee(float fee) {
		Fee = fee;
	}
	public float getFeeBalance() {
		return FeeBalance;
	}
	public void setFeeBalance(float feeBalance) {
		FeeBalance = feeBalance;
	}
	public float getBuildingFee() {
		return BuildingFee;
	}
	public void setBuildingFee(float buildingFee) {
		BuildingFee = buildingFee;
	}
	public float getCollegeFee() {
		return CollegeFee;
	}
	public void setCollegeFee(float collegeFee) {
		CollegeFee = collegeFee;
	}
	
	
}
