package com.atdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.atdev.entities.StudentDetails;
import com.atdev.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//api to insert student record
	@PostMapping("/")
	public ResponseEntity<StudentDetails> insertStudent(@RequestBody StudentDetails student)
	{
		StudentDetails studentDetails = studentService.addStudent(student);
		return ResponseEntity.ok(studentDetails);
		
	}
	
	//api to get all student records
	@GetMapping("/")
	public ResponseEntity<List<StudentDetails>> displayAllStudents()
	{
		List<StudentDetails> allStudents = studentService.getAllStudents();
		return ResponseEntity.ok(allStudents);
	}
	
	//api to get single student
	@GetMapping("/{studentId}")
	public ResponseEntity<?> displaySingleStudent(@PathVariable("studentId") long studentId)
	{
		StudentDetails singleStudent = studentService.getSingleStudent(studentId);
		return ResponseEntity.ok(singleStudent);
			
	}
	
	//api to update student record
	@PutMapping("/updateStudent/{studentId}")
	public ResponseEntity<StudentDetails> updateStudentDetails(@RequestBody StudentDetails studentDetails,
			@PathVariable("studentId") long studentId)
	{
		StudentDetails student = studentService.updateStudentDetails(studentDetails, studentId);
		return ResponseEntity.ok(student);
	}
	
	//api to delete student record
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable("studentId") long studentId)
	{
		studentService.deleteStudentDetails(studentId);
		return new ResponseEntity<>("Student Details deleted successfully!!", HttpStatus.ACCEPTED);
			
	}
	
	

}
