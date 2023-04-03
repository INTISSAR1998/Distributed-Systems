
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface reverseInterface extends Remote {
	String reverseString(String chaine) throws RemoteException;

}
