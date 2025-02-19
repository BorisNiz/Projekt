package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Odhlasovanie {

	@FXML
	private Button logoutButton;
	@FXML
	private AnchorPane logoutScene;
	

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void logout(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Odhlásiť sa");
		alert.setHeaderText("Idete sa odhlásiť");
		if(alert.showAndWait().get()== ButtonType.OK) {
			System.out.println("Úspešne ste boli odhlásení!");
			root = FXMLLoader.load(getClass().getResource("Prihlasenie.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
}
