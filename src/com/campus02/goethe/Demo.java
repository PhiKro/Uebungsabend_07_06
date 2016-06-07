package com.campus02.goethe;

import java.io.File;

public class Demo {

	
	@SuppressWarnings("static-access")
	public static void main (String Args[])
	{
		File in = new File("E:\\Java\\text.txt");
		
		Importer goethe = new Importer();
		goethe.readText(in);
		
		TextAnalyzer ta0 = new TextAnalyzer(goethe.even);
		TextAnalyzer ta1 = new TextAnalyzer(goethe.odd);
		
		Thread t0 = new Thread(ta0);
		Thread t1 = new Thread(ta1);
		
		t0.start();
		t1.start();
		
		
		try {
			t0.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Es sind " + TextAnalyzer.wordCount + " Zeichen in diesem Text");
		System.out.println(TextAnalyzer.charCount.toString());
		
	}
}
