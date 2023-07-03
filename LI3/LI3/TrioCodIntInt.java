
/**
 * Write a description of class TrioCodIntInt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;

public class TrioCodIntInt implements Serializable

{
     
    private String cod;
    private int numero;
    private int ft;
    
    
    
    public TrioCodIntInt(){
    this.cod="";
    this.numero=0;
    this.ft=0;
}

public TrioCodIntInt (String co, int num,int d){
this.cod=co;
this.numero=num;
this.ft= d;
}


public TrioCodIntInt(TrioCodIntInt x){
this.cod=x.getCod();
this.numero=x.getN();
this.ft= x.getFt();
 }

public String getCod(){
return this.cod;}

public int getN(){
return this.numero;}

public int getFt(){
return this.ft;}

public void atualiza(TrioCodIntInt x){
if(this.cod.equals(x.getCod())){this.numero+=x.getN();
this.ft+=x.getFt();
}

}


public TrioCodIntInt clone(){
return new TrioCodIntInt(this);}

public boolean equals(Object c){


  if (c==null) return false;
if(this==c) return true;
if(this.getClass()!=c.getClass()) return false;
TrioCodIntInt x= (TrioCodIntInt) c;
        if (this.cod.equals(x.getCod())) return true;
        else return false;
    }


public String toString(){
StringBuilder sb=new StringBuilder();
        sb.append("--------------------------------------\n");
        sb.append("CODIGO: " +this.cod);
        sb.append("\nQtd:  "+ this.numero+"\n");
        sb.append("\nNumero de clientes diferentes:  "+ this.ft+"\n");
        sb.append("--------------------------------------\n");
        return sb.toString();}


    
}
