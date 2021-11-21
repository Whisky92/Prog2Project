package wordpuzzle;

import java.util.Arrays;
import java.util.List;

import javafx.scene.control.TextField;

public class NumbCheck {
	
	public static boolean check(TextField t)
	{
		List<Character> chars = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
		boolean jo = true;
		String text = t.getText();
		for (int i=0; i<text.length(); i++)
		{
			if(!chars.contains(text.charAt(i)))
				jo = false;
		}
		
		return jo;
	}
	
	public static boolean checkFirstChar(String n)
	{
		boolean jo = true;
		
		if(n.charAt(0)=='0')
			jo = false;
		
		return jo; 
	}

}
