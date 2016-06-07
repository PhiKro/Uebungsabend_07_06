package com.campus02.lockdemo;
public class Demo {

	public static void main (String Args[]) {
		
		Counter count = new Counter();
		
		Thread th0 = new Thread(count);
		Thread th1 = new Thread(count);
		
		th0.start();
		th1.start();
		
		try {
			th0.join();
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
