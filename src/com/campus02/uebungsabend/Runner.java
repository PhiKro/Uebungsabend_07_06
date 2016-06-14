package com.campus02.uebungsabend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Runner implements Runnable{
	
	private BufferedReader reader;
	private PrintWriter printWriter;
	private Socket client;
	private HashMap<String,ArrayList<String>> bets;
	
	
	public Runner( Socket client, HashMap<String, ArrayList<String>> bets) {
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			printWriter = new PrintWriter(client.getOutputStream());
		this.client = client;
		this.bets = bets;}
		catch(IOException e) {
			e.printStackTrace();
		}
	}


	public void processClient ()
	{
		try 
		{
			String line;
			String[] array;
				while ((line = reader.readLine())!= null)
				{
					array = line.split(" ");
					if (array[0].equalsIgnoreCase("put"))
					{
						put(array[1],array[2]);
					}
					else if (array[0].equalsIgnoreCase("ask"))
					{
						ask(array[1]);
					}
					else if (array[0].equalsIgnoreCase("next"))
					{
						changeState();
					}
					else if (array[0].equalsIgnoreCase("exit"))
					{
						TippServer.setRun(false);
					}
				}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}

	
	public void put(String name, String score)
	{
		if (TippServer.getStatus() != State.vor)
		{
			printWriter.println("Tippen nicht mehr erlaubt");
			printWriter.flush();
		}
		else {
		if (bets.containsKey(score))
		{
			ArrayList<String> temp = bets.get(score);
			temp.add(name);
			bets.put(score, temp);
		}
		else
		{
			ArrayList<String> temp = new ArrayList<>();
			temp.add(name);
			bets.put(score, temp);
		}
		printWriter.println("Tippen angenommen");
		printWriter.flush();
		}
	}
	
	public void ask (String score)
	{
		if (bets.containsKey(score))
		{
			printWriter.println("Auf " + score +" haben:");
			printWriter.println(bets.get(score));
			printWriter.println("gesetzt");
			printWriter.flush();
		}
		else 
		{
			printWriter.println("Bis jetzt hat noch niemand auf "+score +"gesetzt!");
			printWriter.flush();
		}
	}
	
	public void changeState()
	{
		switch (TippServer.getStatus()) {
		case vor:
			TippServer.setStatus(State.waerend);
			printWriter.println("Spiel hat begonnen");
			printWriter.flush();
			break;

		case waerend:
			TippServer.setStatus(State.nach);
			printWriter.println("Spiel ist zuende");
			printWriter.flush();
			break;
		case nach:
			printWriter.println("Kein Weiterer zustand möglich");
			printWriter.flush();
			break;

		}
	}
	@Override
	public void run() {
		processClient ();
		
	}
}
	


