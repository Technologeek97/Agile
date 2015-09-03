import java.util.ArrayList;
import java.util.List;


public class estPosable {
	public boolean estPosable(Pion p, Plateau tab){
		String chemins="";
		String tmp="";
		boolean b = false;
		int pas=1;
		if (p.getCouleur() != 0 || !estDansPlateau(p.getX(),p.getY())){
			return false;
		}
		for(int i=-1; i<=1; i++){
			
			for(int j=-1; j<=1; j++){
				
				if(estDansPlateau(p.getX()+i,p.getY()+j)){
					
					if(p.estCouleurOpposee(tab.getPion(p.getX()+i, p.getY()+j)/*tab[p.getX()+i][p.getY()+j]*/)){
						
						tmp+= p.getX()+i +" "+p.getY()+j+" ";
						while(tab[p.getX()+i - (p.getX()+i)*pas][p.getY()+j - (p.getY()+i)*pas].getCouleur() == p.getCouleur()*-1 
								&& estDansPlateau((p.getX() - (p.getX()+i)*pas),(p.getY()+j)*pas < 8
								|| tab[p.getX() - (p.getX()+i)*pas][p.getY() - (p.getY()+i)*pas].getCouleur() == p.getCouleur()
								&& estDansPlateau((p.getX() - (p.getX()+i)*pas),(p.getY()+j)*pas <8{
							tmp+= p.getX()+i - (p.getX()+i)*pas + " " + p.getY()+j - (p.getY()+i)*pas + " ";
							if (tab[p.getX() - (p.getX()+i)*pas][p.getY() - (p.getY()+i)*pas].getCouleur() == p.getCouleur()){
								b =true;
							}
							
							// NON FINIT : MANQUE DE VERIFIER SI ON NE SORT PAS DU TABLEAU EN LIGNE
							
							/*
							  estDansPlateau((p.getX() - (p.getX()+i)*pas),(p.getY()+j)*pas < 7) 
							 && ( tab[p.getX()+i - (p.getX()+i)*pas][p.getY()+j - (p.getY()+i)*pas].getCouleur() != 0
							  || b = false)
							 * 
							 * 
							 * tab[p.getX()+i - (p.getX()+i)*pas][p.getY()+j - (p.getY()+i)*pas].getCouleur() == p.getCouleur()*-1 
								&& estDansPlateau((p.getX() - (p.getX()+i)*pas),(p.getY()+j)*pas < 7)
								|| tab[p.getX() - (p.getX()+i)*pas][p.getY() - (p.getY()+i)*pas].getCouleur() == p.getCouleur()
								&& estDansPlateau((p.getX() - (p.getX()+i)*pas),(p.getY()+j)*pas < 7)
							 * 
							 */
							
							pas++;
							
							}
					}
				}
			}
		}
		
		
		
		return false;
	}
	
	
	public boolean estDansPlateau(int x, int y){
		return x > 0 || x < 8 || y > 0 || x < 8; 
	}
}

	// tab[p.getX() - (p.getX()+i)*pasX]
