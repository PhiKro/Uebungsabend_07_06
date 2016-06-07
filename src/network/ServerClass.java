package network;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;


public class ServerClass  {

	public static void main (String Args[]){
		// There is no place like 127.0.0.1!
		try (
		Socket test = new Socket("news.orf.at", 80); // Verbindung aufbauen
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(test.getOutputStream())); //Sender Kanal aufbauen
		BufferedReader br = new BufferedReader(
				new InputStreamReader(test.getInputStream()));  //Empfänger Kanal aufbauen
		PrintWriter pw = new PrintWriter(
				new BufferedWriter(new FileWriter(new File("e:\\PRGTEMP\\dl.txt")))); //File Ausgabe vorbereiten
		PrintWriter er = new PrintWriter(
						new BufferedWriter(new FileWriter(new File("e:\\PRGTEMP\\error.txt")))); //File Ausgabe vorbereiten
		)
		{
		// Telnetsession nutzen:
		bw.write("GET / HTTP 1.1 \r \n Host: news.orf.at \r\n\r\n"); // Erstellt die Anfrage an den Server 
		bw.flush(); // Übermittelt die Abfrage an den Server 
	
		
		String line = br.readLine();// Standard Filewrite 
		if (!line.contains("200")) // Prüfung ob Server die Seite oder einen Fehler schickt 
		{
			while ((line =br.readLine())!= null) // Bis zur letzten Zeile abarbeiten 
			{
				er.println(line); // Schreibt die aktuelle Line in das im oberen Block definierte Error File 
			} 
			throw new ServerResponceExeption("Server hat kein OK zurück gegeben");
		}
		else{
			pw.println(line);
		while ((line =br.readLine())!= null) // Bis zur letzten Zeile abarbeiten 
			{
				pw.println(line); // Schreibt die aktuelle Line in das im oberen Block definierte File 
				System.out.println(line); // Gibt die Line zur kontrolle auf der Konsole aus. 
			} 
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (ServerResponceExeption e) {
			e.printStackTrace();
		}

}
}
