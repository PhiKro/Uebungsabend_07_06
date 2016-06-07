package com.campus02.primechek;

public class Test {

	
	public static void main (String Args[]) {
	Checker test0 = new Checker(2145474475);
	Checker test1 = new Checker(1989990047);
	Checker test2 = new Checker(13);
	Checker test3 = new Checker(1891999939);
	
	Thread t0 = new Thread(test0);
	Thread t1 = new Thread(test1);
	Thread t2 = new Thread(test2);
	Thread t3 = new Thread(test3);
	
	
	
	t0.start();
	t1.start();
	t2.start();
	t3.start();
	
	try {
		t3.join();
		t1.join();
		t2.join();
		t0.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}

}
