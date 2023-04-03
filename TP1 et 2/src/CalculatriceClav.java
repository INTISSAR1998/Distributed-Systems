import java.io.*;
import java.util.*;
public class CalculatriceClav {
	int a , b;
	String op="/";
	float r;
	CalculatriceClav(int x, int y)
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
public static void main(String arg[]) throws IOException
{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String L=in.readLine();
	StringTokenizer str2 = new StringTokenizer(L);
	//while(str2.hasMoreElements())
	CalculatriceClav c =new CalculatriceClav(Integer.parseInt(str2.nextToken()),Integer.parseInt(str2.nextToken()));
	System.out.println(c.calculer());
	System.out.print("fin");
}
}