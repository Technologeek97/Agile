import static org.junit.Assert.*;

import org.junit.Test;


public class PionTest 
{
	static Plateau a = new Plateau();
	
	@Test
	public void test_constructeur() 
	{
		Pion p = new Pion(10,20,1);
		if(p.getX()!=10)
		{
			fail("le x");
		}
		
		if(p.getY()!=20)
		{
			fail("le y");
		}
		
		if(p.getCouleur()!=1)
		{
			fail("la couleur");
		}
	}
	
	@Test
	public void test_echangerCouleur()
	{
		Pion p = new Pion(10,20,1);
		p.echangerCouleur();
		if(p.getCouleur()!=-1)
		{
			fail("retourne mal");
		}
		
		Pion p2 = new Pion(1,2,0);
		if(p2.getCouleur()!=0)
		{
			fail("retourne un vide");
		}
	}
	
	@Test
	public void test_toString()
	{
		Pion pb = new Pion(1,2,1);
		Pion p = new Pion(3,4,0);
		Pion pn = new Pion(5,6,-1);
		
		if(!pb.toString().equals("0"))
		{
			fail("blanc");
		}
		if(!p.toString().equals(" "))
		{
			fail("vide");
		}
		if(!pn.toString().equals("X"))
		{
			fail("noir");
		}
	}
	
	/*public void test_inverserLigne()
	{
		String s = "0 0 0 1 0 2 0 3 0 4";
		Pion p0 = new Pion (0,0,1);
		Pion p1 = new Pion (0,1,-1);
		Pion p2 = new Pion (0,2,-1);
		Pion p3 = new Pion (0,3,-1);
		Pion p4 = new Pion (0,4,1);
		a.ajouterPion(p0);
		a.ajouterPion(p1);
		a.ajouterPion(p2);
		a.ajouterPion(p3);
		a.ajouterPion(p4);
		
		if (a.inverserLigne(s)) {
			
		}
	}*/

}
