
public class CalculatriceLigneCom {
	int a , b;
	String op="/";
	float r;
	CalculatriceLigneCom(int x, int y)
	{
		a=x;
		b=y;
	}
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
	CalculatriceLigneCom c =new CalculatriceLigneCom(Integer.parseInt(arg[0]),Integer.parseInt(arg[1]));
	System.out.println(c.calculer());
	System.out.print("fin");
}
}