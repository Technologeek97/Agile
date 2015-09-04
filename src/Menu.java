import java.util.Scanner;


public class Menu 
{
	public static void main(String[] args) 
	{
		while(true)
		{
			System.out.println(" 1-Jouer \n 2-Règles \n 3-Quitter");
			System.out.println("Indiquez un chiffre :");
			Scanner s = new Scanner(System.in);
			String input = s.next();
			
			while(!input.matches("[1-3]{1}")){
				System.out.println("Saisie invalide");
				s.next();
			}
			if(input.equals("1"))
			{
				new NewEssai();
			}
			else if(input.equals("2"))
			{
				System.out.println("Rond commence toujours la partie. \n" +
						"Puis les joueurs jouent à tour de rôle, chacun étant tenu de capturer des pions adverses lors de son mouvement.\n" +
						"Si un joueur ne peut pas capturer de pion(s) adverse(s), il est forcé de passer son tour.\n" +
						"Si aucun des deux joueurs ne peut jouer, ou si le plateau ne comporte plus de case vide, la partie s'arrête. \n" +
						"Le gagnant en fin de partie est celui qui possède le plus de pions.\n"+
						"La capture de pions survient lorsqu'un joueur place un de ses pions à l'extrémité d'un alignement de pions adverses contigus \n" +
						"et dont l'autre extrémité est déjà occupée par un de ses propres pions. \n" +
						"Les alignements considérés peuvent être une colonne, une ligne, ou une diagonale. \n" +
						"Si le pion nouvellement placé vient fermer plusieurs alignements, il capture tous les pions adverses des lignes ainsi fermées. \n" +
						"La capture se traduit par le retournement des pions capturés. \n" +
						"Ces retournements n'entraînent pas d'effet de capture en cascade : seul le pion nouvellement posé est pris en compte.\n");
			}
			else if(input.equals("3"))
			{
				System.exit(0);
			}
			
		}
		
	}
}
