package com.campus02.goethe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Importer {

	static ArrayList<String> even = new ArrayList<>();
	static ArrayList<String> odd = new ArrayList<>();
	
	

public static ArrayList<String> getEven() {
		return even;
	}

	public static ArrayList<String> getOdd() {
		return odd;
	}

public static void readText (File source)
{
	try (BufferedReader br = new BufferedReader(new FileReader(source));)
	{
		String line;
		int counter = 1;
		while ((line = br.readLine()) != null )
		{
			if (counter%2 == 0 )
			{
				even.add(line);
			}
			else 
			{
				odd.add(line);
			}
			counter++;
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(even.get(0));
	System.out.println(odd.get(0));
	System.out.println(even.get(1));
	System.out.println(odd.get(1));
}
}