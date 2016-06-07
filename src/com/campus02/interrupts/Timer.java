package com.campus02.interrupts;

import java.util.Date;

public class Timer implements Runnable {


	private boolean interrupt = false;
	
	
	public Timer() {
		super();
		this.interrupt = false;
	}


	public void setInterrupt(boolean interrupt) {
		this.interrupt = interrupt;
	}


	@Override
	public void run() {
		while (interrupt == false)
		{
			Date d = new Date();
			System.out.println(d.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
