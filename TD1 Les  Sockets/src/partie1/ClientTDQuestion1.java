package partie1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
//import java.net.InetAddress;
import java.net.Socket;


public class ClientTDQuestion1 {
	Socket S_Client;
	ClientTDQuestion1(String add, int port)
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
			//pour l envoi
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			PrintStream theOutputStream = new PrintStream(S_Client.getOutputStream()); 
			//theOutputStream.println(userInput.readLine());
			
			//pour la reception
			BufferedReader in = new BufferedReader(new InputStreamReader(S_Client.getInputStream()));
			//String L=in.readLine();
			
			for(int i=0; i<10;i++)
			{
				theOutputStream.println(userInput.readLine());//envoyer
				String L=in.readLine();//recevoir
				System.out.println("En maj : "+L);//afficher le msg recu
			}
			theOutputStream.println("END");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static void main(String arg[])
	{
		ClientTDQuestion1 c= new ClientTDQuestion1("127.0.0.1",1234);
		c.communiquer();
	}
}
