package wordpuzzle;

import javafx.scene.control.Label;

public class Labels {
	
	Label lab;
	int idNumb;
	int rowNumb;
	int colNumb;
	String isWord;
	
	public Labels(Label l,int id, int rN, int cN)
	{
		lab = l;
		idNumb = id;
		rowNumb = rN;
		colNumb = cN;
		isWord = "none";
	}

}
