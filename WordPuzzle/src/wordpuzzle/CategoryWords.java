package wordpuzzle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CategoryWords {
	
	public static ArrayList<String> catList = new ArrayList<>();
	public static void getList() {
		try {
			FileReader fr1 = new FileReader("Gyümölcsök - zöldségek.txt");
			Scanner sc1 = new Scanner(fr1);
			FileReader fr2 = new FileReader("Emlősök.txt");
			Scanner sc2 = new Scanner(fr2);
			FileReader fr3 = new FileReader("Madarak.txt");
			Scanner sc3 = new Scanner(fr3);
			FileReader fr4 = new FileReader("Folyók.txt");
			Scanner sc4 = new Scanner(fr4);
			FileReader fr5 = new FileReader("Városok.txt");
			Scanner sc5 = new Scanner(fr5);
			
			int letterNumb = Puzzle.array.length * Puzzle.array.length;
			int limit = (int)(letterNumb*0.6);
			
			if(Category.str.contains("Gyümölcsök - zöldségek"))
				FileRead.FileRead(sc1, fr1);
			if(Category.str.contains("Emlősök"))
				FileRead.FileRead(sc2, fr2);
			if(Category.str.contains("Madarak"))
				FileRead.FileRead(sc3, fr3);
			if(Category.str.contains("Folyók"))
				FileRead.FileRead(sc4, fr4);
			if(Category.str.contains("Városok"))
				FileRead.FileRead(sc5, fr5);
			
			Collections.shuffle(catList);
			
			int lettersContainted=0;
			
			for(String x : catList)
			{
				if(x.length()<=Puzzle.array.length)
					if(lettersContainted<limit)
					{
						PlacingWords.words.add(x);
						lettersContainted+=x.length();
					}
			}
			
			} catch (FileNotFoundException e) {
				System.err.println(e);
			}
			
		}
		
}
