package iteratives;

public class trichotomique {
 
 static int tab[] = {23, 42, 2, 1, 6, 4, 78, 51, 37, 13};

 public static void main(String[] args) {
  // TODO Auto-generated method stub
   
  tri(tab);
  displayTab();
  searchTrichotomic(5);
  
 }
 
 public static int searchTrichotomic(int target){

  int iDebut = 0;
  int iFin  = tab.length-1;
  int milieu1, milieu2;

  while(iDebut <= iFin){
   
   milieu1 = (2*iDebut + iFin)/3;
   milieu2 = (iDebut + 2*iFin)/3;

   if(target == tab[milieu1]){
    System.out.println(target + " trouvé à l'index [" + milieu1 + "]");
    return milieu1;
   }
   if(target == tab[milieu2]){
    System.out.println(target + " trouvé à l'index [" + milieu1 + "]");
    return milieu2;
   }
   if(target < tab[milieu1]){

    iFin = milieu1 - 1;

   }else if(target > tab[milieu2]){

    iDebut = milieu2 + 1;

   }else{

    iFin = milieu2 - 1;
    iDebut = milieu1 + 1;
   }
   
  }
  
  System.out.println("Le " +target + " n'est pas dans le tableau");
  return -1;
 }
 
 private static void tri(int[] tab) {

  int tempNbr;
  boolean ordered = false;
  int i = 0;

  while (!ordered) {
   ordered = true;
   for (i = 0; i < tab.length - 1; i++) {
    if (tab[i] > tab[i + 1]) {
     tempNbr = tab[i];
     tab[i] = tab[i + 1];
     tab[i + 1] = tempNbr;
     ordered = false;
    }
   }
  }

 }
 
 private static void displayTab()
 {
  System.out.print("[ ");
  for (int i = 0; i < tab.length; i++) {
   
   System.out.print(tab[i] + " ");
  }
  System.out.print("]\n");
 }

}