package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

	 
	 public static void main(String[] args) {
	  launch(args);
	 }

@Override
public void start(Stage primaryStage) {
    Rectangle rect = new Rectangle(50, 50);

    StackPane root = new StackPane(rect);

 /*  rect.addEventFilter(MouseEvent.MOUSE_CLICKED, evt -> { 
	   System.out.println("asd");
//	   evt.consume();
        System.out.println("rect click(filter)");
    
    });
    root.addEventFilter(MouseEvent.MOUSE_CLICKED, evt -> {
        System.out.println("root click(filter)");
       evt.consume();
    }); */

    root.setOnMouseClicked(evt -> {
        System.out.println("root click(handler)");
    evt.consume();
    });
    rect.setOnMouseClicked(evt -> {
        System.out.println("rect click(handler)");
    //  evt.consume();
      System.out.println("asd");
    }); 

    Scene scene = new Scene(root, 200, 200);

    primaryStage.setScene(scene);
    primaryStage.show();
}
}