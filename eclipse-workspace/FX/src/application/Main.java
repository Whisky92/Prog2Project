package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, Color.BLACK);
		//Image ic= new Image("asd.jpg");
		
		stage.setWidth(1024);
		stage.setHeight(768);
		stage.setResizable(false);
		stage.setX(0);
		stage.setY(0);
		stage.setFullScreen(true);
		//stage.setFullScreenExitHint("press o");
		//stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("o"));
		//stage.getIcons().add(ic);
		stage.setTitle("Mindig nagyon megyen");
		stage.setScene(scene);
		stage.show();		
	}
}
