package cn.com.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.pojo.Orderline;
import cn.com.pojo.Orders;
import cn.com.pojo.Orderstatus;
import cn.com.pojo.Payway;
import cn.com.service.orderService;

public class orderServiceImpl implements orderService{

	@Override
	public List getOrderList() {
		List orderList = new ArrayList();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap", "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from orderline,orders,orderstatus,payway where orderline.orderid=orders.orderid and orders.statusid=orderstatus.statusid and orders.paywayid=payway.paywayid");
			while(rs.next()){
				Orderline orderline1 = new Orderline();
				
				orderline1.setLineid(rs.getString("lineid"));
				orderline1.setOrderid(rs.getString("orderid"));
				orderline1.setCost(rs.getString("cost"));
				orderline1.setOrderstatusname(rs.getString("orderstatus.name"));
				orderline1.setPaystyle(rs.getString("paystyle"));
				
				orderList.add(orderline1);			
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying orders ",e);
		}finally{
			try {
				rs.close();
				stmt.close();
			    conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying orders ",e);
			}
		}
		
		return orderList;
	}

}
