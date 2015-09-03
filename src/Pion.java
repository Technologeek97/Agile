public class Pion 
{
	private int x;
	private int y;
	private int couleur;//0 vide -1 noir 1 blanc
	
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
	
	public void EchangerCouleur()
	{
		this.couleur *=-1;
	}
}
