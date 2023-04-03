import java.rmi.*;
import java.rmi.server.*;
public class TableauServer {
public static void main(String[] args) {
try {
	
System.out.println("Server : Construction de l'implemetation");
Tableau tab=new Tableau();


System.out.println("Objet tableau lie dans le RMIregistry");
Naming.rebind("rmi://localhost:1099/MyTableau",tab);
System.out.println("Attente des invocations des clients ...");
}
catch(Exception e){
System.out.println("Erreur de liaison rmiregitry !");
System.out.println(e.toString());
}
}
}
