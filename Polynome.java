

import java.util.ArrayList;



public class Polynome {
	
	/*
	  *FONCTION POLYNOMIALE 
	  *Analyseur de synthaxe
	 */
	private String fonction = "" ;
	
	// conteneur de données 
	ArrayList<Integer> coef = new ArrayList<Integer>() ;
	ArrayList<Integer> exp = new ArrayList<Integer>() ;
	ArrayList<Character> chara = new ArrayList<Character>() ;

	
	//conteneur de donnés derive
	ArrayList<Integer> coef2 = new ArrayList<Integer>() ;
	ArrayList<Integer> exp2 = new ArrayList<Integer>() ;
	
	
	ArrayList<Points> ppp = new ArrayList<Points>();
	
	public Polynome(String expo){ 
		fonction=expo ;
		
	}
	
	
	
	
	
	
	public static double puissance(double n, double p){
		double puis = n ;
		for(int i = 0 ; i < p-1 ; i++)
			puis = puis*n ;
	
		return puis ;
	}
	
	public void analyse(){
		boolean un = true ;
		String tmp = "" ;
		
		for(int i = 3 ; i < fonction.length() ; i++){
	
			
			if(estChiffre(fonction.charAt(i))){
				
					tmp += Character.getNumericValue(fonction.charAt(i)) ;	
				
					
			}else if((Character.toString(fonction.charAt(i))).equals("x")  ){
				un = false ;
				
				if(!tmp.equals(""))
					coef.add(Integer.parseInt(tmp));
				else
					coef.add(1);
				
					tmp = "";
					
			}else if(Character.toString(fonction.charAt(i)).equals("+") ||Character.toString(fonction.charAt(i)).equals("-")
					|| Character.toString(fonction.charAt(i)).equals("*") || Character.toString(fonction.charAt(i)).equals("/")  )
			{
				un = true ;
				chara.add(fonction.charAt(i));
				if(!tmp.equals("")){
					exp.add(Integer.parseInt(tmp));
				}
			
				tmp = "" ;
				if(Character.toString(fonction.charAt(i)).equals("-")){
				tmp = tmp + "-" ;	
				}
			}
				
			
		}
		
		if(!tmp.equals("") && un)
			coef.add(Integer.parseInt(tmp));
		else
			exp.add(Integer.parseInt(tmp));
		
		for(int  i = 0 ; i < coef.size() ; i++){
			System.out.println(coef.get(i)+"  dd");
		}
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
		for(int  i = 0 ; i < exp.size() ; i++){
			System.out.println(exp.get(i)+"ff");
		}
		
		for(int i  =0 ; i < chara.size() ; i++)
			System.out.println(chara.get(i));
		
	}
	/*
	 * verifie si char est un chiffre
	 */
	boolean estChiffre(char c){
		for(int i = 0 ; i < 10 ; i++){
			if(Character.getNumericValue(c) ==i)
				return true ;
		}
		return false ;
	
	}
	
	/*
	 * FOnction qui retourne y en fonction de X
	 */
	public double fonction(double x){
		double y = 0 ;
		for(int i = 0 ; i < exp.size(); i++){
			y = y +  coef.get(i)*puissance(x , exp.get(i)); 
		}
		if(exp.size() < coef.size()){
			y= y + coef.get(coef.size()-1);
		}
			
		return y ;
	}
	
	
	public void derive(){
		int size ;
		if(coef.size()==exp.size()){
			 size = coef.size() ;
		}else{
			size=coef.size()-1 ;
		}
		
			for(int  i = 0 ; i < size ; i++){
				coef2.add(coef.get(i)*exp.get(i));
				
				exp2.add(exp.get(i)-1);
			}
		
		
		for(int i  =0 ; i < coef2.size() ; i++){
			System.out.println(coef2.get(i)+"dev");
			System.out.println(exp2.get(i)+"dev");
		}
		
	}
	
	public double fonction2(double x){
		double y = 0 ;
		for(int i = 0 ; i < exp2.size(); i++){
			y = y +  coef2.get(i)*puissance(x , exp2.get(i)); 
		}
	
			
		return y ;
	}
	
	
	
	
	
	
	public static void main(String[]arg){
	Polynome po = new Polynome("pol:1") ;
	po.analyse() ;
	po.derive();
	System.out.println(po.fonction2(2));
	//System.out.println(po.fonction(0));
	
	
	/*String ccc = "-33";
	System.out.println(Integer.parseInt(ccc))
	;	
	*/
	}
}
