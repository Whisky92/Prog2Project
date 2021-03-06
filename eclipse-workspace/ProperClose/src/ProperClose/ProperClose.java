package ProperClose;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ProperClose extends Application{
	
	Stage window;
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Megyen a cim");
		
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();	
		});
		 
		button = new Button("Bez?r?s");
		button.setOnAction(e -> closeProgram());
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 1024, 768);
		window.setScene(scene);
		window.show();
		
	}
	
	private void closeProgram() {
		boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
		if(answer)
			window.close();
	}
	
}