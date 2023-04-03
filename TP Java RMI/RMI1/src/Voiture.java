import java.rmi.*;
public interface Voiture extends Remote
{
public Roue getRoue() throws RemoteException;
public String getNewVoiture() throws RemoteException;
}
