package crack;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Crack implements Runnable{
	static Random rand = new Random();
	static boolean gameOver = false;
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String code = generateCode();
		
		System.out.println(code);
		
		System.out.println("Let the game begin! I'm thinking of a 6 numbers code.");
		System.out.println("Numbers in the code are in the range of 0 to 6. Clues will be given."
				+ "\nGame will end after 25 clues. Good luck!!");
		
		String guess;
		boolean gameWon = false;
	    boolean gameOver = false;
		(new Thread(new Crack())).start();
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
	private static void clue(){
		System.out.println("Clue: the sky is cool: ");
		
	}
	private static String generateCode(){
		String code = "";
		for (int i = 0; i < 6; i++){
			code += rand.nextInt(7);
		}
		return code;
	}
	@Override
	public void run() {
		int i = 0;
		while (i < 25 && !gameOver){
			clue();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
		gameOver = true;
	}
	
}
