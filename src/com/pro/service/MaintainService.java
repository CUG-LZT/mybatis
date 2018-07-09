package com.pro.service;

import java.util.ArrayList;
import java.util.List;

import com.pro.dao.UserDAO;

/**
 * @author cug_lzt
 * 维护service
 */
public class MaintainService {
	public void deleteBatch(String[] arg){
		//将通过servlet接到的String数组转为List<integer>
		List<Integer> ids = new ArrayList<Integer>();
		for (int i = 0; i < arg.length; i++) {
			ids.add(i, Integer.parseInt(arg[i]));
		}
		UserDAO userDAO = new UserDAO();
		userDAO.deleteBatch(ids);
	}
}
