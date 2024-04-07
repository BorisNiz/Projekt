package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Parent;
import java.io.File;

public class Main extends Application {
	

	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Prihlasenie.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("OREO");
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(event -> {
				event.consume();
				logout(stage);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout(Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Zavrieť aplikáciu");
		alert.setHeaderText("Naozaj sa chcete zavrieť aplikáciu?");
		if(alert.showAndWait().get()== ButtonType.OK) {
		System.out.println("Aplikácie bola úspešne zatvorená!");
        File file = new File("vysledky.txt");
        if (file.exists()) {
            file.delete();
        }
		stage.close();
		}
	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
