package cn.com.pojo;

public class Orderline {
	private String lineid;
	private String orderid;
	private String productid;
	private String amount;
	private String ordersname;
	private String cost;
	private String userid;
	private String statusid;
	private String paywayid;
	private String orderstatusname;
	private String description;
	private String paystyle;
	public String getLineid() {
		return lineid;
	}
	public void setLineid(String lineid) {
		this.lineid = lineid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getOrdersname() {
		return ordersname;
	}
	public void setOrdersname(String ordersname) {
		this.ordersname = ordersname;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStatusid() {
		return statusid;
	}
	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}
	public String getPaywayid() {
		return paywayid;
	}
	public void setPaywayid(String paywayid) {
		this.paywayid = paywayid;
	}
	
	public String getOrderstatusname() {
		return orderstatusname;
	}
	public void setOrderstatusname(String orderstatusname) {
		this.orderstatusname = orderstatusname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaystyle() {
		return paystyle;
	}
	public void setPaystyle(String paystyle) {
		this.paystyle = paystyle;
	}
	
}
