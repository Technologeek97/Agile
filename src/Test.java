
public class Test {

	public static void main (String args[]) {
		
		Plateau a = new Plateau();
		Pion p = new Pion (0,0,-1);
		System.out.println(a);
		a.ajouterPion(p);
		a.ajouterPion(new Pion(7,7,1));
		System.out.println("\n\n\n\n");
		System.out.println(a);

		a.echangerCouleur(p);
		System.out.println("\n\n\n\n");
		System.out.println(a);
	}
	
}
