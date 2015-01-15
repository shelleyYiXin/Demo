package cn.com.service.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.pojo.Contactinfo;
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
	
	public Contactinfo getContactinfo(Users aUser){
		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from contactinfo where userid = '"
					+ aUser.getUserid() + "'");

			if (rs.next()) {
				Contactinfo acontactinfo = new Contactinfo();
				
				acontactinfo.setCellphone(rs.getString("cellphone"));
				acontactinfo.setCity(rs.getString("city"));
				acontactinfo.setContactid(rs.getString("contactid") );
				acontactinfo.setCountry(rs.getString("country"));
				acontactinfo.setEmail(rs.getString("email"));
				acontactinfo.setHomephone(rs.getString("homephone"));
				acontactinfo.setOfficephone(rs.getString("officephone"));
				acontactinfo.setProvince(rs.getString("province"));
				acontactinfo.setStreet1(rs.getString("street1"));
				acontactinfo.setStreet2(rs.getString("street2"));
				acontactinfo.setUserid(rs.getString("userid"));
				acontactinfo.setZip(rs.getString("zip"));
				
				return acontactinfo;
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
	
	public boolean UpdateUser(Users mUser,String oldUserid){
		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");

			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("UPDATE users SET userid ='"+ mUser.getUserid() + "',password='"
			+ mUser.getPassword() +
			"' WHERE userid ='"+ oldUserid+ "'");

			if (rs.next()) {
				return true;
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
		return false;
	}
	
	public boolean UpdateContactinfo(Contactinfo mContactinfo){
		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");

			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("UPDATE contactinfo SET userid ='"+mContactinfo.getUserid() 
					+ "',country='"+ mContactinfo.getCountry() 
					+"',province='"+mContactinfo.getProvince()
					+"',city='"+mContactinfo.getCity()
					+"',street1='"+mContactinfo.getStreet1()
					+"',street2='"+mContactinfo.getStreet2()
					+"',homephone='"+mContactinfo.getHomephone()
					+"',officephone='"+mContactinfo.getOfficephone()
					+"',cellphone='"+mContactinfo.getCellphone()
					+"',zip='"+mContactinfo.getZip()
					+"',email='"+mContactinfo.getEmail()
					+"' WHERE contactid ='"+ mContactinfo.getContactid()+ "'");

			if (rs.next()) {
				return true;
			}
			else
			{
				System.out.println("Error");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying contactinfo!", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying contactinfo!", e);
			}
		}	
		return false;
	}


}
