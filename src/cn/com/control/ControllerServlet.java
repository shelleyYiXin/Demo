package cn.com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.pojo.Users;
import cn.com.service.UserService;
import cn.com.service.impl.UserServiceImpl;
 

public class ControllerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String path = req.getServletPath();
		System.out.println(path);
		path = path.substring(0,path.indexOf("."));
	    if("/toLogin".equals(path)){
      
			getServletContext().getRequestDispatcher("/login").forward(req, resp);
			
		}
        else if("/doLogin".equals(path)){
			String userid = req.getParameter("userid");			
			String password = req.getParameter("password");
			System.out.println(userid+"   "+password);
			Users paramUsers = new Users();
			
			paramUsers.setUserid(userid);
			paramUsers.setPassword(password);
			
			UserService userService = new UserServiceImpl();
			
			Users users = userService.getUsersByUseridAndPassword(paramUsers);
			
			if(users != null){
				//req.setAttribute("users", users);
				System.out.println(users.getUserid());
				getServletContext().getRequestDispatcher("/productList").forward(req, resp);
				System.out.println("3");
			}else{
				req.setAttribute("message", "The user was not found");
				System.out.println("2");
				getServletContext().getRequestDispatcher("/login").forward(req, resp);
			}
			
		} else {
			System.out.println("22");
			resp.sendError(resp.SC_NOT_FOUND);
		}
   	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
