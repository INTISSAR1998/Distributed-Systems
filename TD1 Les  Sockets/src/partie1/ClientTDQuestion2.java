package partie1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
//import java.net.InetAddress;
import java.net.Socket;


public class ClientTDQuestion2 {
	Socket S_Client;
	ClientTDQuestion2(String add, int port)
	{
		try {
			S_Client = new Socket(add,port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	void communiquer()
	{
		try
		{
			//pour la reception
			BufferedReader in = new BufferedReader(new InputStreamReader(S_Client.getInputStream()));
			String date=in.readLine();//recevoir date
			System.out.println(date);
			
			//pour l envoi
			System.out.println("Donner un entier positif");//je suppose qu il est tjrs +
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));//pour lire du clavier
			PrintStream theOutputStream = new PrintStream(S_Client.getOutputStream()); 
			theOutputStream.println(Integer.parseInt(userInput.readLine()));
			
			//Envoyer une liste de deux entiers >0
			System.out.println("Donner une liste de deux entiers positifs separes par des espaces, exemple : 2 15 ou 2 6");
			theOutputStream.println(userInput.readLine());
			System.out.println(in.readLine()+"\nFIN");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static void main(String arg[])
	{
		ClientTDQuestion2 c= new ClientTDQuestion2("127.0.0.1",1234);
		c.communiquer();
	}
}
