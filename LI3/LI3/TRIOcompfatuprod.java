
/**
 * Write a description of class TRIOcompfatuprod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class TRIOcompfatuprod implements Serializable
{
    private int ncomp;
    private TreeSet<String> prods;
    private double fat;

    public TRIOcompfatuprod(){
    this.ncomp=0;
    this.prods= new  TreeSet<String>();
    this.fat=0;
    }


    
    public TRIOcompfatuprod(int n, TreeSet<String> x, double fatu){
    this.ncomp=n;
    this.prods= new  TreeSet<String>();
    for(String s: x)
        this.prods.add(s);
    this.fat=fatu;
    }

    public int getNcomp(){
    return this.ncomp;}
    
    public double getFat(){
    return this.fat;
}
    
    public TreeSet<String> getProds(){
    TreeSet<String> x = new TreeSet<String>();
    for(String s: this.prods)
        x.add(s);

    return x;
    }


public int getNprods(){
return this.prods.size();}


}
