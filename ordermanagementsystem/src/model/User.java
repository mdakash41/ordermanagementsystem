package model;

import java.sql.SQLException;
import java.util.LinkedList;

import application.Database;

public class User {
	
	private String name,userid,password;
	Database database;
	
	public User(String name,String userid,String password) {
		this.name=name;
		this.userid=userid;
		this.password=password;
		database=new Database();
	}

	public String getName() {
		return this.name;
	}
	
	public String getuserid() {
		return this.userid;
	}

	public String getPassword() {
		return this.password;
	}

	public LinkedList<CustomerDetail> getCustomerDetail() throws SQLException {
		
		return database.getCustomerList();
		
	}

	public LinkedList<OrderDetail> getOrderDetail() throws SQLException {
		
		return database.getOrderList();
		
	}

	public LinkedList<PendingOrder> getPendingOrder() throws SQLException {
		
		return database.getPendingOrderList();
	}

	public LinkedList<ProductDetail> getProductDetail() throws SQLException {

		return database.getProductList();
	}

}
