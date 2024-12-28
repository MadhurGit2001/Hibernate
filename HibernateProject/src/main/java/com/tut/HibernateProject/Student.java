package com.tut.HibernateProject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_mpstrak_student")
public class Student {
	@Id
	@GeneratedValue
	private Integer studentId;
	private String name;
	private String address;
	private Integer rollNo;
	private Certificate certificate;

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public Student(Integer studentId, String name, String address, Integer rollNo) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.address = address;
		this.rollNo = rollNo;
	}

	public Student() {
		super();
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

}
