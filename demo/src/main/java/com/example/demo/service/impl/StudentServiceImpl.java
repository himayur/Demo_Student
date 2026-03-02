package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.service.interfaces.StudentService;
import com.example.demo.service.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository sr;

	@Override
	public void add(Student s) {
		sr.save(s);

	}

	@Override
	public List<Student> display() {

		return sr.findAll();
	}

	@Override
	public Student update(Student s, Integer roll) {
		Student s1 = sr.findById(roll).orElse(null);
		s1.setName(s.getName());
		s1.setDivision(s.getDivision());
		s1.setMarks(s.getMarks());
		sr.save(s1);
		return sr.findById(s1.getRoll()).orElse(null);
	}

	@Override
	public String delete(Integer roll) {
		Student s1 = sr.findById(roll).orElse(null);
		sr.delete(s1);
		return "Deleted Successfully";
	}

}