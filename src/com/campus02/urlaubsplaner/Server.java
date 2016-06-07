package com.campus02.urlaubsplaner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try (ServerSocket ssocket = new ServerSocket(1337);) {
			UrlaubManager um0 = new UrlaubManager("e:\\Java\\Urlaub.txt");
			Socket client;
			while (true) {
				client = ssocket.accept();
				Thread th = new Thread(new ClientCommunication(client, um0));
				th.start();}
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
