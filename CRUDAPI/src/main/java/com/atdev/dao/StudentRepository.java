package com.atdev.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atdev.entities.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Long> {

}
