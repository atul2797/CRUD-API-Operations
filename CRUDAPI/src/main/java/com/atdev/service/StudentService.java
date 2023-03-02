package com.atdev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atdev.dao.StudentRepository;
import com.atdev.entities.StudentDetails;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	// insert student
	public StudentDetails addStudent(StudentDetails s) {
		StudentDetails student = studentRepository.save(s);
		return student;
	}

	// to get all student records
	public List<StudentDetails> getAllStudents() {
		List<StudentDetails> allStudents = studentRepository.findAll();
		return allStudents;
	}

	// to get student by id
	public StudentDetails getSingleStudent(long studentId) {
		StudentDetails student = studentRepository.findById(studentId).get();
		return student;
	}

	// to update student details
	public StudentDetails updateStudentDetails(StudentDetails studentDetails, long studentId) {
		studentDetails.setStudentId(studentId);
		StudentDetails student = studentRepository.save(studentDetails);
		return student;
	}

	// to delete student details
	public void deleteStudentDetails(long studentId) {
		studentRepository.deleteById(studentId);
	}

}
