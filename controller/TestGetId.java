package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestGetId {
public static void main(String[] args) {
	StudentDao studentDao =new StudentDao();
	Student s= studentDao.getStudentById(4);
	System.out.println(s.getId());
	
}
}
