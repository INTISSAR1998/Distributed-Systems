package tcp.server;
import java.io.*;
import java.net.*;

public class Serveur { 
public static void main(String[] args) { 
try { 
ServerSocket listenSocket = new ServerSocket(Integer.parseInt(args[0])); 
while(true) 
{ Socket clientSocket = listenSocket.accept(); 
doService(clientSocket); 
System.out.println("Le client quitte\nEn attente d'un nouv. client");
clientSocket.close(); } } 
catch (Exception e) { 
	System.out.println("Erreur"+ e.getMessage());
	} 
}
static void doService(Socket clientSocket) throws IOException 
{BufferedReader in = new BufferedReader( 
new InputStreamReader(clientSocket.getInputStream())); 
PrintStream out =  new PrintStream(clientSocket.getOutputStream()); 
while(true) 
{ String theLine=in.readLine(); 
if(theLine==null)
break;
System.out.println(theLine);
//trt sur theLine reçu
out.println(theLine); 
} } // doService 
} // class EchoServer 
