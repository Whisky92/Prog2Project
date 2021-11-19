package wordpuzzle;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserName {
	
	static String Name="";
	
	public static void display_UserName(Stage st, Scene sc)
	{
		int labelX = 20, labelY=200;
		int tfX=400, tfY=460;
		int tfW=1000, tfH=100;
		int tfS1=80, tfS2=50;
		int buttonX=800, buttonY=580;
		int buttonW=300, buttonH=100;
		
		
		Group userNameLayout = new Group();
		
		Text usernameLabel = new Text("Írd be a felhasználóneved a szövegmezőbe!");
		usernameLabel.setLayoutX(labelX);
		usernameLabel.setLayoutY(labelY);
		usernameLabel.setFont(new Font("Arial Black",tfS1));
		
		TextField userName_tf = new TextField();
		userName_tf.setLayoutX(tfX);
		userName_tf.setLayoutY(tfY);
		userName_tf.setPrefSize(tfW, tfH);
		userName_tf.setFont(new Font("Times New Roman",tfS2));
		userName_tf.setText("Felhasznalo");
		
		Button userNameButton = new Button("Tovább");
		userNameButton.setLayoutX(buttonX);
		userNameButton.setLayoutY(buttonY);
		userNameButton.setPrefSize(buttonW, buttonH);
		
		userNameLayout.getChildren().addAll(usernameLabel, userName_tf, userNameButton);
		
		Button userNameBack = SceneParameters.createBackButton(userNameLayout);
		userNameBack.setOnAction(e -> {
			Name="";
			st.setScene(sc);
		});
		
		Scene userNameScene = new Scene(userNameLayout, SceneParameters.SceneW, SceneParameters.SceneH);
		st.setScene(userNameScene);
		
		userNameButton.setOnAction(e -> {
			String n = userName_tf.getText();
			if(NameCheck.check(n)==false) {
				usernameLabel.setText("A szóban nem megfelelő karakter található!");
			}else {
				Name=n;
				usernameLabel.setText("Írd be a felhasználóneved a szövegmezőbe!");
				Category.display_Category(st, userNameScene);
			}
		});
	}

}
