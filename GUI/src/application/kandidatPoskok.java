package application;

import java.io.FileWriter;
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

public class kandidatPoskok implements Initializable{

	private Stage stage;
	private Scene scene;
	private Parent root;

	
	@FXML
	private ComboBox<String> KandidatPoskok;

	private String[] kandidatiPoskok = {"Martin Žalab","Dneis Bratko","Maximus Trovmus","Boris Botomtekst","Martin Kroxer"}; 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		KandidatPoskok.getItems().addAll(kandidatiPoskok);
		}
	
    public void Vypis(ActionEvent event) throws IOException {
        String kandidatiPoskok = KandidatPoskok.getValue();
        if (kandidatiPoskok== null) {
        	switchToKandidatPoskok(event);
        }
        else {
            try {
            	FileWriter writer = new FileWriter("vysledky.txt",true); 
            	writer.write(kandidatiPoskok+"\n");
            	writer.close();
            }
            catch (IOException e) {
            	e.printStackTrace();
            }
        switchToOdhlasenie(event);
        }
        
 }
	
	public void switchToOdhlasenie(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Odhlasenie.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToStrana(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Strana.fxml"));
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
