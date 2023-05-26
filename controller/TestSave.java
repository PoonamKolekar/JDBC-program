package com.jsp.controller;
import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;
public class TestSave {

	public static void main(String[] args) {
		Student student = new Student();
		student.setId(4);
		student.setName("abc");
		student.setEmail("abc@123");
		
		StudentDao studentDao = new StudentDao();
		Student s= studentDao.saveStudent(student);
		
		
		System.out.println(s.getName()+"saved suuccesfully");
		
	}
}
