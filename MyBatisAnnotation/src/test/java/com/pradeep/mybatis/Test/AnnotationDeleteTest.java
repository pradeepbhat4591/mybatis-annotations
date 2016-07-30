package com.pradeep.mybatis.Test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pradeep.mybatis.mapper.StudentMapper;

public class AnnotationDeleteTest {
	public static void main(String args[]) throws IOException {

		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		session.getConfiguration().addMapper(StudentMapper.class);

		StudentMapper mapper = session.getMapper(StudentMapper.class);
		mapper.delete(3);
		System.out.println("record deleted successfully");
		session.commit();
		session.close();

	}
}
