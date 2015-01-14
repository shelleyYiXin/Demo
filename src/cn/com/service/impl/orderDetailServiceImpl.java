package cn.com.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.pojo.OrderDetail;
import cn.com.service.orderDetailService;

public class orderDetailServiceImpl implements orderDetailService{

	@Override
	public List getOrderDetailList(String s) {
        List orderDetailList = new ArrayList();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap", "root", "");
			stmt = (Statement) conn.createStatement();
			System.out.println(s);
			rs = (ResultSet) stmt.executeQuery("select * from product,orderline,orders,payway,users,contactinfo where product.productid=orderline.productid and orderline.orderid=orders.orderid and orders.paywayid=payway.paywayid and orders.userid=users.userid and users.userid=contactinfo.userid and orders.orderid='"+s+"'");
			rs.next();
			System.out.println(rs.getString("orders.orderid"));
				OrderDetail orderdetail = new OrderDetail();
				
				orderdetail.setUserid(rs.getString("userid"));
				orderdetail.setStreet1(rs.getString("street1"));
				orderdetail.setZip(rs.getString("zip"));
				orderdetail.setHomephone(rs.getString("homephone"));
				orderdetail.setOfficephone(rs.getString("officephone"));
				orderdetail.setCellphone(rs.getString("cellphone"));
				orderdetail.setEmail(rs.getString("email"));
				orderdetail.setPaystyle(rs.getString("paystyle"));
				orderdetail.setLineid(rs.getString("lineid"));
				orderdetail.setProductname(rs.getString("product.name"));
				orderdetail.setBasePrice(rs.getString("basePrice"));
				orderdetail.setAmount(rs.getString("amount"));
				orderdetail.setCost(rs.getString("cost"));
				
				orderDetailList.add(orderdetail);			
				
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying orderdetail ",e);
		}finally{
			try {
				rs.close();
				stmt.close();
			    conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying orderdetail ",e);
			}
		}
		
		return orderDetailList;
	}

}
