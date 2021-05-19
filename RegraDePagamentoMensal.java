/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regradepagamento;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class RegraDePagamentoMensal {
    
    private double[] meses ;
    private int posicao = 0;
    private double deposito;
    private double valorDeCobranca = 500.0;
    
   
    
    public RegraDePagamentoMensal( int mes ) {
    
        this.meses = new double[ mes ];
    }
    
    public void pagar( double valor )
    {
        
        this.deposito = valor;
        
        if ( depositoMaiorQueZero() )
            if(posicao < 12)
        {

           
            
             if (valor == valorDeCobranca || valor < valorDeCobranca  )
            {
                 depositar( valor );
                
            }
            else if (valor > valorDeCobranca)
                    {
                        
                       double aux = 0.0;
                   
                          //depositaSeTinhaUmValorMenor();
                        depositar( valorDeCobranca );
                        
                       
                         aux = valor - valorDeCobranca ;
                        System.out.println("\n aux : "+aux);
                        if (aux >= valorDeCobranca)
                        {
                            
                           pagar(aux);
                            // Atualiza a variavel valor;
                           
                        }
                        else
                            depositarRestoDoValor(aux);
                            
                 
                    }
               
//                  

//                                         
                
        }
      
      
    }
//    
//    private double atualizaValorDepositado(double valor)
//    {
//        if (this.deposito > valorDeCobranca)
//            this.deposito -= valorDeCobranca;
//        else if (this.deposito == valorDeCobranca)
//                this.deposito = valorDeCobranca;
//               else
//                
//        
//        
//        
//        
//        return this.deposito;
//    }

    public double getMeses(int numeroDoMes) {
        return meses[numeroDoMes];
    }
    
    
    private void depositaSeTinhaUmValorMenor()
    {
        double valorEmFalta = 0.0,
                novoValor = 0.0;
                            
                            valorEmFalta = this.valorDeCobranca - meses[posicao-1];
                            meses[posicao-1] += valorEmFalta;
                            
                            novoValor= valorDeCobranca - valorEmFalta;
                            if ( depositoMaiorQueZero() )
                                depositar( novoValor );
    }
    
  
    private boolean valorAnteriorMenorValorCobranca()
    {
     
            return  meses[posicao-1] < valorDeCobranca;
      
    }
    
    private void depositar(double deposito)
    {
            meses[ posicao ]  = deposito;
            posicao++;
    }
    
    
    
    private void depositarRestoDoValor(double resto)
    {
        depositar(resto);
      
    }
    
      private double calculoObterResto()
    {
        double resto;
        
        resto = this.valorDeCobranca - this.deposito;
//        
//        if ( this.resto > valorDeCobranca )
//        {
//            this.deposito = this.resto;
//            pagar(this.deposito);
//        }
        
        // Se o resto for menor igual ou igual 0.0 significa que já não sobrou 
        // nenhum valor útel para o deposito
        if ( resto <= 0.0 )
            return this.deposito;
        
        return resto;
    }
      
      
      private boolean sobrouTroco()
      {
          return calculoObterResto() > 0.0;
      }
      
    private boolean depositoMaiorQueZero()
    {
        return this.deposito > 0.0;
    }
    
    private boolean valorDepositadoMaiorQueValorDeCobranca()
    {
        return deposito > valorDeCobranca;
    }

    
  private boolean existirUmDeposito()
  {
      return meses.length >= 1 ;
  }
    

  public void showMonths()
  {
      for (int i = 0; i < meses.length; i++)
      {
          System.out.println("Valor da mensalidade "+(i+1)+": "+meses[i]+"\n");
      }
      
     System.out.println("");
  }
  
  public double arranjarPagamento()
  {
      
  
     double soma = Arrays.stream(meses).sum();
     
      for (int i = 0; i < meses.length; i++)
      {
          meses[i] = 0.0;
      }
     
      
       
      return soma;
     
      
  }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
         
    }

    public int getPosicao() {
        return posicao;
    }
  
  

}
