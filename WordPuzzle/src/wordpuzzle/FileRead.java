package wordpuzzle;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {
	
	public static void FileRead(Scanner sc, FileReader fr)
	{
		String s="";
		int counter=0;
		int length;
		boolean notEmpty=true;
		String w;
		int pos1=0, pos2=0;
		while(sc.hasNextLine()) {
				w="";
				notEmpty=true;
				length=0;
				counter=0;
				s=sc.nextLine();
				length = s.length();
				if(length==0)
					notEmpty=false;
				
				if(notEmpty)
				{	
				for(int i=0;i<s.length();i++)
				{
					if(s.charAt(i)=='\"' && counter==0)
					{
						pos1=i;
						counter++;
					}
					if(s.charAt(i)=='\"' && counter==1 && i!=pos1)
					{
						pos2=i;
						counter++;
					}
				}

				for(int i=0;i<s.length();i++)
				{
	
					if(i>pos1 && i<pos2 && s.charAt(i)!=' ')
					{
						w+=s.charAt(i);
					}
						
				}
				CategoryWords.catList.add(w);
				}
			}
		try {
			fr.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
