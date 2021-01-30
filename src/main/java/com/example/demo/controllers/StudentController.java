package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentController(StudentRepository studentRepository,
			StudentService studentService) {
		this.studentRepository = studentRepository;
	}
	
//	Tempopary add students at initialization
//	@GetMapping("/add")
//	public String addStudents() {
//		this.studentService.addStudentsInit();
//		return "Added";
//	}
	
//	Home
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	
//	Get all students
	@GetMapping("/")
	public List<Student> getStudents(){
		return this.studentRepository.findAll();
	}
		
//	Get student by studentId
	@GetMapping("/{studentId}")
	public Student getStudent(@PathVariable("studentId") String studentId) {
		return this.studentRepository.findById(studentId).orElse(null);
	}
	
//	Add student
	@PostMapping("/")
	public Student addStudent(@RequestBody Student student) {
		return this.studentRepository.save(student);
	}
	
//	Update student
	@PutMapping("/{studentId}")
	public Student updateStudent(@PathVariable("studentId") String studentId, @RequestBody Student student) throws Exception {
		Student studentToUpdate = this.studentRepository.findById(studentId).
				orElseThrow(() -> new Exception("Student not found"));
		
		studentToUpdate.setStudentName(student.getStudentName());
		studentToUpdate.setStudentMarks(student.getStudentMarks());
		studentToUpdate.setStudentAge(student.getStudentAge());
		
		return this.studentRepository.save(studentToUpdate);
	}
	
//	Delete student
	@DeleteMapping("/{studentId}")
	public String deleteStudent(@PathVariable("studentId") String studentId){
		this.studentRepository.deleteById(studentId);
		return "Student with " + studentId + " deleted";
	}
}
