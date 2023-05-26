package com.jsp.controller;

import java.util.List;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class GetAll {
public static void main(String[] args) {
	StudentDao studentDao = new StudentDao();
	List<Student>al=studentDao.getAllStudents();
	
	for(Student s: al) {//for loop for array
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getEmail());
		System.out.println("==========");
	}
	
	
	
}
}
