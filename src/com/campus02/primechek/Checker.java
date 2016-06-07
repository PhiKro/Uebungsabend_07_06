package com.campus02.primechek;


public class Checker implements Runnable
{
		private double zahl;
		private boolean isPrime;
		public Checker(double zahl) {
			super();
			this.zahl = zahl;
			this.isPrime = true;
			}
//Math.sqrt
		@Override
		public void run() {
			for (int i = 2; i < Math.cbrt(zahl); i++) 
			{
			if ((zahl%i == 0 ))
					{
					isPrime =false;
					System.out.println(zahl + " ist keine Primzahl" );
					break;}
			
			}
			if (isPrime == true){
			System.out.println(zahl + " ist eine Primzahl");}
		}
	
	
	}