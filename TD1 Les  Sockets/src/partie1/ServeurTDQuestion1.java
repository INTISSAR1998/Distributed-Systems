package partie1;
import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServeurTDQuestion1 {
	ServerSocket s;
	ServeurTDQuestion1 ()
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
		while(true) 
		{ 
			try {
				Socket clientSocket = s.accept(); 
				System.out.println("Nouv client");
				doService(clientSocket); 
				clientSocket.close(); 
				System.out.println("Le client quitte\nEn attente d'un nouv. client");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur"+e.getMessage());
			}
		} 
	}
	void doService(Socket clientSocket)
	{
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while(true){
				String L=in.readLine();
				if(L.equals("END")) 
					break;
				L=L.toUpperCase();
				System.out.println("En maj : "+L);
				PrintStream out =  new PrintStream(clientSocket.getOutputStream()); 
				out.println(L);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur"+e.getMessage());
		} 
	}
	
	public static void main(String arg[])
	{
		ServeurTDQuestion1 s= new ServeurTDQuestion1();
		s.ecouter();
	}
}
