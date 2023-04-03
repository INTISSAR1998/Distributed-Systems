import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITableau extends Remote {
	public double moyenne(Objet t) throws RemoteException;
	public int min(Objet t) throws RemoteException;
    public double[] returntab()throws RemoteException;
}
