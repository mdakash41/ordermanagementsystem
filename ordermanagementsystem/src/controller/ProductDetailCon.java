package controller;

import java.io.IOException;
import java.net.URL;
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
import model.ProductDetail;
import model.User;

public class ProductDetailCon implements Initializable{
	
	User user;
	
	@FXML
	Label usernameLabel;
	
	@FXML
	TableView<ProductDetail> productTable;
	
	@FXML
	TableColumn<ProductDetail, String> productSerial,productBrand,productModel,productType,productDetail;
	
	public ProductDetailCon(User user) {
		this.user=user;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		usernameLabel.setText(user.getuserid());
		try {
			productTable.setItems(FXCollections.observableList(user.getProductDetail()));
			productSerial.setCellValueFactory(new PropertyValueFactory<ProductDetail, String>("productserial"));
			productBrand.setCellValueFactory(new PropertyValueFactory<ProductDetail, String>("brand"));
			productModel.setCellValueFactory(new PropertyValueFactory<ProductDetail, String>("productmodel"));
			productType.setCellValueFactory(new PropertyValueFactory<ProductDetail, String>("producttype"));
			productDetail.setCellValueFactory(new PropertyValueFactory<ProductDetail, String>("productdetail"));
		} catch (Exception e) {
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
