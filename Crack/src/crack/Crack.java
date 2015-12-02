package crack;

import crack.Clue;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;
import java.util.concurrent.*;


public class Crack{
	static Random rand = new Random();
	public static boolean gameOver = false;
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
	    final PipedOutputStream outputStream = new PipedOutputStream();
	    PipedInputStream inputStream;
		try {
			inputStream = new PipedInputStream(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String code = generateCode();
		
		System.out.println(code);
		
		System.out.println("Let the game begin! I'm thinking of a 6 numbers code.");
		System.out.println("Numbers in the code are in the range of 0 to 6. Clues will be given."
				+ "\nGame will end after 25 clues. Good luck!!");
		
		String guess;
		boolean gameWon = false;
		new Thread(new Clue()).start();
		int readByte = 1;
	    // Read data with timeout
	    Callable<Integer> readTask = new Callable<Integer>() {
	        @Override
	        public Integer call() throws Exception {
	            return inputStream.read();
	        }
	    };
	    while (readByte >= 0) {
	        Future<Integer> future = executor.submit(readTask);
	        readByte = future.get(5000, TimeUnit.MILLISECONDS);
	        if (readByte >= 0)
	            System.out.println("Read: " + readByte);
	    }
		if (gameWon){
			System.out.println("Congratulations! You guessed correctly.");
		}
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