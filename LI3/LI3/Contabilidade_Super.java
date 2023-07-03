
/**
 * Write a description of class Contabilidade_Super here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;

public class Contabilidade_Super implements Serializable
{
     // contabilidade
   private TreeMap <Integer, TreeMap<String,Contabilidade>> contab;
    
    public Contabilidade_Super()
    {
       this.contab= new TreeMap<>();
    }

    
    public void addContabilidade(Contabilidade x){
    if(this.contab.containsKey(x.getMes())){
        if (this.contab.get(x.getMes()).containsKey(x.getCod()))
            this.contab.get(x.getMes()).get(x.getCod()).atualizaContas(x);
        else this.contab.get(x.getMes()).put(x.getCod(),x);
    }
     else  {TreeMap<String,Contabilidade> cp = new TreeMap<> ();
            cp.put(x.getCod(),x);
            this.contab.put(x.getMes(),cp);       }
}
    
    
   public Contabilidade getContabilidadeMes(String prod, int mes)throws ProdutoNaoExiste{
       if(this.contab.get(mes).get(prod)==null)
            throw new ProdutoNaoExiste(prod);
            
        return this.contab.get(mes).get(prod).clone();
} 
    
 public double faturacaoMensal(int mes){
    double n=0;
    
        if (this.contab.get(mes)!=null){
          
    for(Contabilidade x: this.contab.get(mes).values())
        n= n +x.getFatuN()+x.getFatuP();
    }
   
      return n;
    }
    
  
    
    
    
    
}
