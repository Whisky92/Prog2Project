package wordpuzzle;

import java.util.Random;

public class RandGen {
	public static char gen() {
		char c = 0;
		Random r = new Random();
		int i=r.nextInt(35);
		switch(i) {
			case 0:
				c='A';
				break;
			case 1:
				c='Á';
				break;
			case 2:
				c='B';
				break;
			case 3:
				c='C';
				break;
			case 4:
				c='D';
				break;
			case 5:
				c='E';
				break;
			case 6:
				c='É';
				break;
			case 7:
				c='F';
				break;
			case 8:
				c='G';
				break;
			case 9:
				c='H';
				break;
			case 10:
				c='I';
				break;
			case 11:
				c='Í';
				break;
			case 12:
				c='J';
				break;
			case 13:
				c='K';
				break;
			case 14:
				c='L';
				break;
			case 15:
				c='M';
				break;
			case 16:
				c='N';
				break;
			case 17:
				c='O';
				break;
			case 18:
				c='Ó';
				break;
			case 19:
				c='Ö';
				break;
			case 20:
				c='Ő';
				break;
			case 21:
				c='P';
				break;
			case 22:
				c='Q';
				break;
			case 23:
				c='R';
				break;
			case 24:
				c='S';
				break;
			case 25:
				c='T';
				break;
			case 26:
				c='U';
				break;
			case 27:
				c='Ú';
				break;
			case 28:
				c='Ü';
				break;
			case 29:
				c='Ű';
				break;
			case 30:
				c='V';
				break;
			case 31:
				c='W';
				break;
			case 32:
				c='X';
				break;
			case 33:
				c='Y';
				break;
			case 34:
				c='Z';
				break;
			
			}
		
		
		return c;
	}
}
