package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	private static Stage stage;
	public Main() {
		stage=new Stage();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {	
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginpage.fxml"));
			showScene(new Scene(root));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showScene(Scene scene) {
		stage.setScene(scene);
		stage.setHeight(700);
		stage.setWidth(1100);
		stage.show();
		
	}
}



