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
import com.pro.entity.User;
import com.pro.uilts.JsonTools;

/**
 * Servlet implementation class GetUserByPage
 */
@WebServlet("/getUserByPage.action")
public class GetUserByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserByPage() {
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
		String username = request.getParameter("username");
		String role = request.getParameter("role");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		
		//调用service层获得数据
		UserDAO userDAO = new UserDAO();
		Map<String, Object> resultmap = userDAO.queryUserList( username , role , page , rows);
		
		//想页面传值
		params.put("total", resultmap.get("total"));
		params.put("rows", resultmap.get("list"));
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
