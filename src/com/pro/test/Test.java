package com.pro.test;

import java.util.List;

import com.pro.dao.UserDAO;
import com.pro.entity.User;

public class Test {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		List<User> userlist = userDAO.queryUserList();
		for (User user : userlist) {
			System.out.println(user.toString());
		}
	}
}
