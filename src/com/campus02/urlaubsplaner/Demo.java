package com.campus02.urlaubsplaner;

public class Demo {

	public static void main(String[] args) 
	{
		UrlaubManager um0 = new UrlaubManager("e:\\Java\\urlaub.txt");
		
		try {
			um0.load("Kropik");
			System.out.println("---------");
			um0.load("Goessler");
		} catch (DataFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}

}
