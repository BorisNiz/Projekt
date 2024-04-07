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

public class kandidat1 implements Initializable{

	private Stage stage;
	private Scene scene;
	private Parent root;

	
	@FXML
	private ComboBox<String> Kandidat1;

	private String[] kandidati1 = {"Pán Novák","Zuzana Černá","Kohutik Jarabý","Pavol Novotný","Martin Šimko"}; 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Kandidat1.getItems().addAll(kandidati1);
	}
	
    public void Vypis(ActionEvent event) throws IOException {
        String kan_1 = Kandidat1.getValue();
        if (kan_1 == null) {
        	switchToKandidat1(event);
        }
        else {
            try {
            	FileWriter writer = new FileWriter("vysledky.txt",true); 
            	writer.write(kan_1+"\n");
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
	
	public void switchToKandidat1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
