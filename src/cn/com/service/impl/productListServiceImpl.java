package cn.com.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.pojo.Product;
import cn.com.service.productListService;

public class productListServiceImpl implements productListService {

	@Override
	public List getProductList() {
		
		List productList = new ArrayList();
    	
    	Connection conn = null;
    	
    	Statement stmt = null;
    	
    	ResultSet rs = null;
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from product");
			
			while(rs.next()){
				Product Product = new Product();
                
				Product.setProductid(rs.getString("productid"));
				Product.setName(rs.getString("name"));
				Product.setDescription(rs.getString("description"));
				Product.setBasePrice(rs.getString("basePrice"));
				Product.setCategoryid(rs.getString("categoryid"));
				Product.setAuthor(rs.getString("author"));
				Product.setPublish(rs.getString("publish"));
				Product.setPages(rs.getString("pages"));
				Product.setImages(rs.getString("images"));
				productList.add(Product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying students ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying students ",e);
			}
		}
    	return productList;
    	
	}
}
