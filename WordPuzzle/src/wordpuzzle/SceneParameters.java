package wordpuzzle;

import javafx.scene.control.Button;

public class SceneParameters {
	static int SceneW = 1920;
	static int SceneH = 1015;
	
	static Button createBackButton()
	{
	
		int buttonW=300, buttonH=100;
		int buttonX=800, buttonY=800;
	
		Button back = new Button("Vissza az előző oldalra");
		back.setLayoutX(buttonX);
		back.setLayoutY(buttonY);
		back.setPrefSize(buttonW, buttonH);
	
	
		return back;
	}
}