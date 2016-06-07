package com.campus02.urlaubsplaner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UrlaubManager {

	final String fileLocation;

	public UrlaubManager(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public ArrayList<Urlaub> load(String mitarbeiter) throws DataFileException {
		try (BufferedReader bf = new BufferedReader(new FileReader(new File(fileLocation)))) {
			ArrayList<Urlaub> result = new ArrayList<>();
			String line;
			String[] ma;
			while ((line = bf.readLine()) != null) {

				ma = line.split(";");
				if (ma[1].equals(mitarbeiter)) {
					Urlaub url = new Urlaub(ma[1], ma[2], ma[3]);
					result.add(url);
					// System.out.println(url);
				} else {
					continue;
				}

			}
			Collections.sort(result, new UrlaubsComperator());
			return result;
		}

		catch (FileNotFoundException e) {
			throw new DataFileException("Fehler in Zeile: ", e);
		} catch (IOException e) {
			throw new DataFileException(e);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
