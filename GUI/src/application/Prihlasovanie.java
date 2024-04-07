package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class Prihlasovanie {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML 
	private PasswordField login;
	
    private boolean login1 = StavPrihlasenia.getInstance().isLogin1();
    private boolean login2 = StavPrihlasenia.getInstance().isLogin2();
    private boolean login3 = StavPrihlasenia.getInstance().isLogin3();
	

	
	public void LogIn(ActionEvent event) throws IOException{
        int heslo = Integer.parseInt(login.getText());
        if (heslo == 12345) {
            if (login1) {
                System.out.println("Už ste hlasovali");
            } else {
                login1 = true; 
                StavPrihlasenia.getInstance().setLogin1(true);
                switchToStrana(event);
            }
        }
        else if (heslo == 67890) {
            if (login2) {
                System.out.println("Už ste hlasovali");
            } else {
                login2 = true; 
                StavPrihlasenia.getInstance().setLogin2(true);
                switchToStrana(event);
            }
        }
        else if (heslo == 123456789) {
            if (login3) {
                System.out.println("Už ste hlasovali");
            } else {
                login3 = true; 
                StavPrihlasenia.getInstance().setLogin3(true);
                switchToStrana(event);
            }
        }
        else {
            System.out.println("Zadali ste nespárvne heslo");
        }
    }

	public void switchToStrana(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Strana.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
