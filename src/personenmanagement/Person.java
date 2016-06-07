package personenmanagement;

public class Person {

	String name;
	String vorname;
	String geburtsort;
	
	public Person(String name, String vorname, String geburtsort) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.geburtsort = geburtsort;
	}

	@Override
	public String toString() {
		return "Person [Name=" + name + ", Vorname=" + vorname + ", Geburtsort=" + geburtsort + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getGeburtsort() {
		return geburtsort;
	}

	public void setGeburtsort(String geburtsort) {
		this.geburtsort = geburtsort;
	}
	
	
}
