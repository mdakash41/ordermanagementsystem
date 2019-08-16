package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.CustomerDetail;
import model.*;

public class Database {

	private ResultSet results;
	private Connection connection;
	private Statement statement;

	public Database() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:doc.jub");
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static User queryonlogin(String query) throws ClassNotFoundException {

		User user = null;
		ResultSet resultSet = null;
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:doc.jub");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				String name, id, pass;
				name = resultSet.getString(1);
				id = resultSet.getString(2);
				pass = resultSet.getString(3);
				user = new User(name, id, pass);
			}

		}

		catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("one");
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (final SQLException e) {
				System.out.println(e);
				System.out.println("Two");
			}
		}
		return user;
	}

	public LinkedList<CustomerDetail> getCustomerList() throws SQLException {

		LinkedList<CustomerDetail> customers = new LinkedList<CustomerDetail>();
		String query = "select * from customerdetail";
		results = statement.executeQuery(query);
		while (results.next()) {
			String name = results.getString("customername");
			String email = results.getString("email");
			String address = results.getString("address");
			long num = results.getInt("phonenumber");
			customers.add(new CustomerDetail(name, email, address, num));
		}
		return customers;
	}

	public LinkedList<OrderDetail> getOrderList() throws SQLException {

		LinkedList<OrderDetail> orders = new LinkedList<OrderDetail>();
		String query = "select * from orderlist";
		results = statement.executeQuery(query);
		while (results.next()) {
			int orderCode = results.getInt(1);
			int productid = results.getInt(3);
			long customerNumber = results.getInt(2);
			String orderDate = results.getString(4);
			String deliveryDate = results.getString(5);
			String deliverd=results.getString(6);
			int price = results.getInt(7);
			orders.add(new OrderDetail(orderCode, productid, customerNumber, orderDate, deliveryDate, deliverd,price));
		}

		
		return orders;
	}
	
	public LinkedList<ProductDetail> getProductList() throws SQLException {

		LinkedList<ProductDetail> products = new LinkedList<ProductDetail>();
		String query = "select * from productdetail";
		results = statement.executeQuery(query);
		while (results.next()) {
			int productserial = results.getInt("productsl");
			String brand = results.getString("brand");
			String productmodel = results.getString("p_model");
			String producttype = results.getString("p_type");
			String productdetail = results.getString("p_details");
			products.add(new ProductDetail(productserial,brand,productmodel,producttype,productdetail));
		}

		return products;
	}
	
	public LinkedList<PendingOrder> getPendingOrderList() throws SQLException {

		LinkedList<PendingOrder> products = new LinkedList<PendingOrder>();
		String query = "select * from pendingorder";
		results = statement.executeQuery(query);
		while (results.next()) {
			int ordercode = results.getInt(1);
			int totalprice = results.getInt(2);
			int paidamount = results.getInt(3);
			int dueamount = results.getInt(4);
			String deliverydate = results.getString(5);
			products.add(new PendingOrder(ordercode,totalprice,paidamount,dueamount,deliverydate));
		}

		return products;
	}
	
	

}
