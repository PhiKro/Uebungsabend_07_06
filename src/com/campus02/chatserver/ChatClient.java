package com.campus02.chatserver;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatClient implements Runnable{

	private BufferedReader reader;
	private PrintWriter printWriter;
	private ArrayList<ChatClient> clients;
	private Socket client;
	private String name;
	private HashMap<String, ChatClient> userNames;
	
	
	
	public ChatClient(ArrayList<ChatClient> clients, Socket client, HashMap<String, ChatClient> userNames) {
		try 
		{
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			printWriter = new PrintWriter(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.clients = clients;
		this.client = client;
		this.userNames = userNames;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		userNames.put(this.name, this);
	}

	
	
	
	public void sendMessage(String message)
	{
		printWriter.println(message);
		logMessage(message);
		printWriter.flush();
	}


	@Override
	public void run() 
	{
		while (true)
		{
			String message = "";
			try {
				message = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] input1 = message.split(":");
			if(this.getName() == null && !(input1[0].equals("<name>")))
			{
				printWriter.println("!Sie können ohne einen Nick nicht Chatten bitte vergeben Sie einen Namen!");
				printWriter.flush();
			}
			else {
			if (input1[0].equals("<name>")&& input1.length ==2){
				if (userNames.containsKey(input1[1]))
				{
					printWriter.println("Nick bereits vergeben, bitte wählen Sie einen anderen!");
				}
				else{
				newUser(input1);
				}
				}
			else if (input1[0].equalsIgnoreCase("<msg>"))
			{
				sendToAll(input1);
			}
			else if (input1[0].equalsIgnoreCase("<msgto>") && input1.length == 3)
			{
				sendToUser(input1);
				
			}
			else if (input1[0].equalsIgnoreCase("<bye>")){
				close();
				break;}
			
			else
				printWriter.println("Wrong Command");
				printWriter.flush();
		}
		}
	}

	private void sendToUser(String[] input1) {
		if(userNames.containsKey(input1[1]))
		userNames.get(input1[1]).sendMessage("Private Nachricht von "+this.getName() + ": " + input1[2]);
		else{
			printWriter.println("Gewuenschter User nicht vorhanden");
			printWriter.flush();
			}
		//				
//				for (ChatClient client : clients) 
//				{
//					if (client.getName().equalsIgnoreCase(input1[1]))
//					client.sendMessage("Private Nachricht von "+this.getName() + ": " + input1[2]);
//				}
	}

	private void sendToAll(String[] input1) {
		for (ChatClient client : clients) 
		{
			client.sendMessage(this.getName()+ ": " + input1[1]);
		}
	}

	private void newUser(String[] input1) {
		this.setName(input1[1]);
		for (ChatClient client : clients) 
		{
			client.sendMessage(this.getName()+ " hat sich verbunden");
		}
	}
	
	
	public void close()
	{
		for (ChatClient client : clients) 
		{
			client.sendMessage(this.getName()+ " hat sich abgemeldet");
		}
		
		try {
			
			printWriter.println("Good Bye");			
			this.reader.close();
			this.printWriter.flush();
			this.printWriter.close();
			this.client.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			clients.remove(this);
		}

	}
	
	public void logMessage(String message)
	{
		try (PrintWriter logWriter = new PrintWriter(new FileOutputStream("E:\\Java\\chat.log",true),true);){
			logWriter.println(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
