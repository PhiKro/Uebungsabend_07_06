package com.campus02.lockdemo;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {

	static int counter;
	static Lock lock = new ReentrantLock();

	@Override
	public void run() {

		while (counter <1_000_000) {
			increase();
		}
		System.out.println(counter);
	}

	public  void increase() {
		lock.lock();
		try {
			counter++;
		} finally {
			lock.unlock();
		} 
//		
//	synchronized (lock) {
//		counter++;
//	}
	
	}
}
