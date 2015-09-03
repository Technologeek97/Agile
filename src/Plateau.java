
public class Plateau {

	private Pion [][] tab;
	
	public Plateau() {
		tab = new Pion [8][8];
		
		// initialiser les 4 pions centraux
		//1 - blanc
		//-1 - noir
		this.initialiser();
	}
	
	private void initialiser(){
		
		for (int i=0;i<=7;i++){
			for (int j=0;j<=7;j++) {
				tab[i][j] = new Pion(i,j,0);
			}
		}
		tab[3][3].setCouleur(1);
		tab[3][4].setCouleur(-1);
		tab[4][3].setCouleur(-1);
		tab[4][4].setCouleur(1);
		
	}
	
	/*private boolean estVide(int x,int y){
		return tab[x][y].getCouleur()==0;
	}*/
	
	public void ajouterPion(Pion p){
		tab[p.getX()][p.getY()].setCouleur(p.getCouleur());
	}
	
	public void echangerCouleur(Pion p){
	
		p.echangerCouleur();
		this.ajouterPion(p);
		
	}
	
	public String toString() {
		String ligne="    A   B   C   D   E   F   G   H  \n";
		 ligne+= "  + - + - + - + - + - + - + - + - +\n";
		for (int i=0; i<=7; i++) {
			ligne+= i+1;
			for (int j=0; j<=7; j++) {
				ligne += " | "+ tab[i][j] + ""; 
			}
			ligne+=" |\n";
			ligne+="  + - + - + - + - + - + - + - + - +\n";
		}
		return ligne;
	}

}
