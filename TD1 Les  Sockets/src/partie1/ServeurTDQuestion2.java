package partie1;
import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;


public class ServeurTDQuestion2 {
	ServerSocket s;
	ServeurTDQuestion2 ()
	{
		try {
			s=new ServerSocket(1234);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur"+e.getMessage());
		}
	}
	void ecouter()
	{
		//while(true) 
		//{ 
			try {
				Socket clientSocket = s.accept(); 
				System.out.println("Je vais envoyer la date");
				envoyerDate(clientSocket); 
				premier(clientSocket);
				clientSocket.close(); 
			//	System.out.println("Le client quitte\nEn attente d'un nouv. client");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur"+e.getMessage());
			}
		//} 
	}
	void envoyerDate(Socket clientSocket)
	{
		try {
			PrintStream out =  new PrintStream(clientSocket.getOutputStream()); 
			out.println("Nous somme le "+new Date());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur"+e.getMessage());
		} 
	}
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
	void afficherPremier(int n)
	{
		if(n<=3) System.out.println("Pas de nombre premier inférieur à "+n);
		else
			for(int i=2; i<n; i++)
			{
				if (estPremier(i))
					System.out.println("Nombre premier < "+n+" : "+i );
			}
	}
	int pgcd(int m, int n)
	{
		int r;
		while(m%n!=0)
		{
			r=m%n;
			m=n;
			n=r;
		}
		return n;
	}
	boolean premierEntre(int m, int n)
	{
		return pgcd(m,n)==1;
	}
	void premier(Socket clientSocket)
	{
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			int p = Integer.parseInt(in.readLine());
			//Verifier s il est premier
			if(estPremier(p)) System.out.println(p+" : nombre premier");
			//afficher tous les nbres premiers inférieurs à p
			afficherPremier(p);
			String Liste=in.readLine();
			StringTokenizer s = new StringTokenizer(Liste);
			int m=Integer.parseInt(s.nextToken());
			int n=Integer.parseInt(s.nextToken());
			PrintStream out =  new PrintStream(clientSocket.getOutputStream()); 
			out.println("Premier entre eux : "+premierEntre(m,n));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur"+e.getMessage());
		} 
	}
	public static void main(String arg[])
	{
		ServeurTDQuestion2 s= new ServeurTDQuestion2();
		s.ecouter();
	}
}
