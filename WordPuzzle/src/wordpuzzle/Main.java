package wordpuzzle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage window;
	Scene primaryScene;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		int sceneW=1920, sceneH=1015;
		int labelX = 500, labelY=200;
		int sButtonX=800, sButtonY=500;
		int mButtonX=800, mButtonY= 625;
		int ButtonW=300, ButtonH=100;
		int labelSize=170;
		
		String s ="START";
		
		window = primaryStage;
		Group primaryLayout = new Group();

		Button startButton = new Button(s);
		startButton.setLayoutX(sButtonX);
		startButton.setLayoutY(sButtonY);
		startButton.setPrefSize(ButtonW, ButtonH);
		
		
		Button madeByButton = new Button("Készítette");
		madeByButton.setLayoutX(mButtonX);
		madeByButton.setLayoutY(mButtonY);
		madeByButton.setPrefSize(ButtonW, ButtonH);
		
		Image icon = new Image("w.png");
		window.getIcons().add(icon);
		window.setFullScreen(false);
		
		Font startFont = new Font("Times New Roman", labelSize);
		
		primaryScene = new Scene(primaryLayout, sceneW, sceneH);

		window.setScene(primaryScene);
		window.setTitle("Word Puzzle");	
		
		window.setResizable(false);
		window.setFullScreen(false);
		
		Label startLabel = new Label("Word Puzzle");
		startLabel.setLayoutX(labelX);
		startLabel.setLayoutY(labelY);
		startLabel.setFont(startFont);
		
		primaryLayout.getChildren().addAll(startLabel, startButton, madeByButton);
		window.show();
		
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();	
		});
		
		madeByButton.setOnAction(e -> 
		{
			MadeBy.display_MadeBy(window, primaryScene);
		});	
		
	}
		
	public void closeProgram() {
		boolean answer = ConfirmBox.display("Kilépés", "Tényleg ki akarsz lépni?");
		if(answer)
			window.close();
	}

}
