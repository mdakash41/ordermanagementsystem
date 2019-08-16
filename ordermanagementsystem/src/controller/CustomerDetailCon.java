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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerDetail;
import model.User;

public class CustomerDetailCon implements Initializable{
	
	User user;
	
	@FXML
	Label usernameLabel;
	
	@FXML
	TableView<CustomerDetail> customerTable;
	
	@FXML
	TableColumn<CustomerDetail, String> name,phonenumber,email,address;
		
	@FXML
	TextField phonenumberTextField,emailTextField,addressTextField,addcustomerButton;
	
	public CustomerDetailCon(User user) {
		this.user=user;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		usernameLabel.setText(user.getuserid());
		try {
			customerTable.setItems(FXCollections.observableList(user.getCustomerDetail()));
			name.setCellValueFactory(new PropertyValueFactory<CustomerDetail, String>("name"));
			phonenumber.setCellValueFactory(new PropertyValueFactory<CustomerDetail, String>("phoneNumber"));
			email.setCellValueFactory(new PropertyValueFactory<CustomerDetail, String>("email"));
			address.setCellValueFactory(new PropertyValueFactory<CustomerDetail, String>("address"));
			
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
	
	
	@FXML
	public void add(ActionEvent event) {
		System.out.println("added user");
	}


}
