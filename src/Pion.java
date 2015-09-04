public class Pion 
{
	private int x;
	private int y;
	private int couleur;//0 vide -1 noir 1 blanc
	public static final int NOIR = -1;
	public static final int BLANC = 1;
	
	Pion(int x,int y,int couleur)
	{
		this.setX(x);
		this.setY(y);
		this.setCouleur(couleur);
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public int getCouleur() 
	{
		return couleur;
	}

	public void setCouleur(int couleur) 
	{
		this.couleur = couleur;
	}
	
	public void echangerCouleur()
	{
		this.setCouleur(this.couleur*-1);
	}
	
	public String toString(){
		String s = "";
		if(this.getCouleur()==0){
			s=" ";
		}
		else if(this.getCouleur()==1){
			s="O";
		}
		else if(this.getCouleur()==-1){
			s="X";
		}
		return s;
	}
	
	public boolean estCouleurOpposee(Pion p){
		return p.getCouleur() == this.getCouleur()*-1;
	}
	
	public String estPosable(Plateau plateau, int joueur) {
		String rslt = "";
		Pion pionEnvironnant;
		Pion pionEloigne;
		Pion pionPrecedent;
		boolean encoreUnApres = false;
		int cpt;
		
		// Verifier la couleur du joueur
		int couleur;
		if (joueur == 1) {
			couleur = 1;
		} else {
			couleur = -1;
		}

		
		// Le pion capture-t-il des pions ennemis ? Differenciez observations cases alentours selon position (centrale, coin, bordure)
		if (this.estDansPlateau(plateau)) {
		// Coin
		
		
		// Bordure
		
		
		// Centrale
		
			for (int i = -1; i <= 1; i++) {
				
				for (int j = -1; j <= 1; j++) {
					cpt = 2;
					pionEnvironnant = plateau.getPion(this.getX()+i, this.getY()+j);
					System.out.println(pionEnvironnant.getX() + " " + pionEnvironnant.getY());
					
					if (i == 0 && j == 0) {
						// Ne rien faire... Barbare, peut-etre
						
					} else if (couleur == pionEnvironnant.getCouleur() * -1) { 
						rslt+=this.getX() + " " + this.getY() + " ";
						rslt+=pionEnvironnant.getX() + " " + pionEnvironnant.getY() + " ";
						encoreUnApres = true;
						
						while(encoreUnApres) {
							System.out.println(this.getX() + " " + this.getY() + " " + i + " " + j + " " + cpt);
							pionEloigne = plateau.getPion((this.getX() + i*cpt), (this.getY() + j*cpt));
							pionPrecedent = plateau.getPion(this.getX() + i*(cpt-1), this.getY() + j*(cpt-1));
							if (pionEloigne.estDansPlateau(plateau)) {
								
								if (couleur == pionEloigne.getCouleur()*-1) {
									rslt+= (this.getX() + i*cpt) + " " + (this.getY() + j*cpt) + " ";
									cpt++;
								} else if (couleur == pionEloigne.getCouleur()*-1 
										&& pionEloigne.getX() == 0 || pionEloigne.getX() == plateau.tab.length 
											|| pionEloigne.getY() == 0 || pionEloigne.getY() == plateau.tab[0].length
										&& pionPrecedent.getX() != 0 || pionPrecedent.getX() != plateau.tab.length 
											|| pionPrecedent.getY() != 0 || pionPrecedent.getY() != plateau.tab[0].length
										) {
									rslt = "";
									encoreUnApres = false;
									
								} else if (pionEloigne.getCouleur() == 0) {
									rslt="";
									encoreUnApres = false;
									
								} else if (couleur == pionEloigne.getCouleur()) {
									rslt+= (this.getX() + i*cpt) + " " + (this.getY() + j*cpt);
									encoreUnApres = false;
									plateau.inverserLigne(rslt);
								}
							} else {
								encoreUnApres = false;
								rslt = "";
							}
						}
					}
				}
			}
		}
		
		return rslt;
	}
	
	public boolean estDansPlateau(Plateau plateau) {
		return this.getX() >= 0 || this.getX() < plateau.tab.length || this.getY() >= 0 || this.getY() < plateau.tab[0].length;
	}
	
	public boolean estVide() {
		return this.getCouleur() == 0;
	}
}
