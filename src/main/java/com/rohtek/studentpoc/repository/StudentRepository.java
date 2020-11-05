package com.rohtek.studentpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohtek.studentpoc.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
