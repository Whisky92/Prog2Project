package main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	Button button;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("C�m");
		button = new Button();
		button.setText("Ez egy gomb");
		button.setOnAction(e -> System.out.println("asde"));
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout,1024,768);
		
		stage.setScene(scene);
		stage.show();
	}
	

}


