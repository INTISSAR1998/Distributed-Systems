package tcp.server;

import java.io.*;
import java.net.*;
public class MultiThreadServeur extends Thread { 
private Socket clientSocket; 
		MultiThreadServeur(Socket clientSocket) 
		{ this.clientSocket = clientSocket; } 
public static void main(String[] args) throws IOException { 
ServerSocket listenSocket = null; 
try { 
listenSocket = new ServerSocket(Integer.parseInt(args[0])); 
while(true) //le dispatcher est le thread qui exécute main() 
{ 
	Socket clientSocket = listenSocket.accept(); 
    //System.out.println(clientSocket.getInetAddress()); 
    MultiThreadServeur serviceThread =  new MultiThreadServeur(clientSocket); 
    serviceThread.start(); } 
} catch(Exception e){System.out.println("Erreur"+ e.getMessage());} 
finally{listenSocket.close();} 
} 
public void run() { 
try { doService(clientSocket); clientSocket.close(); } 
catch (IOException e) { System.out.println("Erreur"+ e.getMessage()); } } 

public void doService(Socket clientSocket) throws IOException 
{ BufferedReader in; 
PrintStream out; 
in = new BufferedReader( 
new InputStreamReader(clientSocket.getInputStream())); 
out = new PrintStream(clientSocket.getOutputStream()); 
while(true) { 
String theLine=in.readLine(); 
if(theLine.equals(".")) break;//thread de service doit terminer 
out.println(this.getName()+ " write "+theLine); } 
} // doService 
} // classe EchoServer_multithread

