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
import model.PendingOrder;
import model.User;

public class PendingOrderCon implements Initializable{

User user;
	
	@FXML
	Label usernameLabel;
	
	@FXML
	TableView<PendingOrder> pendingorderTable;
	
	@FXML
	TableColumn<PendingOrder, String> ordercode,totalprice,paidammount,dueammount,deliverydate;
	
	public PendingOrderCon(User user) {
		this.user=user;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		usernameLabel.setText(user.getuserid());
		try {
			pendingorderTable.setItems(FXCollections.observableList(user.getPendingOrder()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ordercode.setCellValueFactory(new PropertyValueFactory<PendingOrder, String>("ordercode"));
		totalprice.setCellValueFactory(new PropertyValueFactory<PendingOrder, String>("totalprice"));
		paidammount.setCellValueFactory(new PropertyValueFactory<PendingOrder, String>("paidamount"));
		dueammount.setCellValueFactory(new PropertyValueFactory<PendingOrder, String>("dueamount"));
		deliverydate.setCellValueFactory(new PropertyValueFactory<PendingOrder, String>("deliverydate"));
		
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
