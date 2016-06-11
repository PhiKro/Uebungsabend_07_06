package com.campus02.chatserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatServer {

	public static void main(String Args[])
	{
		ArrayList<ChatClient> connectedUser = new ArrayList<>();
		HashMap<String, ChatClient> userNames = new HashMap<>();
		
	try (ServerSocket ssock = new ServerSocket(1337))
	{
		Socket client; 
		while (true)
		{
			client = ssock.accept();
			ChatClient chatCl = new ChatClient(connectedUser, client,userNames);
			connectedUser.add(chatCl);
			Thread th0 = new Thread(chatCl);
			th0.start();
			chatCl.sendMessage("Willkommen!");
			chatCl.sendMessage("Bitte Namen eingeben:");
			chatCl.sendMessage("Format <name>:[Name hier eingeben]");
			
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
}
