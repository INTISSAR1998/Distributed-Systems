import java.io.Serializable;
import java.rmi.*;
import java.rmi.server.*;
public class RoueImplementation extends UnicastRemoteObject implements Roue, Serializable{

public static final long serialVersionUID = 1L;
static int ID = 0;
String couleur;
int id = ID++;
public RoueImplementation() throws RemoteException{
couleur = "rouge";
}
public String getCouleur() throws RemoteException{
return couleur;
}
public void setCouleur( String couleur ) throws RemoteException{
this.couleur = couleur;
}
}
