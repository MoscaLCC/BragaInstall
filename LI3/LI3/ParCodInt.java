
/**
 * Write a description of class ParCodInt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;

public class ParCodInt implements Serializable
{
    
    private String cod;
    private int numero;
    
    
    
    
    public ParCodInt(){
    this.cod="";
    this.numero=0;

}

public ParCodInt (String co, int num){
this.cod=co;
this.numero=num;

}


public ParCodInt(ParCodInt x){
this.cod=x.getCod();
this.numero=x.getN();

 }

public String getCod(){
return this.cod;}

public int getN(){
return this.numero;}


public void atualiza(ParCodInt x){
if(this.cod.equals(x.getCod())){this.numero+=x.getN();}

}





public ParCodInt clone(){
return new ParCodInt(this);}

public boolean equals(Object c){


  if (c==null) return false;
if(this==c) return true;
if(this.getClass()!=c.getClass()) return false;
ParCodInt x= (ParCodInt) c;
        if (this.cod.equals(x.getCod())) return true;
        else return false;
    }


public String toString(){
StringBuilder sb=new StringBuilder();
        sb.append("--------------------------------------\n");
        sb.append("CODIGO: " +this.cod);
        sb.append("\nNumero:  "+ this.numero+"\n");
        sb.append("--------------------------------------\n");
        return sb.toString();}

}





