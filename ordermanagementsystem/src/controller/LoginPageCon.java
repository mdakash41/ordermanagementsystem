package controller;


import java.io.IOException;

import application.Database;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.User;

public class LoginPageCon {
	
	User user =null;

	@FXML
	AnchorPane anchorPane;

	@FXML
	Label loginLable, usernameLabel, passwordLabel;

	@FXML
	TextField usernameTextField;

	@FXML
	PasswordField passwordPasswordField;

	@FXML
	Button loginButton, resetButton;

	@FXML
	public void login(ActionEvent event) {
		String query = "select * from login where username='" + usernameTextField.getText() + "' and password='"
				+ passwordPasswordField.getText() + "'";
		try {
			user = Database.queryonlogin(query);
			if(user!=null) {
				FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/homepage.fxml"));
				HomePageCon con=new HomePageCon(user);
				fxmlloader.setController(con);
				Main.showScene(new Scene(fxmlloader.load()));
			}
			else {
				usernameTextField.clear();
				passwordPasswordField.clear();
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void reset(ActionEvent event) {
		usernameTextField.clear();
		passwordPasswordField.clear();
	}

}
