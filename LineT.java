

public class LineT {
	/*
	 * Points de departs arrivé et epaisseur .Utilise au moment de l'affichage
	 */
	int x ;
	int y ;
	int x1;
	int y1 ;
	float taille = 3f ;
	ConteneurC cont ;
	
	public LineT(){}
	
	public LineT(int x, int y,int x1 ,int y1) {
		this.x = x;
		this.y = y;
		this.x1=x1;
		this.y1=y1;
	}

}
