
/**
 * Escreva a descrição da classe Compra aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.*;


public class Compra implements Serializable
{   private int mes;
    private String codcli;
    private String codprod;
    private char modo;
    private double preco;
    private int uni;
    
    public Compra()
    {
        this.mes=0;
        this.codcli="";
        this.codprod="";
        this.modo='N';
        this.preco=0;
        this.uni=0;
   
    }

    public Compra(int m, String c, String p, char mo,double pr, int u){
        this.mes=m;
        this.codcli=c;
        this.codprod=p;
        this.modo=mo;
        this.preco=pr;
        this.uni=u;
    }
    
    public Compra(Compra x){
        this.mes=x.getMes();
        this.codcli=x.getCodcli();
        this.codprod=x.getCodprod();
        this.modo=x.getModo();
        this.preco=x.getPreco();
        this.uni=x.getUni();
    }

  public int getMes(){
    return this.mes;}
    
    public int getUni(){
    return this.uni;}
        
    public char getModo(){
    return this.modo;}
    
    public double getPreco(){
    return this.preco;}
    
    public String getCodcli(){
    return this.codcli;}
    
    public String getCodprod(){
    return this.codprod;}
    
    

    public void setMes(int m){
    this.mes=m;}
    
    
    
    
    public Compra clone(){
    return new Compra(this);}
    
    public String toString(){
  
       StringBuilder sb= new StringBuilder();
        sb.append("Codigo Produto: "+this.getCodprod() + "\nCodigo Cliente: " +this.getCodcli());
        sb.append("\nQuantidade:  "+ this.getUni()+"\nModo:"+this.getModo());
        sb.append("\nMes:  "+ this.getMes()+"\nPreço:"+this.getPreco() +"\n");
         
        return sb.toString();}

    
       
        
        
    public boolean equals (Object c){
        if (c==null) return false;
        if(this==c) return true;
    if(this.getClass()!=c.getClass()) return false;
    Compra x= (Compra) c;
        if (this.getCodcli().equals(x.getCodcli())&&this.getCodprod().equals(x.getCodprod()) && this.getPreco()==x.getPreco()&&this.mes== x.getMes()&&this.getUni()==x.getUni()&&this.modo==x.getModo()) return true;
        else return false;
    }

   
}
