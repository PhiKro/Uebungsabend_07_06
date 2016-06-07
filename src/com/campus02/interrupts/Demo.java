package com.campus02.interrupts;

import java.util.Scanner;

public class Demo {

	@SuppressWarnings("resource")
	public static void main (String Args[]){
		
		Scanner input = new Scanner(System.in);
		
		Timer t = new Timer();
		
		Thread t0 = new Thread(t);
		
		System.out.println("Press Enter to kill task");
		t0.start();
		String check;
		while (true)
		{
			check = input.nextLine();
			if (check.equalsIgnoreCase(""))
			{
				t.setInterrupt(true);
				System.out.println("Stopped");
				break;
			}
		}
		
		try {
			t0.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		System.out.println("beendet");
	}

}
