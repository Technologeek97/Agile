import org.junit.Assert;
import org.junit.Test;

public class PlateauTest {
	
	static Plateau plateau = new Plateau();
	
	@Test
	public void test_inverserLigne_avec_3_pions()
	{
		//Given
		String s = "0 0 0 1 0 2";
		plateau.ajouterPion(new Pion (0,0,Pion.BLANC));
		plateau.ajouterPion(new Pion (0,1,Pion.NOIR));
		plateau.ajouterPion(new Pion (0,2,Pion.BLANC));

		// When
		plateau.inverserLigne(s);
		
		//Then
		Assert.assertEquals(Pion.BLANC, plateau.getPion(0, 1).getCouleur());
			
	}
	
	@Test
	public void test_inverserLigne_avec_2_pions()
	{
		//Given
		String s = "0 0 0 1";
		Pion p0 = new Pion (0,0,1);
		Pion p1 = new Pion (0,1,1);
		plateau.ajouterPion(p0);
		plateau.ajouterPion(p1);

		// When
		plateau.inverserLigne(s);
		
		//Then
		Assert.assertEquals(1, plateau.getPion(0, 1).getCouleur());
			
	}
	
}
