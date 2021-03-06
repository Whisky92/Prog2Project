package wordpuzzle;

import java.util.LinkedList;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Category {
	
	private static ListView<Text> categoryLV = new ListView<>();
	public static LinkedList<String> str = new LinkedList<>();
	private static int count=0;
	private static int zerocount = 0;
	
	public static void display_Category(Stage win, Scene sc, Parent p)
	{
		Text message=new Text();
		Group Category_layout = new Group();
		String mesg="Jelenleg kiválasztva: ";
		
		int catLVW=1920, catLVH=270;
		int catLVY=300;
		int labelX=0, labelY=100;
		int label2X=200, label2Y= 190;
		int buttonX=800, buttonY=675;
		int buttonW=300, buttonH=100;
		
		Font LFont = new Font("Arial Black", 53);	
		
		Label categoryLabel = new Label("Válaszd ki a kategóriát/ kategóriákat, amikből szavakat szeretnél!");
		Label categoryLabel2= new Label("A Ctrl billentyű lenyomásával lehet többet választani!");
		categoryLabel2.setFont(LFont);
		categoryLabel.setFont(LFont);
		
		categoryLabel.setLayoutX(labelX);
		categoryLabel.setLayoutY(labelY);
		
		categoryLabel2.setLayoutX(label2X);
		categoryLabel2.setLayoutY(label2Y);

		
		Font LVFont = new Font("Times New Roman", 43);
		
		Text cat1 = new Text("Gyümölcsök - zöldségek");
		Text cat2 = new Text("Emlősök");
		Text cat3 = new Text("Madarak");
		Text cat4 = new Text("Folyók");
		Text cat5 = new Text("Városok");
		
		cat1.setFont(LVFont);
		cat2.setFont(LVFont);
		cat3.setFont(LVFont);
		cat4.setFont(LVFont);
		cat5.setFont(LVFont);
		
		
		
		categoryLV.setPrefSize(catLVW, catLVH);
		
		categoryLV.getItems().addAll(cat1, cat2, cat3, cat4, cat5);
		categoryLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		categoryLV.setLayoutY(catLVY);
		

		Button categoryButton = new Button("Tovább");
		categoryButton.setLayoutX(buttonX);
		categoryButton.setLayoutY(buttonY);
		categoryButton.setPrefSize(buttonW, buttonH);
		
		
		Button categoryBackButton= SceneParameters.createBackButton();
		
		
		Category_layout.getChildren().addAll(categoryLabel,categoryLabel2,categoryLV,categoryButton, categoryBackButton);
		
		
		sc.setRoot(Category_layout);
		
		categoryBackButton.setOnAction(e ->
		{	
			count=0;
			sc.setRoot(p);
			str.clear();
			categoryLV.getSelectionModel().clearSelection();
			Category_layout.getChildren().clear();
		});
		
		
	categoryLV.setOnMouseClicked(e ->{
		if(count>0)
			Category_layout.getChildren().remove(5);
		else count++;
		message.setFont(new Font("Times New Roman",40));
		ObservableList<Text> movies;
		movies = categoryLV.getSelectionModel().getSelectedItems();
		String msg="Jelenleg kiválasztva: ";
		for(Text m : movies) {
			
			String s=m.getText();
			if(msg.equals("Jelenleg kiválasztva: "))
				msg=msg+s;
			else
				msg=msg+" + " +s;
			
		}
		
		message.setText(msg);
		message.setLayoutX(0);
		message.setLayoutY(600);
		Category_layout.getChildren().add(message);
	}); 
	
	
	categoryButton.setOnAction(e -> {
		if (categoryLV.getSelectionModel().isEmpty())
		{
			categoryLabel.setText("Nem lettek kategóriák kiválasztva, válassz ki egy-kettőt közülük!");
			zerocount++;
		}	
		else
		{	if(zerocount>0)
				categoryLabel.setText("Válaszd ki a kategóriát/ kategóriákat, amikből szavakat szeretnél!");
			buttonClicked();
			zerocount=0;
			count=0;
			categoryLV.getSelectionModel().clearSelection();
			PuzzleSize.display_PuzzleSize(win, sc, Category_layout);
			message.setText(mesg);
			Category_layout.getChildren().remove(message);
		}
	});
	

		
	}

	static private void buttonClicked()
	{
		
		ObservableList<Text> movies;
		movies = categoryLV.getSelectionModel().getSelectedItems();
		String message="";
		
		for(Text m : movies) {
			message = m.getText();
			str.add(message);
		}
	}
	
}
