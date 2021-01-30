package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("student")
public class Student {
	
	@Id
	private String studentId;
	private String studentName;
	private Float studentMarks;
	private Integer studentAge;
	
	public Student() {
		super();
	}
	public Student(String studentName, Float studentMarks, Integer studentAge) {
		super();
		this.studentName = studentName;
		this.studentMarks = studentMarks;
		this.studentAge = studentAge;
	}
	public Student(String studentId, String studentName, Float studentMarks, Integer studentAge) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
		this.studentAge = studentAge;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Float getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(Float studentMarks) {
		this.studentMarks = studentMarks;
	}
	public Integer getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	
}
