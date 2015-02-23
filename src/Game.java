import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	public static int shipCount = 0;
	

	Board b;

	public static void main(String[] args) {

		Game game = new Game();
		game.setUp();

	}

	private void setUp() {
		b = new Board(10, 11);
		Ship bigBoat = new Ship(5);
		Ship smallBoat = new Ship(2);
		

		b.fillBoard(bigBoat);
		b.fillBoard(smallBoat);
		b.fillBoard(bigBoat);
		b.writeGameBoard();
		play();

	}

	private void play() {
		String guess=null;
		boolean t = false;
		 Pattern p = Pattern.compile("[a-zA-Z][0-9]");
		 int sizeMat = b.board.length;
		 
		Scanner input = new Scanner(System.in);
		
		while(!t){
			 System.out.println("Въведете предложение: ");	
			 guess = input.nextLine();
			 char a = (guess.substring(0).toUpperCase()).charAt(0);
			 int s = (int) a - 64;
			 Matcher m = p.matcher(guess);
			 t = m.matches() && s<=sizeMat;  
			 
		}
		
		System.out.println(java.util.Arrays.toString(translate(guess)));
		
		input.close();
	}
	private int[] translate(String g) {
		int[] x = new int[2];
		
		char a = (g.substring(0).toUpperCase()).charAt(0);
		 int s = (int) a - 64;
		//System.out.println(s);
		x[0]= s;
		x[1]= Integer.parseInt(g.substring(1)); 
		return  x;
		
	}
}
	

