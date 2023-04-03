package tcp.client;
import java.io.*;
import java.net.*;
public class Client { 
public static void main(String[] args) { 
Socket theSocket = null; 
BufferedReader theInputStream = null; 
BufferedReader userInput = null; 
PrintStream theOutputStream = null; 
String theLine = null; 
try { 
theSocket = new Socket(args[0], Integer.parseInt(args[1])); 
theOutputStream = new PrintStream(theSocket.getOutputStream()); 
theInputStream = new BufferedReader( 
new InputStreamReader(theSocket.getInputStream())); 
userInput = new BufferedReader( 
new InputStreamReader(System.in));
while(true) 
{ theLine = userInput.readLine(); 
if(theLine.equals("."))
	{theSocket.close();break; }
theOutputStream.println(theLine); 
System.out.println(theInputStream.readLine()); 
} 
} // try 
catch (UnknownHostException e) { 	System.out.println("Erreur"+ e.getMessage());} 
catch (IOException e) { 	System.out.println("Erreur"+ e.getMessage()); } 
finally 
{ try { 
if(theSocket!=null) theSocket.close(); 
if(theInputStream!=null) 
	theInputStream.close(); 

} catch (IOException e) { 	System.out.println("Erreur"+ e.getMessage()); } } 
} // main 
} // EchoClient 
