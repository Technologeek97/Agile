import java.util.Scanner;

public class NewEssai {
	Plateau a = new Plateau();
	boolean fin = false;
	int joueur = 0;

	public static void main(String[] args) {

		new NewEssai();
	}

	NewEssai() {
		System.out.println("Les O commencent la partie !");
		while (!fin) {
			System.out.println(a);

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Joueur " + (joueur + 1)
					+ " : Entrez vos coordonnées :");

			String coord = scan.nextLine();

			Pion pos1 = poserUnPion(coord);
			
			boolean encoreUneLigne = true;
			
			while(encoreUneLigne){
				
			System.out.println("Entrez les coordonnées de l'autre extrémité pour retourner la ligne");
			String coord2 = scan.nextLine();
			Pion pos2 = poserUnPion(coord2);
					
			
			a.inverserLigne(rechercheChaine(pos1, pos2));
			System.out.println(a);
			System.out.println("Y a-t-il encore des lignes à retourner ? (O/N)");
			String rep = scan.nextLine();
			if (rep.equals("N") || rep.equals("n")) {
				encoreUneLigne = false;
			}
			}
			fin = verifierFin();
			joueur = ++joueur % 2;

		}
		int score = 0;
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				score += a.tab[i][j].getCouleur();
			}
		}
		System.out.println(a);
		if (score == 0) {
			System.out.println("match null; nice job ;-P");
		} else {
			System.out.println("Le joueur "
					+ (score > 0 ? "1 (blanc)" : "2(noir)") + " a gagné");
		}

	}

	private Pion poserUnPion(String coord) {
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
			
			a.ajouterPion(new Pion(y, x, joueur == 1 ? -1:1)); 
				
		
			
		} catch (NumberFormatException e) {
			
				y = Integer.parseInt("" + deuxieme);
				if (y > 0 && y < 9) {
					y--;
				}
				x = (int) premier;
				if (x > 64 && x < 73) {
					x -= 65;
				}
				
				a.ajouterPion(new Pion(y, x, joueur == 1 ? -1:1)); 
				
		
		}
		return new Pion(y,x,joueur);

		}

	private boolean verifierFin() {
		boolean areturn = true;
		boolean resteNoir = false;
		boolean resteBlanc = false;
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if (a.tab[i][j].getCouleur() == 1) {
					resteBlanc = true;
				}
				if (a.tab[i][j].getCouleur() == -1) {
					resteNoir = true;
				}
				if (a.tab[i][j].getCouleur() == 0 && resteNoir && resteBlanc) {
					areturn = false;
				}
			}

		}
		return areturn;
	}
	
	private String rechercheChaine(Pion depart , Pion arrive){
		int x1 = depart.getX();
		int x2 = arrive.getX();
		int y1 = depart.getY();
		int y2 = arrive.getY();
		String rslt = "";
		
		if(x1 == x2){
			if(y1>y2){
			
				for (int i = y2; i < y1 ; i++) {
					rslt+=x1+" "+i+" ";
				}
			}
			if(y2>y1){
				for (int i = y1; i < y2; i++) {
					rslt+=x1+" "+i+" ";
				}
			}
		}else if( y1 == y2){
			if(x1>x2){
				for (int i = x2; i <x1; i++) {
					rslt+=i+" "+y1+" ";
				}
			}
			if(x2>x1){
				for (int i = x1; i <x2; i++) {
					rslt+=i+" "+y1+" ";
				}
			}
		}else if ( x1> x2 && y1<y2){
			for (int i = 0; i < x1-x2; i++) {
				rslt+=(x1-i)+" "+(y1+i)+" ";
			}
		}
		else if ( x1< x2 && y1<y2){
			for (int i = 0; i < x2-x1; i++) {
				rslt+=(x1+i)+" "+(y1+i)+" ";
			}
		}
		else if ( x1< x2 && y1>y2){
			for (int i = 0; i < x2-x1; i++) {
				rslt+=(x1+i)+" "+(y1-i)+" ";
			}
		}
		else if ( x1> x2 && y1>y2){
			for (int i = 0; i < x1-x2; i++) {
				rslt+=(x1-i)+" "+(y1-i)+" ";
			}
		}
		
		rslt+=x2+" "+y2;
	
		return rslt;
	}

}
