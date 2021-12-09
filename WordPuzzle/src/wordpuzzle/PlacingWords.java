package wordpuzzle;

import java.util.ArrayList;
import java.util.Random;

public class PlacingWords {
	
	private static Random rng = new Random();
	
	public static Words wrds[];
	
	public static ArrayList<String> words = new ArrayList<>();
	
	public static void place()
	{
		CategoryWords.getList();
		int l=0;
		for(String x : words)
		{
			l += x.length();
			System.out.println(x);
		}
		System.out.println("Length: "+l);
		
		wrds = new Words[words.size()];
		
		for(int i=0; i< words.size(); i++)
		{	
			
			int x;
			int y;
			int direction;
			
			do {
				direction = rng.nextInt(2);
				if(direction==0) {
					x = rng.nextInt(Puzzle.array.length);
					y = rng.nextInt(Puzzle.array.length - words.get(i).length()+1);
				}
				else {
					x = rng.nextInt(Puzzle.array.length - words.get(i).length()+1);
					y = rng.nextInt(Puzzle.array.length);
				}	
				
			} while(checkIfOverlaps(words.get(i), direction, x, y, i) == true);
			placeWord(words.get(i), direction, x, y);
		}
	}

	private static void placeWord(String word, int direction, int x, int y)
	{
		
		
		for(int i=0; i<word.length();i++)
		{
			if(direction == 0) {
				if(Puzzle.array[x][y+i].isWord!=LabelType.BOTH) {
					Puzzle.array[x][y+i].lab.setText(Character.toString(word.charAt(i)));
					Puzzle.array[x][y+i].isWord=LabelType.HORIZONTAL;
				}
			}
			else {
				if(Puzzle.array[x+i][y].isWord!=LabelType.BOTH) {
					Puzzle.array[x+i][y].lab.setText(Character.toString(word.charAt(i)));
					Puzzle.array[x+i][y].isWord=LabelType.VERTICAL;
				}
			}
			
		}

	}
	
	private static boolean checkIfOverlaps(String word, int direction, int x, int y, int iValue)
	{
		for(int i=0; i<word.length();i++)
		{
			if(direction == 0) {
				if(Puzzle.array[x][y+i].isWord!=LabelType.BOTH)
				{	String s= Character.toString(word.charAt(i));
					String s2 =Puzzle.array[x][y+i].lab.getText();
					if(!s.equals(s2))
						return true;
					else
						if(Puzzle.array[x][y+i].isWord==LabelType.HORIZONTAL || Puzzle.array[x][y+i].isWord==LabelType.BOTH)
						{
							return true;
						}
						else
						{
							Puzzle.array[x][y+i].isWord=LabelType.BOTH;
						}
					
				}
			}
			else {
				if(Puzzle.array[x+i][y].isWord!=LabelType.NONE)
				{
					String s=Character.toString(word.charAt(i));
					String s2 =Puzzle.array[x+i][y].lab.getText();
					if(!s.equals(s2))
						return true;
					else
						if(Puzzle.array[x+i][y].isWord==LabelType.VERTICAL || Puzzle.array[x+i][y].isWord==LabelType.BOTH)
						{
							return true;
						}else {
							Puzzle.array[x+i][y].isWord=LabelType.BOTH;
						}
				}
			}	
		}
		wrds[iValue]=new Words(word, x, y, direction);
		return false;
	}
	
	
/*	
	private static boolean notEnough(String word, int direction, int x, int y, int iValue)
	{
		System.out.println(iValue);
		int wordLength=0;
		int shortestFit=0;
		int shortestHFit=Puzzle.array.length;
		int shortestVFit=Puzzle.array.length;
		int current=0;
		int horR=0;
		int horCStart=0, horCLast=0;
		int verC=0;
		int verRStart=0, verRLast=0;
		boolean notFit=false;
		if(iValue<words.size()-1) {
			for(int k=iValue+1;k<words.size();k++)
			{
				wordLength = words.get(k).length();
					

		System.out.println(word);
		

		for(int i=0;i<Puzzle.array.length;i++)
		{
			for(int j=0;j<Puzzle.array.length;j++)
			{
				if(j==(Puzzle.array.length-1) && ((!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC))))  
				{
					current=0;
					
				}
				else if(j==(Puzzle.array.length-1) && !((!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC))))  
				{
					current++;
					if(current < shortestHFit && current >= wordLength )
					{
						shortestHFit = current;
						horR=i;
						horCLast=j;
						horCStart=j-current+1;
					}	
					
				}
				else if((!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC)) && 
						(!Puzzle.array[i][j+1].isWord.equals("none") || (Puzzle.array[i][j+1].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j+1].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[iValue].startC && Puzzle.array[i][j+1].colNumb <= wrds[iValue].lastC)))
				{
					current=0;
				}
				else if(!(!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC)) && 
						(!Puzzle.array[i][j+1].isWord.equals("none") || (Puzzle.array[i][j+1].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j+1].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[iValue].startC && Puzzle.array[i][j+1].colNumb <= wrds[iValue].lastC)))
				{
					current++;
					if(current < shortestHFit && current >= wordLength )
					{
						shortestVFit = current;
						verC=i;
						verRLast=i;
						verRStart=i-word.length()+1;
					}
					
				}
				else if ((!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC)) && 
						!(!Puzzle.array[i][j+1].isWord.equals("none") || (Puzzle.array[i][j+1].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j+1].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[iValue].startC && Puzzle.array[i][j+1].colNumb <= wrds[iValue].lastC)))
				{
					current=0;
				}
				else if (!(!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC)) && 
						!(!Puzzle.array[i][j+1].isWord.equals("none") || (Puzzle.array[i][j+1].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j+1].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[iValue].startC && Puzzle.array[i][j+1].colNumb <= wrds[iValue].lastC)))
				{
					current++;
				}
			}
			current=0;
		}
				

		for(int j=0;j<Puzzle.array.length;j++)
		{
			for(int i=0;i<Puzzle.array.length;i++)
			{
				if(i==(Puzzle.array.length-1) && ((!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC))))  
				{
					current=0;
					
				}
				else if(i==(Puzzle.array.length-1) && !((!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC))))  
				{
					current++;
					if(current < shortestVFit && current >= wordLength )
					{
						shortestVFit = current;
						verC=i;
						verRLast=i;
						verRStart=i-current+1;
					}
					
				}
				else if((!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC)) && 
						(!Puzzle.array[i+1][j].isWord.equals("none") || (Puzzle.array[i+1][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i+1][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i+1][j].colNumb >=wrds[iValue].startC && Puzzle.array[i+1][j].colNumb <= wrds[iValue].lastC)))
				{
					current=0;
				}
				else if(!(!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC)) && 
						(!Puzzle.array[i+1][j].isWord.equals("none") || (Puzzle.array[i+1][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i+1][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i+1][j].colNumb >=wrds[iValue].startC && Puzzle.array[i+1][j].colNumb <= wrds[iValue].lastC)))
				{
					current++;
					if(current < shortestVFit && current >= wordLength )
					{
						shortestVFit = current;
						verC=i;
						verRLast=i;
						verRStart=i-current+1;
					}
						current=0;
				}
				else if ((!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC)) && 
						!(!Puzzle.array[i+1][j].isWord.equals("none") || (Puzzle.array[i+1][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i+1][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i+1][j].colNumb >=wrds[iValue].startC && Puzzle.array[i+1][j].colNumb <= wrds[iValue].lastC)))
				{
					current=0;
				}
				else if (!(!Puzzle.array[i][j].isWord.equals("none") || (Puzzle.array[i][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[iValue].startC && Puzzle.array[i][j].colNumb <= wrds[iValue].lastC)) && 
						!(!Puzzle.array[i+1][j].isWord.equals("none") || (Puzzle.array[i+1][j].rowNumb>=wrds[iValue].startR && Puzzle.array[i+1][j].rowNumb<=wrds[iValue].lastR &&
						Puzzle.array[i+1][j].colNumb >=wrds[iValue].startC && Puzzle.array[i+1][j].colNumb <= wrds[iValue].lastC)))
				{
					current++;
				}
			}
			current=0;
		}
		
		for(int i=0;i<Puzzle.array.length;i++)
		{
			for(int j=0;j<Puzzle.array.length;j++)
			{
				if(shortestHFit < shortestVFit)
				{
					if(i==horR && j>=horCStart && j<=horCLast)
						Puzzle.array[i][j].isWord="horizontal";
				}
				else
				{
					if(j==verC && i>=verRStart && i<=verRLast)
						Puzzle.array[i][j].isWord="vertical";
				}
			}
		}
		
			}
			
		}

	}

*/	
		
}