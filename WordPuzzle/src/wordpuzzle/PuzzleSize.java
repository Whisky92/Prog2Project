package wordpuzzle;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class PuzzleSize {

	public static int size = 0;
	
	public static void display_PuzzleSize(Scene sc, Parent p)
	{
		int label1X = 500, label1Y = 200;
		int label2X = 100, label2Y = 300;
		int TFX = 850, TFY = 450;
		int TFW=200, TFH=100;
		int buttonX=800, buttonY=675;
		int buttonW=300, buttonH=100;
		
		Group PuzzleSize_layout = new Group();
		
		Font labelFont = new Font("Arial Black", 70);
		Font TFFont = new Font("Times New Roman", 60);
		
		Label puzzleSizeLabel1 = new Label("Írd be a szövegmezőbe,");
		Label puzzleSizeLabel2 = new Label("hogy milyen méretű táblán szeretnél játszani!");
		
		TextField puzzleSizeTF = new TextField();
		puzzleSizeTF.setLayoutX(TFX);
		puzzleSizeTF.setLayoutY(TFY);
		puzzleSizeTF.setPrefSize(TFW, TFH);
		puzzleSizeTF.setFont(TFFont);
		
		puzzleSizeLabel1.setLayoutX(label1X);
		puzzleSizeLabel1.setLayoutY(label1Y);
		
		puzzleSizeLabel2.setLayoutX(label2X);
		puzzleSizeLabel2.setLayoutY(label2Y); 
		
		puzzleSizeLabel1.setFont(labelFont);
		puzzleSizeLabel2.setFont(labelFont);
		
		Button puzzleSizeButton = new Button("Tovább");
		puzzleSizeButton.setLayoutX(buttonX);
		puzzleSizeButton.setLayoutY(buttonY);
		
		puzzleSizeButton.setPrefSize(buttonW, buttonH);
				
		Button puzzleSizeBackButton = SceneParameters.createBackButton();
		PuzzleSize_layout.getChildren().addAll(puzzleSizeLabel1, puzzleSizeLabel2, puzzleSizeTF, puzzleSizeButton,	 puzzleSizeBackButton);
		
		sc.setRoot(PuzzleSize_layout);
		
		puzzleSizeButton.setOnAction(e -> {
			
			String text = puzzleSizeTF.getText();
			if(puzzleSizeTF.getText()!="") {
			if(NumbCheck.check(puzzleSizeTF))
			{
				int number = Integer.parseInt(text);
				if(NumbCheck.checkFirstChar(text))
				{
					if(number>15 || number < 5)
					{
					   if(puzzleSizeLabel1.getLayoutX()!=100)
						  puzzleSizeLabel1.setLayoutX(100);
						puzzleSizeLabel1.setText("A szám a megfelelő intervallumon kívül esik!");
						if(PuzzleSize_layout.getChildren().contains(puzzleSizeLabel2))
							PuzzleSize_layout.getChildren().remove(puzzleSizeLabel2);
					}else {	
						size=number;
						Puzzle.display_Puzzle(sc, PuzzleSize_layout);
						if(puzzleSizeLabel1.getLayoutX()!=label1X)
							puzzleSizeLabel1.setLayoutX(label1X);
						if(puzzleSizeLabel1.getText()!="Írd be a szövegmezőbe,")
							puzzleSizeLabel1.setText("Írd be a szövegmezőbe,");
						if(!PuzzleSize_layout.getChildren().contains(puzzleSizeLabel2))
							PuzzleSize_layout.getChildren().add(puzzleSizeLabel2);
					}
				}else {
					if(puzzleSizeLabel1.getLayoutX()!=400)
						puzzleSizeLabel1.setLayoutX(400);
					puzzleSizeLabel1.setText("A szám nem kezdődhet 0-val!");
					if(PuzzleSize_layout.getChildren().contains(puzzleSizeLabel2))
						PuzzleSize_layout.getChildren().remove(puzzleSizeLabel2);
				}
				
			}else {
				puzzleSizeLabel1.setText("Számot adjon meg a szövegmezőben!");
				if(puzzleSizeLabel1.getLayoutX()!=300)
					puzzleSizeLabel1.setLayoutX(300);
				if(PuzzleSize_layout.getChildren().contains(puzzleSizeLabel2))
					PuzzleSize_layout.getChildren().remove(puzzleSizeLabel2);
			
			}
			}else {
				if(PuzzleSize_layout.getChildren().contains(puzzleSizeLabel2))
					PuzzleSize_layout.getChildren().remove(puzzleSizeLabel2);
				puzzleSizeLabel1.setText("Írjon be a egy számértéket a szövegmezőbe!");
				if(puzzleSizeLabel1.getLayoutX()!=100)
					puzzleSizeLabel1.setLayoutX(100);
			}
		});
		
		puzzleSizeBackButton.setOnAction( e -> {
			 sc.setRoot(p);
			 size=0;
			 Category.str.clear();
		});
		
	}
	
}