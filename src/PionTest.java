import static org.junit.Assert.*;

import org.junit.Test;


public class PionTest 
{
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
	public void test_EchangerCouleur()
	{
		Pion p = new Pion(10,20,1);
		p.EchangerCouleur();
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

}
