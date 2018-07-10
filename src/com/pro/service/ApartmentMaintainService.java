package com.pro.service;

import java.util.ArrayList;
import java.util.List;

import com.pro.dao.ApartmentDAO;
import com.pro.entity.Apartment;
import com.pro.entity.User;

public class ApartmentMaintainService {
	public List<User> queryApartmentList(String apart_name,String apart_number){
		List<User> userlist = new ArrayList<User>();
		int apartment_number;
		if(apart_number != null && !"".equals(apart_number.trim())){
			apartment_number = Integer.parseInt(apart_number);
		}else{
			apartment_number = 0;
		}
			
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		List<Apartment> list =  apartmentDAO.queryApartmentList(apart_name, apartment_number);
		//将搜索出来的所有结果都去掉部门信息，然后组合成全体user信息，进行显示
		for (int i = 0; i < list.size(); i++) {
			userlist.addAll(list.get(i).getUserlist());
		}
		return userlist;
	}
}
