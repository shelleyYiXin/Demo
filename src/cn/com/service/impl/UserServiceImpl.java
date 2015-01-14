package cn.com.service.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.pojo.Users;
import cn.com.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public List getUserList() {
		List usersList = new ArrayList();
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from users");
			
			while(rs.next()){
				Users users = new Users();
				
				users.setUserid(rs.getString("userid"));
				users.setPassword(rs.getString("password"));
				
				usersList.add(users);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying users ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying users ",e);
			}
		}
		
		return usersList;
	}
	@Override
	public Users getUsersByUseridAndPassword(Users paramUsers) {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from users where userid = '"
					+ paramUsers.getUserid() + "' and password = '"
					+ paramUsers.getPassword() + "'");

			if (rs.next()) {
				Users users = new Users();
				users.setUserid(rs.getString("userid"));
				users.setPassword(rs.getString("password"));
				return users;
			}
			else
			{
				System.out.println("Error");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying users!", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying users!", e);
			}
		}
		return null;
	}

}
