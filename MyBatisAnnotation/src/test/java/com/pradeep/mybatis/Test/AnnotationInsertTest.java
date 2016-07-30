package com.pradeep.mybatis.Test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pradeep.mybatis.domain.Student;
import com.pradeep.mybatis.mapper.StudentMapper;

public class AnnotationInsertTest {

	 public static void main(String args[]) throws IOException{
	      
	      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	      SqlSession session = sqlSessionFactory.openSession();
	      session.getConfiguration().addMapper(StudentMapper.class);
	      
	      StudentMapper mapper = session.getMapper(StudentMapper.class);      
	      
	      //Create a new student object
	      Student student = new Student();
	      
	      //Set the values      
	      student.setName("zara");
	      student.setBranch("EEE");
	      student.setEmail("zara@gmail.com");
	      student.setPercentage(90);
	      student.setPhone(123412341);
	            
	      //Insert student data   
	      mapper.insert(student);
	      System.out.println("record inserted successfully");
	      session.commit();
	      session.close();
				
	   }
}
