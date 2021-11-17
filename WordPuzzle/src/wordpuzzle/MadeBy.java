package wordpuzzle;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MadeBy {
	
	public static void display_MadeBy(Stage s, Scene sc)
	{
		int labelX1=650, labelX2=720, labelX3=750;
		int labelY1=400, labelY2=550, labelY3=650;
		int labelSize1=150, labelSize2=100;
		int buttonW=300, buttonH=100;
		int buttonX=800, buttonY=800;
		
		Group madeByLayout= new Group();
		
		Text madeByText1=new Text("Készítette:");
		Text madeByText2=new Text("Oláh Tamás");
		Text madeByText3=new Text("NE5E1M");
		
		madeByText1.setLayoutX(labelX1);
		madeByText2.setLayoutX(labelX2);
		madeByText3.setLayoutX(labelX3);
		
		madeByText1.setLayoutY(labelY1);
		madeByText2.setLayoutY(labelY2);
		madeByText3.setLayoutY(labelY3);
		
		madeByText1.setFont(new Font("Times New Roman", labelSize1));
		madeByText1.setUnderline(true);;
		
		madeByText2.setFont(new Font("Times New Roman", labelSize2));
		madeByText3.setFont(new Font("Times New Roman", labelSize2));
		
		Button back = new Button("Vissza az elözö oldalra");
		back.setLayoutX(buttonX);
		back.setLayoutY(buttonY);
		back.setPrefSize(buttonW, buttonH);
		
		madeByLayout.getChildren().addAll(madeByText1, madeByText2, madeByText3, back);		
		
		back.setOnAction(e -> s.setScene(sc));
		
		Scene madeByScene= new Scene(madeByLayout, 1920, 1015);
		s.setScene(madeByScene);
		
		
		
	}

}
