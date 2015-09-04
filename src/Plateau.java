
public class Plateau {

	
	Pion[][] tab;

	public Plateau() {
		tab = new Pion[8][8];

		// initialiser les 4 pions centraux
		// 1 - blanc
		// -1 - noir
		this.initialiser();
	}

	private void initialiser() {

		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				tab[i][j] = new Pion(i, j, 0);
			}
		}
		tab[3][3].setCouleur(1);
		tab[3][4].setCouleur(-1);
		tab[4][3].setCouleur(-1);
		tab[4][4].setCouleur(1);

	}

	public void ajouterPion(Pion p) {
		tab[p.getX()][p.getY()].setCouleur(p.getCouleur());
	}

	public void inverserLigne(String ligne) {
		String[] positions = ligne.split(" ");
		int x = Integer.valueOf(positions[0]);
		int y = Integer.valueOf(positions[1]);
		for (int i = 2; i < positions.length - 2; i += 2) {
			x = Integer.valueOf(positions[i]);
			y = Integer.valueOf(positions[i + 1]);
			getPion(x, y).echangerCouleur();
		}

	}

	public Pion getPion(int x, int y) {
		return tab[x][y];
	}
	
	public int getScore(int couleur) {
		int score = 0;
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if (tab[i][j].getCouleur() == couleur)
				score++;
			}
		}
		return score;
		
	}

	public String toString() {
		String ligne = "    A   B   C   D   E   F   G   H  \n";
		ligne += "  + - + - + - + - + - + - + - + - +\n";
		for (int i = 0; i <= 7; i++) {
			ligne += i + 1;
			for (int j = 0; j <= 7; j++) {
				ligne += " | " + tab[i][j] + "";
				
			}
			

			if(i==3){
				ligne += " |";
				ligne +="\t Score - Rond : "+getScore(1)+"\n";
				
			}
			else if(i==4){
				ligne += " |";
				ligne +="\t Score - Croix : "+getScore(-1)+ "\n";
			}
			else {
				ligne += " |\n";
			}
			ligne += "  + - + - + - + - + - + - + - + - +\n";
		}
		return ligne;
	}

}
