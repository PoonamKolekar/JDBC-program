package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Student;
import com.jsp.helper.HelperClass;

public class StudentDao {
	
	HelperClass helperClass= new HelperClass();
//to save a student
	//multiple student
	Connection connection= null;
	public void addMultipleStudents(List<Student>students) {
		connection=helperClass.getConnection();
		String sql="INSERT INTO student VALUES(?,?,?)";
		try {//create statement
			PreparedStatement preparedStatement=
			connection.prepareCall(sql);
			//execute statement
			
			for(Student s :students) {
			preparedStatement.setInt(1,s.getId());
			preparedStatement.setString(2,s.getName());
			preparedStatement.setString(3,s.getEmail());
			preparedStatement.addBatch();
			
			}	
			
			preparedStatement.executeBatch();
			System.out.println("all good");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//get by id
	
	public Student getStudentById(int id) {
		connection= helperClass.getConnection();
		String sql = "Select * FROM student Where Id = ?";
		Student student2= new Student();
		
		try {
			PreparedStatement preparedStatement = 
					connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			//execute statement
			
	ResultSet resultSet= 	preparedStatement.executeQuery()	;
	while(resultSet.next()) {
		int id2= resultSet.getInt(1);
		String name= resultSet.getString(2);
		String email= resultSet.getString(3);
		
		student2.setId(id2);
		student2.setName(name);
		student2.setEmail(email);
	
	}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return student2;
	}
	
	//update 
	public boolean updateStudentById(int id,String email) {
		connection=helperClass.getConnection();
		
		
		
	
		//create statement
		String sql ="UPDATE student set email=? Where id =?" ;
		try {
			PreparedStatement preparedStatement = 
					connection.prepareStatement(sql);
			preparedStatement.setString(1,email);
			preparedStatement.setInt(2,id);
		
			//execute statement
			preparedStatement.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return true;
				
	}	
		
		
	
//GETALL
	
	public List<Student> getAllStudents(){
		connection=helperClass.getConnection();
		String sql ="SELECT * FROM student";
		ArrayList<Student> a1= null;
		// PreparedStatement preparedStatement =null;
		
		
     
   
	try {
		 PreparedStatement preparedStatement = connection.prepareStatement(sql);
		 ResultSet resultSet=preparedStatement.executeQuery();

		
		
		//ArrayList a = new ArrayList<>();
		a1 =new ArrayList<>();
		while (resultSet.next()) {
			
		int id = resultSet.getInt(1);
		String name= resultSet.getString(2);
		String email= resultSet.getString(3);
	
			Student s= new Student();
			s.setId(id);
			s.setName(name);
			s.setEmail(email);	
			
			a1.add(s);
	} 
		
	}catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	
	finally {
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
   return a1;    
       
	}
       
	
    
     //DELETE
	public boolean deleteStudntById(int id) {
		connection=helperClass.getConnection();
     String sql = "DELETE from student WHERE id=?";
	boolean res= false;
	
	try {//create statement
		PreparedStatement preparedstatement= connection.prepareStatement(sql);
		preparedstatement.setInt(1,id);
		//execute
		
		int res2= preparedstatement.executeUpdate();
		
		if(res2 >0) {
		 res= true;
		}else {
			res=false;
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return res;
	}
	
	//to save student
	public Student saveStudent(Student student) {
	Connection connection= helperClass.getConnection();
	
	
	String sql="INSERT INTO student VALUES( ?,?,?)";
	//create statement
	
	try {
		PreparedStatement preparedStatement = 
				connection.prepareStatement(sql);
		
		preparedStatement.setInt(1,student.getId());
		preparedStatement.setString(2,student.getName());
		preparedStatement.setString(3,student.getEmail());
		//prepredStatement.setInt(4,student.getPno());
		
		
		
		//EXECUTE THE STATEMENT
		preparedStatement.execute();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	return student;
}
	
	
	
	
}