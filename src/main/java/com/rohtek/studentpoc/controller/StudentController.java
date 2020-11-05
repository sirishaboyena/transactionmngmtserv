package com.rohtek.studentpoc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohtek.studentpoc.entities.Student;
import com.rohtek.studentpoc.exception.ResourceNotFoundException;
import com.rohtek.studentpoc.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	@DeleteMapping("/students/{id}")
    public Map< String, Boolean > deleteStudent(@PathVariable(value = "id") Long studentId) throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

        studentRepository.delete(student);
        Map < String, Boolean > response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
