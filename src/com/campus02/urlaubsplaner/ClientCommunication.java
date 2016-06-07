package com.campus02.urlaubsplaner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientCommunication implements Runnable {
	static Socket sock;
	static UrlaubManager um;

	public ClientCommunication(Socket sock, UrlaubManager um) {
		ClientCommunication.sock = sock;
		ClientCommunication.um = um;
	}

	public static void process() {
		try (Socket client = sock;
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()))) {
			while (true) {
				String[] arry = br.readLine().split(" ");
				if (arry[0].equalsIgnoreCase("get")) {
					ArrayList<Urlaub> result = um.load(arry[1]);

					for (Urlaub urlaub : result) {
						pw.println(urlaub.toString());
						pw.flush();
					}

				} else if (arry[0].equalsIgnoreCase("exit")) {
					client.close();
					break;
				}
				else {
					pw.println("Falscher Input");
					pw.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		process();
	}

}
