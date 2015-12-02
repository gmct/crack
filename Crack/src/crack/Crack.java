package crack;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Crack{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String code = generateCode();
		
		System.out.println("Let the game begin! I'm thinking of a 6 numbers code.");
		System.out.println("Numbers in the code are in the range of 0 to 6. Clues will be given."
				+ "\nGame will end after 25 clues. Good luck!!");
		int i = 0;
		boolean gameWon = false;
		String guess = scan.next();
		while (i < 25 && !gameWon){
			clue();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (guess == code){
				gameWon = true;
			}
			i++;
		}
		if (gameWon){
			System.out.println("Congratulations! You guessed correctly.");
		}
		scan.close();
	}
	private static void clue(){
		System.out.println("Clue: the sky is cool: ");
	}
	private static String generateCode(){
		Random rand = new Random();
		String code = "";
		for (int i = 0; i < 6; i++){
			code += rand.nextInt(7);
		}
		return code;
	}
	
}
