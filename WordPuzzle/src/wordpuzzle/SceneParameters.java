package wordpuzzle;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class SceneParameters {
	static int SceneW = 1920;
	static int SceneH = 1015;
	
	static Button createBackButton(Group g)
	{
		
		int buttonW=300, buttonH=100;
		int buttonX=800, buttonY=800;
		
		Button back = new Button("Vissza az elözö oldalra");
		back.setLayoutX(buttonX);
		back.setLayoutY(buttonY);
		back.setPrefSize(buttonW, buttonH);
		
		g.getChildren().add(back);
		
		return back;
	}

	static Button createBackButton(Pane p)
	{
	
		int buttonW=300, buttonH=100;
		int buttonX=800, buttonY=800;
	
		Button back = new Button("Vissza az elözö oldalra");
		back.setLayoutX(buttonX);
		back.setLayoutY(buttonY);
		back.setPrefSize(buttonW, buttonH);
	
		p.getChildren().add(back);
	
		return back;
	}
}