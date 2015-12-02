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
		System.out.println(code);
		
//		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//	    executorService.scheduleAtFixedRate(Crack::clue, 0, 1, TimeUnit.SECONDS);
		
	}
	private static void clue(){
		System.out.println("Clue: the sky is cool: ");
	}
	private String generateCode(){
		Random rand = new Random();
		String code = "";
		for (int i = 0; i < 6; i++){
			code += rand.nextInt(7);
		}
		return code;
	}
}
