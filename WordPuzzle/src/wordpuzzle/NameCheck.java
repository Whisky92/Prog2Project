package wordpuzzle;

import java.util.Arrays;
import java.util.List;

public class NameCheck {
	
	static boolean check(String s) 
	{
		boolean correct=true;
		List<Character> chars = Arrays.asList('A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i',
											  'J','j','K','k','L','l', 'M','m','N','n','O','o','P','p','Q','q','R','r',
											  'S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z',
											  '0','1','2','3','4','5','6','7','8','9');
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(!chars.contains(c))
				correct=false;
				
		}
		return correct;
	}

}
