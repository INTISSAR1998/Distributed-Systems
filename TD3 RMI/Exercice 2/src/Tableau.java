import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Tableau extends UnicastRemoteObject implements ITableau {
	
	protected Tableau() throws RemoteException {
		super();	
	}
	
	public double [] returntab() throws RemoteException {
		double tab1 []= {1.2 , 15 , 9 , 5 ,0};
		return(tab1);
	}

	public double moyenne(Objet t) throws RemoteException {
		
		int s=0;
		for(int i=0;i<t.tab1.length;i++) {
		s+=t.tab1[i];
		}
		return (s/(t.tab1.length));
	}

	@Override
	public int min(Objet t) throws RemoteException {
		double min=t.tab1[0];
		int imin=0;
		for(int i=1;i<t.tab1.length;i++) {
			if(t.tab1[i]<min) {
			min=t.tab1[i];imin=i;
			}
	}
		return imin;
	}

}
