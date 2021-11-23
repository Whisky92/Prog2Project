package wordpuzzle;

import java.util.Random;

public class PlaceWords {
	
	private static Random rng = new Random();
	
	public static Words wrds[];
	
	public static void place()
	{
		String words[] = new String[] {"WORDS","HELLO","SUBSCRIBE","ECLIPSE","DECEMBER"};
		
		wrds = new Words[words.length];
		
		for(int i=0; i< words.length; i++)
		{	
			int i_value=i;
			int x;
			int y;
			int direction;
			boolean final_true;
			do {
				x = rng.nextInt(Puzzle.array.length - words[i].length() + 1);
				y = rng.nextInt(Puzzle.array.length - words[i].length() + 1);
				direction = rng.nextInt(2);
				final_true = true;

				if(checkIfOverlaps(words[i], direction, x, y, i_value) == true)

			} while(notEnough(words[i], direction, x, y, i_value));
			placeWord(words[i], direction, x, y);
			System.out.println(wrds[i].word + " len:" + wrds[i].len + " sR:" + wrds[i].startR + " lR:" + wrds[i].lastR +" sC:"+ wrds[i].startC +" lC:"+wrds[i].lastC+" type:"+wrds[i].type);
		}
	}

	private static void placeWord(String word, int direction, int x, int y)
	{
		
		
		for(int i=0; i<word.length();i++)
		{
			if(direction == 0) {
				Puzzle.array[x][y+i].lab.setText(Character.toString(word.charAt(i)));
				Puzzle.array[x][y+i].isWord=true;
			}
			else {
				Puzzle.array[x+i][y].lab.setText(Character.toString(word.charAt(i)));
				Puzzle.array[x+i][y].isWord=true;
			}
			
		}
	}
	
	private static boolean checkIfOverlaps(String word, int direction, int x, int y, int i_v)
	{
		for(int i=0; i<word.length();i++)
		{
			if(direction == 0) {
				if(Puzzle.array[x][y+i].isWord== true && Puzzle.array[x][y+i].lab.getText() != Character.toString(word.charAt(i)))
				{
					return true;
				}else if(Puzzle.array[x][y+i].isWord== true && Puzzle.array[x][y+i].lab.getText() == Character.toString(word.charAt(i)) && wrong_horizontal(x, y+i))
				{
					System.out.println("err");
					return true;
				}
			}
			else {
				if(Puzzle.array[x+i][y].isWord== true && Puzzle.array[x+i][y].lab.getText() != Character.toString(word.charAt(i)))
				{
					return true;
				}else if(Puzzle.array[x+i][y].isWord== true && Puzzle.array[x+i][y].lab.getText() != Character.toString(word.charAt(i)) && wrong_vertical(x+i, y))
				{
					System.out.println("err");
					return true;
				}
			}	
		}
		wrds[i_v]=new Words(word, x, y, direction);
		return false;
	}
	
	private static boolean wrong_horizontal(int x, int y) {
		for(int i=0; i<wrds.length; i++)
		{
			System.out.println(i);
			if(wrds[i].type=='v')
				{
				System.out.println('v');
					if(wrds[i].startR == x)
					{
						System.out.println('x');
						int st= wrds[i].startC;
						for(int j= 0; j<wrds[i].len;j++)
						{
							System.out.println(st);
							if(st==y)
								return true;
							st++;
								
						}
					}
				}
		}
		return false;
	}
	
	private static boolean wrong_vertical(int x, int y) {
		for(int i=0; i<wrds.length; i++)
		{
			System.out.println(i);
			if(wrds[i].type=='f')
				{
				System.out.println('f');
					if(wrds[i].startC == y)
					{
						System.out.println('y');
						int st= wrds[i].startR;
						for(int j= 0; j<wrds[i].len;j++)
						{
							System.out.println(st);
							if(st==x)
								return true;
							st++;
								
						}
					}
				}
		}
		return false;
	}
	
	private static boolean notEnough(String word, int direction, int x, int y, int i_v)
	{
		int longestw=0;
		int wlength=word.length();
		int currentLongest=0;
		int current;
		for(int i=(i_v+1);i<wrds.length;i++)
		{
			if(wrds[i].len > longestw)
				longestw = wrds[i].len;
		}
		for(int i=0;i<Puzzle.array.length;i++)
		{
			current=0;
			for(int j=0;j<Puzzle.array.length;j++)
			{
				if(j==(Puzzle.array.length-1) && ((Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC))))  
				{
					current=0;
					
				}
				else if(j==(Puzzle.array.length-1) && !((Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC))))  
				{
					current++;
					if(current > currentLongest)
						currentLongest = current;
					
				}
				else if((Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC)) && 
						(Puzzle.array[i][j+1].isWord==true || (Puzzle.array[i][j+1].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j+1].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[i_v].startC && Puzzle.array[i][j+1].colNumb <= wrds[i_v].lastC)))
				{
					current=0;
				}
				else if(!(Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC)) && 
						(Puzzle.array[i][j+1].isWord==true || (Puzzle.array[i][j+1].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j+1].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[i_v].startC && Puzzle.array[i][j+1].colNumb <= wrds[i_v].lastC)))
				{
					current++;
					if(current > currentLongest)
						currentLongest=current;
					current=0;
				}
				else if ((Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC)) && 
						!(Puzzle.array[i][j+1].isWord==true || (Puzzle.array[i][j+1].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j+1].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[i_v].startC && Puzzle.array[i][j+1].colNumb <= wrds[i_v].lastC)))
				{
					current=0;
				}
				else if (!(Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC)) && 
						!(Puzzle.array[i][j+1].isWord==true || (Puzzle.array[i][j+1].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j+1].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[i_v].startC && Puzzle.array[i][j+1].colNumb <= wrds[i_v].lastC)))
				{
					current++;
				}
			}
		
	}
		for(int j=0;j<Puzzle.array.length;j++)
		{
			current=0;
			for(int i=0;i<Puzzle.array.length;i++)
			{
				if(j==(Puzzle.array.length-1) && ((Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC))))  
				{
					current=0;
					
				}
				else if(j==(Puzzle.array.length-1) && !((Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC))))  
				{
					current++;
					if(current > currentLongest)
						currentLongest = current;
					
				}
				else if((Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC)) && 
						(Puzzle.array[i][j+1].isWord==true || (Puzzle.array[i][j+1].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j+1].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[i_v].startC && Puzzle.array[i][j+1].colNumb <= wrds[i_v].lastC)))
				{
					current=0;
				}
				else if(!(Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC)) && 
						(Puzzle.array[i][j+1].isWord==true || (Puzzle.array[i][j+1].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j+1].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[i_v].startC && Puzzle.array[i][j+1].colNumb <= wrds[i_v].lastC)))
				{
					current++;
					if(current > currentLongest)
						currentLongest=current;
					current=0;
				}
				else if ((Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC)) && 
						!(Puzzle.array[i][j+1].isWord==true || (Puzzle.array[i][j+1].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j+1].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[i_v].startC && Puzzle.array[i][j+1].colNumb <= wrds[i_v].lastC)))
				{
					current=0;
				}
				else if (!(Puzzle.array[i][j].isWord==true || (Puzzle.array[i][j].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j].colNumb >=wrds[i_v].startC && Puzzle.array[i][j].colNumb <= wrds[i_v].lastC)) && 
						!(Puzzle.array[i][j+1].isWord==true || (Puzzle.array[i][j+1].rowNumb>=wrds[i_v].startR && Puzzle.array[i][j+1].rowNumb<=wrds[i_v].lastR &&
						Puzzle.array[i][j+1].colNumb >=wrds[i_v].startC && Puzzle.array[i][j+1].colNumb <= wrds[i_v].lastC)))
				{
					current++;
				}
			}
	}
	if(currentLongest>=longestw)
		return false;
	else
		return true;
	}
	
	
}
