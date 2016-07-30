package com.pradeep.mybatis.Test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pradeep.mybatis.domain.Student;
import com.pradeep.mybatis.mapper.StudentMapper;

public class AnnotationReadTest {
	
	public static void main(String args[]) throws IOException{
	      
		   Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
		   SqlSession session = sqlSessionFactory.openSession();
		   session.getConfiguration().addMapper(StudentMapper.class);      
		   StudentMapper mapper = session.getMapper(StudentMapper.class);
		      
		   Student student = mapper.getById(14);
		   System.out.println(student.getBranch());
		   System.out.println(student.getEmail());
		   System.out.println(student.getId());
		   System.out.println(student.getName());
		   System.out.println(student.getPercentage());
		   System.out.println(student.getPhone());      
		   session.commit();
		   session.close();
					
		}

}
