package partie1;

public class Premier {
	boolean estPremier(int n)
	{
		boolean b=false;
		if(n==3 || n==2)b=true;
		else
		for(int i=2; i<=n/2; i++)
		{
			if (n%i!=0)
				b=true;
			else 
				{ b=false; break;}
		}
		return b;
	}
	public static void main(String a[])
	{
		Premier p=new Premier();
		System.out.println(p.estPremier(17));
	}
}
