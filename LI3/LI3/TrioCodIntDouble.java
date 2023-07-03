
/**
 * Write a description of class TrioCodIntDouble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;

public class TrioCodIntDouble implements Serializable
{
     
    private String cod;
    private int numero;
    private double ft;
    
    
    
    public TrioCodIntDouble(){
    this.cod="";
    this.numero=0;
    this.ft=0;
}

public TrioCodIntDouble (String co, int num,double d){
this.cod=co;
this.numero=num;
this.ft= d;
}


public TrioCodIntDouble(TrioCodIntDouble x){
this.cod=x.getCod();
this.numero=x.getN();
this.ft= x.getFt();
 }

public String getCod(){
return this.cod;}

public int getN(){
return this.numero;}

public double getFt(){
return this.ft;}

public void atualiza(TrioCodIntDouble x){
if(this.cod.equals(x.getCod())){this.numero+=x.getN();
this.ft+=x.getFt();
}

}


public TrioCodIntDouble clone(){
return new TrioCodIntDouble(this);}

public boolean equals(Object c){


  if (c==null) return false;
if(this==c) return true;
if(this.getClass()!=c.getClass()) return false;
TrioCodIntDouble x= (TrioCodIntDouble) c;
        if (this.cod.equals(x.getCod())) return true;
        else return false;
    }


public String toString(){
StringBuilder sb=new StringBuilder();
        sb.append("--------------------------------------\n");
        sb.append("CODIGO: " +this.cod);
        sb.append("\nNumero:  "+ this.numero+"\n");
        sb.append("\nFaturado:  "+ this.ft+"\n");
        sb.append("--------------------------------------\n");
        return sb.toString();}

}



