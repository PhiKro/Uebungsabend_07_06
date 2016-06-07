package network;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;

public class Networking {

	public static void main(String Args[]) throws IOException {

		URL test = new URL("http://www.orf.at");
		File file = new File("e:\\PRGTEMP\\http.htm");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(test.openStream()));
				PrintWriter pw = new PrintWriter(new FileWriter(file));
				BufferedReader ui = new BufferedReader(new InputStreamReader(System.in));)
		{
			if (file.exists())
				{
				System.out.println("Das gewünschte file existiert bereits");
				System.out.println("Überschreiben Y / N ? ");
				String answer = ui.readLine();
				if (!answer.matches("y"))
						{
					
						}
				else {
						String line;
						while ((line = br.readLine()) != null) 
						{
							System.out.println(line);
							pw.println(line);
						}
								}
						}}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	

}}
