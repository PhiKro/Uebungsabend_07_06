package personenmanagement;

public class Demo {

	public static void main (String Args[]) throws PersonenManagerExceptio{
		
		Personenmanager manager = new Personenmanager();
		
		manager.load("e:\\PRGTEMP\\user.txt");
		
		for (Person p : manager.getManager())
		{
			System.out.println(p);
		}
	}
	
}
