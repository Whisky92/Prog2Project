package wordpuzzle;

public class Words {
	
	//vertical - függőleges - bool false, horizontal - vízszintes - bool true
	String word;
	int len;
	int startR;
	int startC;
	int lastR;
	int lastC;
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
		
	}

}
