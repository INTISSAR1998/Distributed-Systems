package partie2;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServiceUDP {
private DatagramSocket socket;
private InetAddress adresseIP;
private int port;
public ServiceUDP(String adresseDest, int portDest) throws IOException
{
	adresseIP = InetAddress.getByName(adresseDest);
	port = portDest;
}
public ServiceUDP(int portEcoute) throws IOException
{
	
}
public void envoyer(String mesg) throws IOException
{
	
}
public String recevoir() throws IOException
{
	String msg="";
	return msg;
}

public String getAdresse()
{
	String adr="";
	return adr;
}

}
