import java.util.Scanner;

public class Essai {
	
	Plateau a = new Plateau();
	boolean fin = false;
	int joueur = 0;
	
	
	public static void main(String args[]) {
		new Essai();
	}
	
	Essai()
	{
		while(!fin){
		System.out.println(a);

		

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Joueur "+ (joueur+1) +" : Entrez vos coordonnées :");

		String coord = scan.nextLine();
		if(coord.length() !=2 ){
			coord+="9";
		}

		poserUnPion(coord);

		
		fin=verifierFin();
		joueur = ++joueur%2;
		
		}
		int score=0;
		for (int i = 0; i <= 7; i++) 
		{
			for (int j = 0; j <= 7; j++) 
			{
				score+=a.tab[i][j].getCouleur();
			}
		}
		System.out.println(a);
		if(score == 0)
		{
			System.out.println("match null; nice job ;-P");
		}
		else{
			System.out.println("Le joueur "+ (score>0 ? "1 (blanc)":"2(noir)") +" a gagné");
		}
		

	}
	
	private boolean verifierFin() {
		boolean areturn=true;
		boolean resteNoir = false;
		boolean resteBlanc = false;
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if(a.tab[i][j].getCouleur()==1)
				{
					resteBlanc=true;
				}
				if(a.tab[i][j].getCouleur()==-1)
				{
					resteNoir=true;
				}
				if(a.tab[i][j].getCouleur()==0 && resteNoir && resteBlanc){
					areturn=false;
				}
			}
			
		}
		return areturn;
	}

	private void poserUnPion(String coord) {
		char premier = coord.charAt(0);
		char deuxieme = coord.charAt(1);
		int y;
		int x;

		try {
			y = Integer.parseInt("" + premier);
			// ici x est lettre
			if (y > 0 && y < 9) {
				y--;
			}
			x = (int) deuxieme;
			if (x > 64 && x < 73) {
				x -= 65;
			}
			if (a.tab[y][x].getCouleur() == 0) {
				String chemain = estPosable(new Pion(y, x, joueur == 1 ? -1:1),a);
				if(chemain.equals(""))
				{
					System.err.println("coup rejeté: vous devez prendre pour jouer");
					joueur = ++joueur%2;
				}
				
				a.ajouterPion(new Pion(y, x, joueur == 1 ? -1:1)); 
			} else {
				System.err.println("Coup rejeté : place occupée");
				joueur = ++joueur%2;
			}
		} catch (NumberFormatException e) {
			try {
				y = Integer.parseInt("" + deuxieme);
				if (y > 0 && y < 9) {
					y--;
				}
				x = (int) premier;
				if (x > 64 && x < 73) {
					x -= 65;
				}
				if (a.tab[y][x].getCouleur() == 0) {
					String chemain = estPosable(new Pion(y, x, joueur == 1 ? -1:1),a);
					if(chemain.equals(""))
					{
						System.err.println("coup rejeté: vous devez prendre pour jouer");
						joueur = ++joueur%2;
					}
					a.ajouterPion(new Pion(y, x, joueur == 1 ? -1:1)); 
				} else {
					System.err.println("Coup rejeté : place occupée");
					joueur = ++joueur%2;
				}
			} catch (NumberFormatException er) {
				System.err.println("coup rejeté");
				joueur = ++joueur%2;
			} catch (Exception err) {
				System.err.println("coup rejeté");
				joueur = ++joueur%2;

			}
		}

		catch (Exception e) {
			System.err.println("coup rejeté");

		}
	}

	private String estPosable(Pion pion, Plateau a2) 
	{
		// TODO Auto-generated method stub
		return "TODO";
	}

}
