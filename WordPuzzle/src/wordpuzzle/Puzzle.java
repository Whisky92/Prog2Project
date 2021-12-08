package wordpuzzle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Puzzle {
	
	private static LinkedList<String> wrd = new LinkedList<>();
	
	public static Labels array[][];

	public static void display_Puzzle(Stage win, Scene sc, Parent p){
		
		Group puzzleLayout=new Group();
		ArrayList<Text> wordArray = new ArrayList<>();
		
		 EventHandler<MouseDragEvent> eventHandler = new EventHandler<MouseDragEvent>() {
			 
			EventTarget tPrevious=null ,tCurrent;
			int overcount=0, startcount=0;
			
			Label l, l1;
			String s;
			Text t;
			int rn=0, cn=0, prevrn=0, prevcn=0;
			int ccount=0;
			String type="";
			boolean correct=true;
			LinkedList<Integer> rns= new LinkedList<>();
			LinkedList<Integer> cns= new LinkedList<>();
			@Override
			public void handle(MouseDragEvent event) {
				if(event.getEventType()==MouseDragEvent.MOUSE_DRAG_ENTERED) {
					if(startcount==0)
					{
						if(event.getTarget().getClass()==Label.class)
						{
							l=(Label)(event.getTarget());
							l.setStyle("-fx-border-color: black; -fx-background-color: yellow");
							s=l.getText();
							for(int i=0;i<PuzzleSize.size;i++) {
								for(int j=0;j<PuzzleSize.size;j++) {
									if(puzzleLayout.getChildren().indexOf(l)==puzzleLayout.getChildren().indexOf(array[i][j].lab))
									{
										rn=array[i][j].rowNumb;
										cn=array[i][j].colNumb;
										rns.add(rn);
										cns.add(cn);
									}
								}
							}
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
							l1.setStyle("-fx-border-color: black; -fx-background-color: yellow");
							s+=l1.getText();
							for(int i=0;i<PuzzleSize.size;i++) {
								for(int j=0;j<PuzzleSize.size;j++) {
									if(puzzleLayout.getChildren().indexOf(l1)==puzzleLayout.getChildren().indexOf(array[i][j].lab))
									{
										if(correct) {
										prevrn=rn;
										prevcn=cn;
										ccount++;
										rn=array[i][j].rowNumb;
										cn=array[i][j].colNumb;
										if(ccount==1)
										{
											if(rn==(prevrn+1) && cn == prevcn)
											{
												type="vertical";
											}
											else if(rn==prevrn && cn ==(prevcn+1))
											{
												type="horizontal";
											}
											else
											{
												correct=false;
											}
										}
										if(ccount==1 && correct)
										{
											rns.add(rn);
											cns.add(cn);
										}
										if(ccount>1)
										{
											if(type.equals("vertical"))
											{
												if(rn==(prevrn+1) && cn == prevcn)
												{
													rns.add(rn);
													cns.add(cn);
												}
												else
												{
													correct=false;
												}
											}else if(type.equals("horizontal"))
											{
												if(rn==prevrn && cn ==(prevcn+1))
												{
													rns.add(rn);
													cns.add(cn);
												}
												else
												{
													correct=false;
												}
											}
										}
									}
									}
								}
							}
							
							
						}
					}
					overcount++;
					tPrevious=tCurrent;
					}
				}
				if(event.getEventType()==MouseDragEvent.MOUSE_DRAG_RELEASED)
				{
					for(int i=0;i<PuzzleSize.size;i++)
					{
						for(int j=0;j<PuzzleSize.size;j++)
						{
							if(array[i][j].lab.backgroundProperty().getValue().toString().equals("javafx.scene.layout.Background@c6f3c682"))
								array[i][j].lab.setStyle("-fx-border-color: black; -fx-background-color: lightblue");
						}
					}

					if(correct) {
						for(Words w : PlacingWords.wrds)
						{
							if(type.equals("vertical"))
							{
								if(w.word.equals(s) && w.Rcoords.equals(rns) && w.Ccoords.get(0)==cns.get(0))
								{
									if(!wrd.contains(s) && wrd.size()< PlacingWords.wrds.length)
									{
										for(int i=0;i<wordArray.size();i++)
										{
											if(wordArray.get(i).getText().toString().equals(s))
											{
												wordArray.get(i).setOpacity(0.3);
												wordArray.get(i).setStrikethrough(true);
												wrd.add(s);
											}
										}
										if(wrd.size() == PlacingWords.wrds.length)
											Victory.display(win);
									}
								}
							}
							else
							{
								if(w.word.equals(s) && w.Ccoords.equals(cns) && w.Rcoords.get(0)==rns.get(0))
								{
									if(!wrd.contains(s) && wrd.size()< PlacingWords.wrds.length)
									{
										for(int i=0;i<wordArray.size();i++)
										{
											if(wordArray.get(i).getText().toString().equals(s))
											{
												wordArray.get(i).setOpacity(0.3);
												wordArray.get(i).setStrikethrough(true);
												wrd.add(s);
											}
										}
										if(wrd.size() == PlacingWords.wrds.length)
											Victory.display(win);
									}
								}
							}
						}
					}
					ccount=0;
					rn=0;
					cn=0;
					prevrn=0;
					prevcn=0;
					rns.clear();
					cns.clear();
					correct=true;
					overcount=0;
					startcount=0;

					
				}
		 }
		};
				
		
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
				char c = RandGen.gen();
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
		ArrayList<Text> lengthArray = new ArrayList<>();

		
		int c = 0;
		int unit = 20;
		int padding=2;
		int YPOS=150;
		int XPOS;
						
		
		
		for(int i=0; i<lengths.size();i++)
		{
			s=lengths.get(i) + " betűs szavak";
			lengthArray.add(new Text(s));
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
				wordArray.add(new Text(PlacingWords.words.get(j)));
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
