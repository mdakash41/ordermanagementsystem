package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.OrderDetail;
import model.User;

public class OrderDetailCon implements Initializable{
	
	User user;
	
	@FXML
	Label usernameLabel;
	
	@FXML
	TableView<OrderDetail> orderTable;
	
	@FXML
	TableColumn<OrderDetail, String> ordercode,customernumber,productid,orderdate,deliverydate,delivered,price;

	
	public OrderDetailCon(User user) {
		this.user=user;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		usernameLabel.setText(user.getuserid());
		try {
			orderTable.setItems(FXCollections.observableList(user.getOrderDetail()));
			ordercode.setCellValueFactory(new PropertyValueFactory<OrderDetail, String>("orderCode"));
			customernumber.setCellValueFactory(new PropertyValueFactory<OrderDetail, String>("customerNumber"));
			productid.setCellValueFactory(new PropertyValueFactory<OrderDetail, String>("productid"));
			orderdate.setCellValueFactory(new PropertyValueFactory<OrderDetail, String>("orderDate"));
			deliverydate.setCellValueFactory(new PropertyValueFactory<OrderDetail, String>("deliveryDate"));
			delivered.setCellValueFactory(new PropertyValueFactory<OrderDetail, String>("deliverd"));
			price.setCellValueFactory(new PropertyValueFactory<OrderDetail, String>("price"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void logout(ActionEvent event) {
		try {
			user=null;
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginpage.fxml"));
			Main.showScene(new Scene(root));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void home(ActionEvent event) {
		FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/homepage.fxml"));
		HomePageCon con=new HomePageCon(user);
		fxmlloader.setController(con);
		try {
			Main.showScene(new Scene(fxmlloader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
