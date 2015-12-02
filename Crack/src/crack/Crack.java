package crack;

import crack.Clue;

import java.util.Random;
import java.util.Scanner;


public class Crack{
	static Random rand = new Random();
	public static boolean gameOver = false;
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String code = generateCode();
		
		System.out.println(code);
		
		System.out.println("Let the game begin! I'm thinking of a 6 numbers code.");
		System.out.println("Numbers in the code are in the range of 0 to 6. Clues will be given."
				+ "\nGame will end after 25 clues. Good luck!!");
		
		String guess;
		boolean gameWon = false;
		new Thread(new Clue()).start();
		while (!gameOver){
			guess = scan.next();
			if (guess == code){
				gameWon = true;
				gameOver = true;
			}
		}
		if (gameWon){
			System.out.println("Congratulations! You guessed correctly.");
		}
		scan.close();
	}
	public void clue(){
		System.out.println("Clue: the sky is cool: ");
		
	}
	private static String generateCode(){
		String code = "";
		for (int i = 0; i < 6; i++){
			code += rand.nextInt(7);
		}
		return code;
	}
	public void setGameOver(){
		gameOver = true;
	}
	
}
