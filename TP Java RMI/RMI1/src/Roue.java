import java.rmi.*;
public interface Roue extends Remote
{
public String getCouleur() throws RemoteException;
public void setCouleur( String couleur ) throws RemoteException;
}
