package personenmanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Personenmanager {
	
	ArrayList<Person> manager= new ArrayList<>();
	
	public void load (String f) throws PersonenManagerExceptio
	{
		try (BufferedReader br = new BufferedReader(new FileReader(new File(f))))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
			String[] pers = line.split(";");
			if (pers.length != 3)
			{
				throw new PersonenManagerExceptio("Üngültiges CSV File: "+pers.length + " statt 3 Spalten angegeben");
			}
		else 
		{
			Person load = new Person (pers[0],pers[1],pers[2]);
			manager.add(load);
		}	
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Datei nicht gefunden. Bitte Pfad und Berechtigungen Prüfen!");
			throw new PersonenManagerExceptio(e);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			throw new PersonenManagerExceptio(e);
		}
}

	public ArrayList<Person> getManager() {
		return manager;
	}
}
