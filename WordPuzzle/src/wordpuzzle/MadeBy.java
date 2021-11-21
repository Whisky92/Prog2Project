package wordpuzzle;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MadeBy {
	
	public static void display_MadeBy(Scene sc, Parent p)
	{
		int labelX1=550, labelX2=720, labelX3=750;
		int labelY1=400, labelY2=550, labelY3=650;
		int labelSize1=150, labelSize2=100;
		
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
		
		madeByText1.setFont(new Font("Cooper Black", labelSize1));
		madeByText1.setUnderline(true);
		
		madeByText2.setFont(new Font("Times New Roman", labelSize2));
		madeByText3.setFont(new Font("Times New Roman", labelSize2));
		
		Button madeByBack =SceneParameters.createBackButton();
		
		madeByLayout.getChildren().addAll(madeByText1, madeByText2, madeByText3, madeByBack);	
		
		madeByBack.setOnAction(e -> 
		{
			sc.setRoot(p);
		});
		
		sc.setRoot(madeByLayout);
		
		
		
	}

}
