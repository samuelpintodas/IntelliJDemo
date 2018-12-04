/**
 * combinaison_bits - Test.java
 * Author : Jonathan Schnyder
 * Created : 23 oct. 2017
 */


public class bitsTabString
{
	
	
	public static void main(String[] args)
	{
		combinaison(3,"") ;
	}
	
	public static void combinaison(int nbit, String comb)
	{

		
		//clause de finitude
		if(nbit==0) 
		{ 
			System.out.println(comb); 
			return ;
		}
		
		//pas récursif
		//on prend la combinaison précédente, et on y rajoute respectivement '0' et '1'
		combinaison(nbit-1,comb+'0') ;
		System.out.println("----------");
		combinaison(nbit-1,comb+'1') ;		
	}
}
