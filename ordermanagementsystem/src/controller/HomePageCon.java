package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.User;

public class HomePageCon implements Initializable{
	
	User user=null;
	
	@FXML
	Button logoutButton,customerlistButton,productlistButton,orderlistButton,pendingorderbutton;
	
	@FXML
	Label usernameLabel,welcomeLabel;
	
	public HomePageCon(User user){
		
		this.user=user;
		
	}
	
	
	@FXML
	private void  logout(ActionEvent event) {
		
		Parent root;
		try {
			user=null;
			root = FXMLLoader.load(getClass().getResource("/fxml/loginpage.fxml"));
			Main.showScene(new Scene(root));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	private void  customerList(ActionEvent event) {
		
		FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/customerdetail.fxml"));
		CustomerDetailCon con=new CustomerDetailCon(user);
		fxmlloader.setController(con);
		try {
			Main.showScene(new Scene(fxmlloader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void  productDetail(ActionEvent event) {
		
		FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/productdetail.fxml"));
		ProductDetailCon con=new ProductDetailCon(user);
		fxmlloader.setController(con);
		try {
			Main.showScene(new Scene(fxmlloader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void  orderList(ActionEvent event) {
		FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/orderdetail.fxml"));
		OrderDetailCon con=new OrderDetailCon(user);
		fxmlloader.setController(con);
		try {
			Main.showScene(new Scene(fxmlloader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void  PendingOrder(ActionEvent event) {
		FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/pendingorder.fxml"));
		PendingOrderCon con=new PendingOrderCon(user);
		fxmlloader.setController(con);
		try {
			Main.showScene(new Scene(fxmlloader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		welcomeLabel.setText("Welcome  "+user.getName());
		usernameLabel.setText(user.getuserid());
		
	}
	

}
