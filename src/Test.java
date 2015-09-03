import java.util.Scanner;


public class Test {
	static Plateau a = new Plateau();

	public static void main (String args[]) {
		
	
		//Pion p = new Pion (0,0,-1);
		System.out.println(a);
		/*a.ajouterPion(p);
		a.ajouterPion(new Pion(7,7,1));
		System.out.println("\n\n\n\n");
		System.out.println(a);*/

		/*p.echangerCouleur();
		System.out.println("\n\n\n\n");
		System.out.println(a);*/
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Joueur 1 : Entrez vos coordonnées :");
		
		String coord = scan.nextLine();
		
		miseEnForme(coord);
		
		System.out.println(a);
			
	}

	private static void miseEnForme(String coord) {
		// TODO Auto-generated method stub
		char premier = coord.charAt(0);
		char deuxieme = coord.charAt(1);
		int y;
		int x;
		
		try {
			y = Integer.parseInt(""+premier);
			//ici x est lettre
			if(y>0 && y<9){
				y--;
			}
			x= (int)deuxieme;
			if(x>64 && x<72){
				x-=65;
			}
			a.ajouterPion(new Pion(y,x,1)); // TODO  Changer le 1 quand on aura les joueurs 
		} catch (NumberFormatException e) {
			try
			{
				// TODO: handle exception
				y = Integer.parseInt(""+deuxieme);
				if(y>0 && y<9){
					y--;
				}
				x= (int)premier;
				if(x>64 && x<72){
					x-=65;
				}
				a.ajouterPion(new Pion(y,x,1)); // TODO  Changer le 1 quand on aura les joueurs 
			}
			catch (NumberFormatException er) {
				System.err.println("coup rejeté");
			}
			}
			
		catch (Exception e) {
			System.err.println("coup rejeté");
			
		}
	}
	

	
}
