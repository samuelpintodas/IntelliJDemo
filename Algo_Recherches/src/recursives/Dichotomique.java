package recursives;

public class Dichotomique {
	
	
	 public static void main(String[] args)
	 {
	  int[] v = randomVecteur(12) ;
	  affiche(v) ;
	  System.out.println("indice du min : " +indice(v));
	 }
	 
	 public static void affiche(int[] vecteur)
	 {
	  for (int i = 0; i < vecteur.length; i++)
	  {
	   System.out.print(vecteur[i]+" ");
	  }
	  System.out.println();
	 }
	 
	 public static int[] randomVecteur(int taille) 
	 {
	  int[] result = new int[taille] ;
	  for (int i = 0; i < taille; i++)
	  {
	   result[i] = (int)(Math.random()*100) ;
	  }
	  return result ;
	  
	 }
	 
	 public static int indice(int[] vecteur)
	 {
	  int gauche = 0 ;
	  int droite = vecteur.length-1 ;
	  return rechRec(vecteur, gauche, droite) ;
	 }
	 
	 public static int rechRec(int[] vecteur, int gauche, int droite) 
	 {
	  //clause de finitude
	  if(droite==gauche) return gauche ;
	  
	  //pas récursif
	  int milieu = (droite+gauche)/2 ;
	  int indA = rechRec(vecteur, gauche, milieu);
	  int indB = rechRec(vecteur, milieu+1, droite);
	  
	  if(vecteur[indA]<vecteur[indB]) return indA ;
	  return indB ;
	 }
}
