package com.pro.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pro.db.DBaccess;
import com.pro.entity.Page;
import com.pro.entity.User;

/**
 * @author cug_lzt
 * DAO层的类名于操作的数据表名一致
 * 此类用于写和User表的所有操作
 */
public class UserDAO {
	public List<User> queryUserList(String username,String role){
		DBaccess dBaccess = new DBaccess();
		SqlSession sqlSession = null;
		List<User> userlist = new ArrayList<User>();
		//因为mybatis只允许传递一个参数，所以用对象类型去封装两个参数
		User user = new User();
		user.setUsername(username);
		user.setRole(role);
		Map<String, Object> param  = new HashMap<String, Object>();
		try {
			sqlSession = dBaccess.getSqlSession();
			//通过实体配置文件的命名空间和sql的id；sqlSession执行sql语句
			userlist = sqlSession.selectList("User.queryUserList",user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null)
				sqlSession.close();
		}
		
		return userlist;
	}
	
	//分页
	public Map<String, Object> queryUserList(String username,String role,String page,String rows){
		Map<String, Object> resultmap = new HashMap<String, Object>();
		int total = 0;
		
		Page pa = new Page();
		pa.setIndex((Integer.parseInt(page)-1) * Integer.parseInt(rows));
		pa.setPagenumber(Integer.parseInt(rows));
		
		DBaccess dBaccess = new DBaccess();
		SqlSession sqlSession = null;
		List<User> userlist = new ArrayList<User>();
		//因为mybatis只允许传递一个参数，所以用对象类型去封装两个参数
		User user = new User();
		user.setUsername(username);
		user.setRole(role);
		
		Map<String, Object> param  = new HashMap<String, Object>();
		param.put("pa", pa);
		param.put("user", user);
		try {
			sqlSession = dBaccess.getSqlSession();
			//通过实体配置文件的命名空间和sql的id；sqlSession执行sql语句
			userlist = sqlSession.selectList("User.queryUserListBypage",param);

			/*IMessage imessage = sqlSession.getMapper(IMessage.class);
			result = imessage.count(message);*/
			total = sqlSession.selectList("User.queryTotal",user).size();
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null)
				sqlSession.close();
		}
		resultmap.put("list", userlist);
		resultmap.put("total", total);
		return resultmap;
	}
	
	/**
	 * 删除一个
	 * @param id
	 */
public void deleteOne(int id){
		DBaccess dBaccess = new DBaccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dBaccess.getSqlSession();
			//通过实体配置文件的命名空间和sql的id；sqlSession执行sql语句
			sqlSession.delete("User.deleteOne",id);
			//增删改 和 查询不一样 是需要修改数据库的，mybatis是不默认提交事物的，所以这里需要手动提交
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null)
				sqlSession.close();
		}
	}

/**
 * @param ids
 * 多条删除
 */
public void deleteBatch(List<Integer> ids){
		DBaccess dBaccess = new DBaccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dBaccess.getSqlSession();
			//通过实体配置文件的命名空间和sql的id；sqlSession执行sql语句
			sqlSession.delete("User.deleteBatch",ids);
			//增删改 和 查询不一样 是需要修改数据库的，mybatis是不默认提交事物的，所以这里需要手动提交
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null)
				sqlSession.close();
		}
	}


}
