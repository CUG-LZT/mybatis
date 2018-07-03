package com.pro.dao;
/**
 * @author cug_lzt
 * 和Apartment类相关的操作
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pro.db.DBaccess;
import com.pro.entity.Apartment;
import com.pro.entity.User;

/**
 * 通过部门的名字或者是编号来查询这个部门的人员
 * @param apart_name
 * @param apart_number
 * @return
 */
public class ApartmentDAO {
	public List<Apartment> queryApartmentList(String apart_name,int apart_number){
		DBaccess dBaccess = new DBaccess();
		SqlSession sqlSession = null;
		List<Apartment> apartmentlist = new ArrayList<Apartment>();
		//因为mybatis只允许传递一个参数，所以用对象类型去封装两个参数
		Apartment Apartment = new Apartment();
		Apartment.setApart_name(apart_name);
		Apartment.setApart_number(apart_number);
		try {
			sqlSession = dBaccess.getSqlSession();
			//通过实体配置文件的命名空间和sql的id；sqlSession执行sql语句
			apartmentlist = sqlSession.selectList("Apartment.queryApartmentList",Apartment);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null)
				sqlSession.close();
		}
		return apartmentlist;
	}
}
