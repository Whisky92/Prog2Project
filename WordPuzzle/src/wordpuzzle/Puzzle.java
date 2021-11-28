package wordpuzzle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Puzzle {
	
	public static Labels array[][];

	public static void display_Puzzle(Scene sc, Parent p){
		
		
		 EventHandler<MouseDragEvent> eventHandler = new EventHandler<MouseDragEvent>() {
			 
			EventTarget tPrevious=null ,tCurrent;
			int overcount=0, startcount=0;
			Label l, l1;
			String s;
			Text t;
			
			@Override
			public void handle(MouseDragEvent event) {
				if(event.getEventType()==MouseDragEvent.MOUSE_DRAG_ENTERED) {
					if(startcount==0)
					{
						if(event.getTarget().getClass()==Label.class)
						{
							l=(Label)(event.getTarget());
							s=l.getText();
						}else if(event.getTarget().getClass()==Text.class) {
							t=(Text)(event.getTarget());
							s=t.toString();
						}
						//System.out.print(s);
					}
					startcount++;
				}
				if(event.getEventType()==MouseDragEvent.MOUSE_DRAG_OVER)
				{
					tCurrent=event.getTarget();
					if(event.getTarget().getClass()==Label.class)
					{
					if(overcount>0) {
						if(tCurrent!=tPrevious) {
							overcount=0;
							l1=(Label)(event.getTarget());
							s+=l1.getText();
							
							
						}
					}
					overcount++;
					tPrevious=tCurrent;
					}
				}
				if(event.getEventType()==MouseDragEvent.MOUSE_DRAG_RELEASED)
				{
					overcount=0;
					startcount=0;
					System.out.println(s);
				}
		 }
		};
		
		
		
		
		
		
		Group puzzleLayout = new Group();
		int tempSize = PuzzleSize.size;
		int size = 1000;
		double tableXMin = 100, tableXMax = 1100;
		double tableYMin = (SceneParameters.SceneH-size)/2;
		double buttonSize = (tableXMax-tableXMin)/tempSize;

		array = new Labels[tempSize][tempSize];
		int a =0;		
		
		Font labFont=new Font("Times New Roman",(int)(buttonSize/2));
		
		for(int i=0;i<tempSize;i++) {
			for(int j=0;j<tempSize;j++) {
				int i_v=i, j_v=j;
				a++;
				array[i][j]=new Labels(new Label(), a, i, j);
				array[i][j].lab.setLayoutX(tableXMin+j*buttonSize);
				array[i][j].lab.setLayoutY(tableYMin+i*buttonSize);
				array[i][j].lab.setPrefSize(buttonSize, buttonSize);
				array[i][j].lab.setFont(labFont);
				array[i][j].lab.setStyle("-fx-border-color: black; -fx-background-color: lightblue;");
				array[i][j].lab.setAlignment(Pos.CENTER);
				array[i][j].lab.addEventHandler(MouseEvent.DRAG_DETECTED, e ->
				{
					array[i_v][j_v].lab.startFullDrag();
					
				});
				array[i][j].lab.addEventHandler(MouseDragEvent.ANY, eventHandler);
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
		
		PlacingWords.place();
		
		int lX= (int)(tableXMax) + 100, lY = 100;
		
		Label l = new Label("Hátralévő szavak:");
		l.setLayoutX(lX);
		l.setLayoutY(lY);
		l.setFont(new Font("Arial Black", 40));
		l.setUnderline(true);
		puzzleLayout.getChildren().addAll(l);
		
		ArrayList<Integer> lengths = new ArrayList<>();
		for(String x : PlacingWords.words)
		{
			if(!lengths.contains(x.length()))
				lengths.add(x.length());
		}
		System.out.println();
		Collections.sort(lengths);
		Collections.sort(PlacingWords.words,Comparator.comparing(String::length));

		String s="";
		ArrayList<Label> lengthArray = new ArrayList<>();
		ArrayList<Label> wordArray = new ArrayList<>();
		
		int c = 0;
		int unit = 20;
		int padding=2;
		int YPOS=150;
		int XPOS;
						
		
		
		for(int i=0; i<lengths.size();i++)
		{
			s=lengths.get(i) + " betűs szavak";
			lengthArray.add(new Label(s));
			lengthArray.get(i).setFont(new Font("Arial",unit));
			lengthArray.get(i).setUnderline(true);
			lengthArray.get(i).setLayoutY(YPOS);
			XPOS=lX;
			lengthArray.get(i).setLayoutX(XPOS);
			puzzleLayout.getChildren().add(lengthArray.get(i));
			YPOS=YPOS+padding+unit;
			for(int j=0;j<PlacingWords.words.size();j++)
			{
			if(PlacingWords.words.get(j).length()==lengths.get(i)) {
				wordArray.add(new Label(PlacingWords.words.get(j)));
				wordArray.get(j).setLayoutY(YPOS);
				XPOS=1500 - PlacingWords.words.get(j).length()*10;
				wordArray.get(j).setLayoutX(XPOS);
				wordArray.get(j).setFont(new Font("Times New Roman",unit));
				YPOS=YPOS+padding+unit;
				puzzleLayout.getChildren().add(wordArray.get(j)); 
			}
			}
		}
		

		sc.setRoot(puzzleLayout);
	}

}
