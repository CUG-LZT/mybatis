package com.pro.service;

import java.util.List;

import com.pro.dao.ApartmentDAO;
import com.pro.entity.Apartment;

public class ApartmentMaintainService {
	public List<Apartment> queryApartmentList(String apart_name,int apart_number){
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		return apartmentDAO.queryApartmentList(apart_name, apart_number);
	}
}
