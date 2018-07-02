package com.pro.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @author cug_lzt
 * 访问数据库的类；用于获取sqlsession
 */
public class DBaccess {
	public SqlSession getSqlSession() throws IOException{
		//通过配置文件获取数据库的连接信息
		Reader reader = Resources.getResourceAsReader("Configuration.xml");
		//通过配置信息构建一个sqlsessionfactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//通过SqlSessionFactory打开一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
