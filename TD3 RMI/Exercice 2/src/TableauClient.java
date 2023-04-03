import java.rmi.*;
public class TableauClient {
	public static void main (String[] args) {
		try {
			//double tab1 []= {1.2 , 15 , 9 , 5 ,0};
			ITableau tab = (ITableau) Naming.lookup("rmi://localhost:1099/MyTableau");
			double tab1 []=tab.returntab();
			Objet t=new Objet();
			double moy = tab.moyenne(t);
			System.out.println("La moyenne est "+moy);
			double min = tab.min(t);
			System.out.println("La position du minimum est "+min);
			
		}catch (Exception e) {
			System.out.println("Erreur d'accés à l'objet distant");
			System.out.println(e.toString());
	}
	}
}
