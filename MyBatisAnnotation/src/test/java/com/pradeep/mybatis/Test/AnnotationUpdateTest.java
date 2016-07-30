package com.pradeep.mybatis.Test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pradeep.mybatis.domain.Student;
import com.pradeep.mybatis.mapper.StudentMapper;

public class AnnotationUpdateTest {

	public static void main(String args[]) throws IOException{
	      
		   Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
		   SqlSession session = sqlSessionFactory.openSession();   
		   session.getConfiguration().addMapper(StudentMapper.class);
		   StudentMapper mapper = session.getMapper(StudentMapper.class); 
		      
		   //select a particular student using id		
		   Student student = mapper.getById(14);
		   System.out.println("Current details of the student are "+student.toString());  
		      
		   //Set new values to the mail and phone number of the student
		   student.setEmail("Shyam123@yahoo.com");
		   student.setPhone(984802233);
		      
		   //Update the student record
		   
		   mapper.update(student);
		   System.out.println("Record updated successfully");   
		   session.commit();   
		   session.close();

		}	
}
