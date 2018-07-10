package com.pro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.dao.UserDAO;
import com.pro.entity.Apartment;
import com.pro.entity.User;
import com.pro.service.ApartmentMaintainService;
import com.pro.uilts.JsonTools;

/**
 * Servlet implementation class GetUserByApartmentServlet
 */
@WebServlet("/getUserByApartmentServlet.action")
public class GetUserByApartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserByApartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Map<String, Object>  params =  new HashMap<String, Object>();
		
		// 接受页面的值
		String apart_name = request.getParameter("apart_name");
		String apart_number = request.getParameter("apart_number");
		//调用service层获得数据
		ApartmentMaintainService apartmentMaintainService = new ApartmentMaintainService();
		List<User> userlistbyapartment = apartmentMaintainService.queryApartmentList(apart_name, apart_number);
		//想页面传值
		params.put("rows", userlistbyapartment);
		String resultJSONString = JsonTools.createJsonString(params);
		out.println(resultJSONString);
	    
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
