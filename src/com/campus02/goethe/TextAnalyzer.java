package com.campus02.goethe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TextAnalyzer implements Runnable {

	static long wordCount;
	static HashMap<Character, Integer> charCount = new HashMap<>();
	static ArrayList<String> list;
	static Lock lock = new ReentrantLock();

	@SuppressWarnings("static-access")
	public TextAnalyzer(ArrayList<String> list) {
		this.list = list;
	}
	
	

	public static void Analyzer() {
		for (String string : list) 
		{
			lock.lock();
			wordCount = wordCount + string.length();
			for (int i = 0; i < string.length()-1; i++) {
				if (charCount.containsKey(string.charAt(i))) {
					charCount.put(string.charAt(i), charCount.get(string.charAt(i)) + 1);
				} else {
					charCount.put(string.charAt(i), 1);
				}
			}
			lock.unlock();
		}
		
	}

	@Override
	public String toString() {
		return "TextAnalyzer [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public void run() {
		Analyzer();

	}

}