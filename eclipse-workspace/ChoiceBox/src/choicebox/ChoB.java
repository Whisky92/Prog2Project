package choicebox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoB extends Application {

	Stage window;
	Scene scene;
	Button button;
		
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window=primaryStage;
		window.setTitle("ChoiceBox Demo");
		
		button = new Button("Click me");
		
		ChoiceBox<String> choicebox = new ChoiceBox<>();
		choicebox.getItems().add("Apples");
		choicebox.getItems().add("Banana");
		choicebox.getItems().addAll("Bacon","Ham","Meatball");
		choicebox.setValue("Bacon");
		
		//choicebox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue));
		choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {System.out.println(arg0);};
		});
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.getChildren().addAll(choicebox, button);
		
		scene = new Scene(layout, 1024, 768);
		window.setScene(scene);
		window.show();
		
		
	}


}
