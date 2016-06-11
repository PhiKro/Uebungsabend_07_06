package com.campus02.urlaubsplaner;

import java.util.Scanner;

public class Consolebreaker implements Runnable {

	public boolean stop;
	


	@SuppressWarnings("resource")
	@Override
	public void run() {

		stop =false;
		while(true){
			Scanner sc = new Scanner(System.in);
			if (sc.nextLine().equalsIgnoreCase("exit") ){
				stop=true;
				sc.close();
				break;
			}
			
		}
		
		
	}

}
