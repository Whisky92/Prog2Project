package wordpuzzle;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Puzzle {
	
	public static Labels array[][];
	
	public static void display_Puzzle(Scene sc, Parent p){
		
		Group puzzleLayout = new Group();
		int tempSize = 9;
		int size = 1000;
		double tableXMin = 100, tableXMax = 1100;
		double tableYMin = (SceneParameters.SceneH-size)/2;
		double buttonSize = (tableXMax-tableXMin)/tempSize;

		array = new Labels[tempSize][tempSize];
		int a =0;		
		
		Font labFont=new Font("Times New Roman",(int)(buttonSize/2));
		
		for(int i=0;i<tempSize;i++) {
			for(int j=0;j<tempSize;j++) {
				a++;
				array[i][j]=new Labels(new Label(), a, i, j);
				array[i][j].lab.setLayoutX(tableXMin+j*buttonSize);
				array[i][j].lab.setLayoutY(tableYMin+i*buttonSize);
				array[i][j].lab.setPrefSize(buttonSize, buttonSize);
				array[i][j].lab.setFont(labFont);
				array[i][j].lab.setStyle("-fx-border-color: black; -fx-background-color: lightblue;");
				array[i][j].lab.setAlignment(Pos.CENTER);
				puzzleLayout.getChildren().add(array[i][j].lab);
			}
		}
		
		for(int i=0;i<tempSize;i++) {
			for(int j=0;j<tempSize;j++) {
			//	char c = RandGen.gen();
				char c = '-';
				String s = Character.toString(c);
				array[i][j].lab.setText(s);
			}
			System.out.println();
		}
		
		PlaceWords.place();
		
		sc.setRoot(puzzleLayout);
	}

}
