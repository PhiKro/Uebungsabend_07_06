package com.campus02.uebungsabend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;



public class TippServer {
	private static State status = State.vor;
	private static boolean run = true;
	private static ArrayList<Socket> betters = new ArrayList<>();
	


static HashMap<String, ArrayList<String>> tipps = new HashMap<String, ArrayList<String>>();
	
	public static void main (String Args[]){
	
	try (ServerSocket ssock = new ServerSocket(3333);) {
		Socket client;
		while (run == true)
		{
			client = ssock.accept();
			betters.add(client);
			Runner tip = new Runner(client, tipps);
			Thread runner = new Thread (tip);
			runner.start();
			if (run == false)
			{
				ssock.close();
				System.out.println("Server wurde beendet");
				for (Socket socket : betters) {
					socket.close();
				}
				break;
			}
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}

	}

	public static boolean isRun() {
		return run;
	}

	public static void setRun(boolean run) {
		TippServer.run = run;
	}

	public static State getStatus() {
		return status;
	}

	public static void setStatus(State status) {
		TippServer.status = status;
	}
}
