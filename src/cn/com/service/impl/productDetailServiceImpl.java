package cn.com.service.impl;


import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import cn.com.pojo.Product;
import cn.com.service.productDetailService;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class productDetailServiceImpl implements productDetailService {
	public List getproductdetails(String s)
	{
		
		List productList = new ArrayList();
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = (Statement) conn.createStatement();
			//System.out.println(s);
			rs = (ResultSet) stmt.executeQuery("select * from product where productid = '"+s+"'");
			
			rs.next();
	       //System.out.println(rs.getString("productid"));
			Product pd = new Product();
				
			pd.setProductid(rs.getString("productid"));
			pd.setName(rs.getString("name"));
			pd.setDescription(rs.getString("description"));
			pd.setBasePrice(rs.getString("basePrice"));
			pd.setCategoryid(rs.getString("categoryid"));
			pd.setAuthor(rs.getString("author"));
			pd.setPublish(rs.getString("publish"));
			pd.setPages(rs.getString("pages"));
			pd.setImages(rs.getString("images"));
				
			productList.add(pd);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying productdetails ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying productdetails ",e);
			}
		}

		return productList;
		
	}
	

}

