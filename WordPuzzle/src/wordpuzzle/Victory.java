package wordpuzzle;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Victory {
	
	public static void display(Stage win) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("NYERTÉL!");		
		Label label = new Label();
		label.setFont(new Font("Arial Black", 50));
		label.setText("Gratulálunk, nyertél!");

		Button victoryButton = new Button("Kilépés");
		
		Image iconImg = new Image("victory.png");
		
		victoryButton.setOnAction(e -> 
		{
			window.close();
			win.close();
		});
		window.setOnCloseRequest(e ->{
			window.close();
			win.close();
		});
		
		VBox layout = new VBox(30);
		layout.getChildren().addAll(label, victoryButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 700, 200);
		window.getIcons().add(iconImg);
		window.setScene(scene);
		window.showAndWait();
		
	}

}