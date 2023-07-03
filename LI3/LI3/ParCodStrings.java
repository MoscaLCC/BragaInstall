
/**
 * Write a description of class ParCodStrings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;

public class ParCodStrings implements Serializable
{
     private String cod;
    private TreeSet<String> prods;
   

    public ParCodStrings(){
    this.cod="";
    this.prods= new  TreeSet<String>();

    }


    
    public ParCodStrings(String n, TreeSet<String> x){
    this.cod=n;
    this.prods= new  TreeSet<String>();
    for(String s: x)
        this.prods.add(s);
    
    }

    
    public ParCodStrings (ParCodStrings x){
    this.cod= x.getCod();
    this.prods=x.getStrings();
    }
    
    
    public String getCod(){
    return this.cod;}
    
 
    
    public TreeSet<String> getStrings(){
    TreeSet<String> x = new TreeSet<String>();
    for(String s: this.prods)
        x.add(s);

    return x;
    }


public int getNstrings(){
return this.prods.size();}


public void atualiza(ParCodStrings x){
if(this.cod.equals(x.getCod()))
  for(String s: x.getStrings())
    this.prods.add(s);
}


public ParCodStrings clone(){
return new ParCodStrings(this);}

public boolean equals(Object c){


  if (c==null) return false;
if(this==c) return true;
if(this.getClass()!=c.getClass()) return false;
ParCodStrings x= (ParCodStrings) c;
        if (this.cod.equals(x.getCod())) return true;
        else return false;
    }


public String toString(){
StringBuilder sb=new StringBuilder();
        sb.append("--------------------------------------\n");
        sb.append("CODIGO: " +this.cod);
        sb.append("\nNumero:  "+ this.getNstrings()+"\n");
        sb.append("--------------------------------------\n");
        return sb.toString();}

}




