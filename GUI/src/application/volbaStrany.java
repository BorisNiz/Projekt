package application;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class volbaStrany implements Initializable{

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private ComboBox<String> Strana;

	private String[] strany = {"Protismer","1%","POSKOK!"}; 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Strana.getItems().addAll(strany);
		
	}
	
	public void getStrana(ActionEvent event) throws IOException {
		String Strany = Strana.getValue();
		
		if (Strany == "Protismer") {
			switchToKandidat(event);
		}
		else if (Strany == "1%") {
			switchToKandidat1(event);
		}
		else if (Strany == "POSKOK!") {
			switchToKandidatPoskok(event);
		}
		else {
			
		}
	}



	public void switchToKandidat(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Kandidat.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToKandidat1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToKandidatPoskok(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Poskok.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	

}
