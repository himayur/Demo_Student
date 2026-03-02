package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	void add(Student s);

	List<Student> display();

	Student update(Student s, Integer roll);

	String delete(Integer roll);
}