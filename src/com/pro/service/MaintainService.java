package com.pro.service;

import java.util.List;

import com.pro.dao.UserDAO;

/**
 * @author cug_lzt
 * 维护service
 */
public class MaintainService {
	public void deleteOne(int id){
		UserDAO userDAO = new UserDAO();
		userDAO.deleteOne(id);
	}
	
	public void deleteBatch(List<Integer> ids){
		UserDAO userDAO = new UserDAO();
		userDAO.deleteBatch(ids);
	}
}
