package com.example.demo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}
	
	public String addStudentsInit() {
		List<Student> students = (List<Student>) Arrays.asList(
						new Student("Mahesh", 78.55f, 24), 
						new Student("Dinesh", 88.55f, 22)
						);
		this.studentRepository.insert(students);
		return "Students added successfully";
	}

}
