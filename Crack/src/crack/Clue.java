package crack;

import crack.Crack;

public class Clue implements Runnable{
	public static boolean gameOver = false;
	public void run() {
		Crack crack = new Crack();
		int i = 0;
		
		while (i < 25 && !gameOver){
			crack.clue();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
		
		//Doesn't appear to actually be changing the state in the other thread.
		crack.setGameOver();
	}
	public void setGameOver(){
		gameOver = true;
	}
}