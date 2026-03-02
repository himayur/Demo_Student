package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.interfaces.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public void addStudent(@RequestBody Student s) {
		studentService.add(s);
	}

	@GetMapping("/display")
	public List<Student> displayStudents() {
		return studentService.display();

	}

	@PutMapping("/update/{roll}")
	public Student updateStudent(@RequestBody Student s, @PathVariable("roll") Integer roll) {
		return studentService.update(s, roll);
	}

	@DeleteMapping("/delete/{roll}")
	public String deleteStudent(@PathVariable Integer roll) {
		return studentService.delete(roll);

	}
}