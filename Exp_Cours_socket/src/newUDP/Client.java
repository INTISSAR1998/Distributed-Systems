package newUDP;

import java.net.*;

public class Client {
	
	final static int taille = 1024; 
	  final static byte buffer[] = new byte[taille];

	  public static void main(String argv[]) throws Exception 
	    { 
	      InetAddress serveur = InetAddress.getByName("localhost"); 
	      String msg="hello";
	      int length = msg.length(); 
	      byte buffer[] = msg.getBytes(); 
	      DatagramPacket dataSent = new DatagramPacket(buffer,length,serveur,Server.port); 
	      DatagramSocket socket = new DatagramSocket(); 
	  
	      socket.send(dataSent); 

	      DatagramPacket dataRecieved = new DatagramPacket(new byte[length],length); 
	      socket.receive(dataRecieved); 
	      System.out.println("Data recieved : " + new String(dataRecieved.getData())); 
	      System.out.println("From : " + dataRecieved.getAddress() + ":" + dataRecieved.getPort()); 
	    } 

}
