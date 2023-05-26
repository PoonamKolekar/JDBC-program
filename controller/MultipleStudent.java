package com.jsp.controller;
import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;
import java.util.ArrayList;
public class MultipleStudent {

	public static void main(String[] args) {
		Student s1= new Student();
		ArrayList<Student> a1= new ArrayList<>();
		s1.setId(5);
		s1.setName("sneha");
		s1.setEmail("sneha@123");
		 Student s2 =new Student();
		 s2.setId(6);
		 s2.setName("vishakha");
		 s2.setEmail("vishakha@123");
		 Student s3 =new Student();
		 s3.setId(7);
		 s3.setName("neha");
		 s3.setEmail("neha@123");
		 
		 a1.add(s3);
		 a1.add(s2);
		 a1.add(s1);
		 StudentDao student= new StudentDao();
		 student.addMultipleStudents(a1);
	}
	
}
