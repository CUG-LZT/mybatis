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
import com.pro.service.MaintainService;
import com.pro.uilts.JsonTools;

/**
 * Servlet implementation class UserAction
 */
@WebServlet("/useraction.action")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("action").equals("delelist")){
			// 接受页面的值
			String[] ids = request.getParameterValues("ids");
			//调用service层进行操作--servlet不进行任何操作只进行传值，其他的事情有业务层
			MaintainService maintainService = new MaintainService();
			maintainService.deleteBatch(ids);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
