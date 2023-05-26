package com.jsp.controller;

import com.jsp.dao.StudentDao;

public class TestUpdate {
public static void main(String[] args) {
StudentDao studentDao =new StudentDao();
String email= "poonam@789";
	boolean c=studentDao.updateStudentById(1, email);
	System.out.println(c);
}
}
