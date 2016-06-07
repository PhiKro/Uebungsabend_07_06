package com.campus02.urlaubsplaner;

public class Urlaub {

	private int id;
	private String mitarbeiter;
	private String von;
	private String bis;
	static int counter = 1;

	public Urlaub(String mitarbeiter, String von, String bis) {
		super();
		this.id = counter;
		this.mitarbeiter = mitarbeiter;
		this.von = von;
		this.bis = bis;
		counter++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(String mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public String getVon() {
		return von;
	}

	public void setVon(String von) {
		this.von = von;
	}

	public String getBis() {
		return bis;
	}

	public void setBis(String bis) {
		this.bis = bis;
	}

	@Override
	public String toString() {
		return "Urlaub [id=" + id + ", mitarbeiter=" + mitarbeiter + ", von=" + von + ", bis=" + bis + "]";
	}

}
