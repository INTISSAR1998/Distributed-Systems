import java.rmi.Naming;
// l'adresse du serveur devra être passé en paramètre à l'exécution du client
public class Client
{
public static void main( String [] args )
{
try{
// on récupère la liste des noms des objets disponibles
String [] objetsDispo = Naming.list( "rmi://localhost:1099" );
for( String o : objetsDispo )
{
System.out.println( o );
}

// on récupère un pointeur sur le premier objet Voiture
Voiture voiture = (Voiture) Naming.lookup( objetsDispo [0] );

// voiture.getRoue() retourne un pointeur sur l'objet Roue de l'objet voiture courant
System.out.println( voiture.getRoue().getCouleur() );
voiture.getRoue().setCouleur( "vert" );
System.out.println( voiture.getRoue().getCouleur() );

// on récupère un pointeur sur le nouvel objet distant créé
Voiture v = (Voiture) Naming.lookup(voiture.getNewVoiture());

// getNewVoiture() crée un nouvel objet VoitureImplementation
System.out.println( v.getRoue().getCouleur() );
v.getRoue().setCouleur( "rose" );
System.out.println( v.getRoue().getCouleur() );
}
catch( Exception e ){
e.printStackTrace();
}
}
}
