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

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/getuser.action")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 设置编码
				request.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				
				Map<String, Object>  params =  new HashMap<String, Object>();
				
				// 接受页面的值
				String username = request.getParameter("username");
				String role = request.getParameter("role");
				//调用service层获得数据
				UserDAO userDAO = new UserDAO();
				List<User> userlist = userDAO.queryUserList( username , role);
				//想页面传值
				params.put("rows", userlist);
				String resultJSONString = JsonTools.createJsonString(params);
				out.println(resultJSONString);
			    
				out.flush();
				out.close();
	}

}
