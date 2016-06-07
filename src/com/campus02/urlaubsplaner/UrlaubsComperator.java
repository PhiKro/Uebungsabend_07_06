package com.campus02.urlaubsplaner;

import java.util.Comparator;

public class UrlaubsComperator implements Comparator<Urlaub> {

	@Override
	public int compare(Urlaub o1, Urlaub o2) {
		int res = o1.getVon().compareTo(o2.getVon());
		if (res == 0) {
			int res2 = o1.getMitarbeiter().compareTo(o2.getMitarbeiter());
			return res2;
		}
		return res;
	}

}
