
public class Calculatrice {
	int a =5, b=0;
	String op="/";
	float r;
	float calculer()
	{
		if (op.equals("/"))	
		try{
			r=a/b;
			System.out.println("ee");
		}
		catch (ArithmeticException e)
		{
			//e.printStackTrace();
		System.out.println("Erreur: division par 0");
		}
		return r;
	}
public static void main(String arg[])
{
	Calculatrice c =new Calculatrice();
	System.out.println(c.calculer());
	System.out.print("fin");
}
}