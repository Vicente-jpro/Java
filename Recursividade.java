/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividade;

/**
 *
 * @author vicente-jpro
 */
public class Recursividade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] vector = {4,6,10,1,3, 4,6,10,1,3};
        int i = 0;
        int aux = vector[0];
        int p = vector.length-1;
        int aux1 = vector[vector.length-1];
        System.out.println( " Valor maximo1: "+ max1(vector, i, aux));
  i = 1;
           System.out.println( " Valor maximo: "+  max2(vector, aux, aux1, p, i));
    }
    
    public static int max1( int[] vect, int i, int aux){
    
        // Caso base
        if ( i == vect.length )
            return aux;
        else
            if( aux < vect[i])
                aux = vect[i];
        return max1(vect, i+1, aux);
    }
    
    
    
    public static int max2( int[] vect, int aux, int aux1, int p, int i){
    
        // Caso base
        if ( i == vect.length/2 -1 )
            if (aux > aux1)
                return aux;
            else
                return aux1;
       
        if( aux < vect[i])
            aux = vect[i];
        
        if( aux1 < vect[p] )
            aux1 = vect[p];
        System.err.printf("aux "+aux+"\n aux1 = "+aux1);
        return max2(vect, aux, aux1, p-1, i+1);
    }
    
}
