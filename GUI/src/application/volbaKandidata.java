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

public class volbaKandidata implements Initializable{

	private Stage stage;
	private Scene scene;
	private Parent root;

	
	@FXML
	private ComboBox<String> ProtismerKandidat;

	private String[] ProtismerKandidati = {"Sanko Pedryk","Vice Pedryk","Ashvaldo","Ifmožeš","Nikol"}; 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ProtismerKandidat.getItems().addAll(ProtismerKandidati);
	}
	
    public void Vypis(ActionEvent event) throws IOException {
        String protismerKandidati = ProtismerKandidat.getValue();
        if (protismerKandidati == null) {
        	switchToKandidat(event);
        }
        else {
            try {
            	FileWriter writer = new FileWriter("vysledky.txt",true); 
            	writer.write(protismerKandidati+"\n");
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
	public void switchToKandidat(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Kandidat.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
