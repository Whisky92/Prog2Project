package wordpuzzle;

import java.util.LinkedList;

public class Words {
	
	//vertical - függőleges - bool false, horizontal - vízszintes - bool true
	String word;
	int len;
	int startR;
	int startC;
	int lastR;
	int lastC;
	LinkedList<Integer> Rcoords;
	LinkedList<Integer> Ccoords;
	char type;
	
	public Words(String w, int sR, int sC, int dir)
	{
		word=w;
		len=word.length();
		if(dir == 0)
		{
			type='v';
		}else{
			type='f';
		}
		startR=sR;
		startC=sC;
		if(type=='v') {
			lastR = startR;
			lastC = startC + len - 1;
		}else {
			lastR = startR + len - 1;
			lastC = startC;
		}
		Rcoords=new LinkedList<>();
		for(int i=startR;i<=lastR;i++)
			Rcoords.add(i);
		
		Ccoords=new LinkedList<>();
		for(int i=startC;i<=lastC;i++)
			Ccoords.add(i);
		
	}

}
