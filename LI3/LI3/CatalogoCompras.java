
/**
 * Write a description of class CatalogoCompras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class CatalogoCompras implements Serializable
{   //estrutura de compras com indexeçao por cos prod
   private TreeMap<Integer,TreeMap<String,ArrayList<Compra>>> cp;
   //estrutura de compras com indexeçao por cod cli
   private TreeMap<Integer,TreeMap<String,ArrayList<Compra>>> cc;
  // compras invalidas
   private ArrayList<Compra> ci; 
   

    
public CatalogoCompras()
    {
    this.cp = new TreeMap <>();
    this.cc = new TreeMap <>();
    this.ci= new ArrayList<>();
    }


    
    public int getNumeroComprasprod(){
     int n=0;
    for(TreeMap<String,ArrayList<Compra>> x:this.cp.values()){
        for(ArrayList<Compra> z: x.values()){
           n+=z.size();}
        }
    
    

    return n;
}
 


public int QtdClientesCompraram(int mes){
if(this.cc.get(mes)!=null){
return this.cc.get(mes).size();}
else return 0;}

public int getNumeroCompras(int mes){
     int n=0;
       
            if(this.cc.get(mes)!=null){
                
            
        for(ArrayList<Compra> z: this.cc.get(mes).values()){
           n+=z.size();
        }
    
    }

    return n;
}   
   
public int getNInvalidas(){

return this.ci.size();
}

    public boolean foiComprad(String cod)
{ 
    for(TreeMap<String,ArrayList<Compra>> x:this.cp.values()){
        if(x.containsKey(cod))
            return true;
}
  
return false;
  }

    public boolean Comprou(String cod){
    for(TreeMap<String,ArrayList<Compra>> x:this.cc.values()){
        if(x.containsKey(cod))
            return true;
}
  
return false;
    
    } 
    
   public TreeSet<String> getClientesCompradores(){
    TreeSet<String> s= new TreeSet<>();
     for(TreeMap<String,ArrayList<Compra>> x:this.cc.values()){
        for(String y: x.keySet())
         s.add(y);
         
        }
        return s;

}
    
    
    
    
    public void addCompraprod(Compra x){
         if(x!=null){  
             //if(this.compras.containsKey(x.getCodprod())&&this.compras.get(x.getCodprod()).containsKey(x.getCodcli()))
        if(this.cp.containsKey(x.getMes())){
            
            if( this.cp.get(x.getMes()).containsKey(x.getCodprod()))
            this.cp.get(x.getMes()).get(x.getCodprod()).add(x);
            else {//TreeMap<String,ArrayList<Compra>> xp = new TreeMap<String,ArrayList<Compra>> ();
                  ArrayList<Compra> ar= new ArrayList<Compra>();
                ar.add(x);
                //xp.put(x.getCodprod(),ar);
                this.cp.get(x.getMes()).put(x.getCodprod(),ar);
             
            }
            
        
    }
        else{ TreeMap<String,ArrayList<Compra>> xp = new TreeMap<String,ArrayList<Compra>> ();
                ArrayList<Compra> ar= new ArrayList<Compra>();
                ar.add(x.clone());
            xp.put(x.getCodprod(),ar);
            this.cp.put(x.getMes(),xp);}
    
        }
        
}
 



public int getComprasMes(int mes){
    int n=0;
    for(ArrayList<Compra> x: this.cc.get(mes).values())
        n+=x.size();

        return n;
    }

    
    
    


// Pode dar null no ciclo- excepçao!!
public TRIOcompfatuprod getInfoMesCli(String cd, int m)throws ClienteNaoExiste{
TRIOcompfatuprod x=null;
int total=0;
TreeSet<String> h= new TreeSet<>();
double ft=0;
    
  if( this.cc.get(m).get(cd)==null)
      throw new ClienteNaoExiste(cd);
      
      for(Compra c : this.cc.get(m).get(cd)){
    total++;
    h.add(c.getCodprod());
    ft+=c.getPreco();
        
    
     }
x= new TRIOcompfatuprod(total, h, ft);
return x;}

     


public TRIOcompfatuprod getInfoMesProd(String cd, int m)throws ProdutoNaoExiste{
TRIOcompfatuprod x=null;
int total=0;
TreeSet<String> h= new TreeSet<>();
double ft=0;
  if(this.cp.get(m).get(cd)==null)
      throw new ProdutoNaoExiste(cd);

      for(Compra c : this.cp.get(m).get(cd)){
          total++;
          h.add(c.getCodcli());
          ft+=c.getPreco();
        
    
     }
     x= new TRIOcompfatuprod(total, h, ft);
return x;}


     


///////////////////////////////query 7
     
 public TreeSet<ParCodInt> getMaisComprou(String codcli)throws ClienteNaoExiste{
     TreeSet<ParCodInt> tr = new TreeSet<ParCodInt> (new ComparatorParCodInt());
     for(TreeMap<String,ArrayList<Compra>> x:this.cc.values()){
         if(!x.containsKey(codcli))
         throw new ClienteNaoExiste (codcli);
         for(Compra z: x.get(codcli)){
            ParCodInt pa= new ParCodInt(z.getCodprod(),1);
            //adicionao ao treeset
            if(!tr.contains(pa)) {tr.add(pa.clone());
                           }
            // tem de o ir atualizar
            else{Iterator<ParCodInt> it= tr.iterator();
                   boolean enc=false; 
                   while(it.hasNext()&&!enc){ 
                       
                      
                       ParCodInt pt= it.next();
                       if(pt.getCod().equals(codcli)){
                          
                            pa.atualiza(pt);
                            enc=true;
                            tr.remove(pt);
                            tr.add(pa.clone());
                        }
                   
                
                }
            }               
           pa=null;
           }
        
        
        }
        return tr;
}
     
     
     
// so para testar
public ArrayList<Compra> getComprasProduto(String cod){
 ArrayList<Compra> t = new  ArrayList<Compra> ();
    for(TreeMap<String,ArrayList<Compra>> x:this.cp.values())
{    if(x.containsKey(cod)){   
     for(Compra b: x.get(cod))
            t.add(b.clone());
}}
return t;
}

     
 ////////////////////////////////////////  query8
 
 public TreeMap<String,TrioCodIntInt> getMaisVendidos(){
     TreeMap<String,TrioCodIntInt> tr = new TreeMap <String,TrioCodIntInt> ();
     TreeSet<String> s = new TreeSet<>();
     for(TreeMap<String,ArrayList<Compra>> x:this.cp.values()){
        for(ArrayList<Compra> z: x.values()){
            int tot=0;
            for(Compra y: z){
            s.add(y.getCodcli());
            tot+=y.getUni();
            }
            TrioCodIntInt pa= new TrioCodIntInt(z.get(0).getCodprod(),tot,s.size());
            if(!tr.containsKey(pa.getCod())){
            tr.put(pa.getCod(),pa.clone());}
            else {tr.get(pa.getCod()).atualiza(pa);
                  
                   
                
                }
            
            
            s.clear();
            pa=null;
        }}
        
        
        return tr;
        }
        
///////////////////////////////////query 9

 public TreeMap<String,ParCodStrings> getMaioresCompradores(){
     TreeMap<String,ParCodStrings> tr = new TreeMap <String,ParCodStrings> ();
     TreeSet<String> s = new TreeSet<>();
     for(TreeMap<String,ArrayList<Compra>> x:this.cc.values()){
        for(ArrayList<Compra> z: x.values()){
            
            for(Compra y: z){
            s.add(y.getCodprod());
            
            }
            ParCodStrings pa= new ParCodStrings(z.get(0).getCodcli(),s);
            if(!tr.containsKey(pa.getCod())){
            tr.put(pa.getCod(),pa.clone());}
            else {tr.get(pa.getCod()).atualiza(pa);
                  
                   
                
                }
            
            
            s.clear();
            pa=null;
        }}
        
        
        return tr;
        }

   
///////////////////////////////// query 10
     
     
     public TreeMap<String,TrioCodIntDouble> getMaisCompraramProd(String cod)throws ProdutoNaoExiste{
     TreeMap<String,TrioCodIntDouble> tr = new TreeMap <String,TrioCodIntDouble> ();
     //TreeSet<String> s = new TreeSet<>();
     for(TreeMap<String,ArrayList<Compra>> x:this.cp.values()){
         if(!x.containsKey(cod))
            throw new ProdutoNaoExiste (cod);
             for(Compra z: x.get(cod)){

               TrioCodIntDouble pa= new TrioCodIntDouble(z.getCodcli(),1,z.getPreco());
                if(!tr.containsKey(pa.getCod())){
               tr.put(pa.getCod(),pa.clone());}
                else {tr.get(pa.getCod()).atualiza(pa);
                  
                   
                
                }
            
            
           
              pa=null;
             }}
        
        
        return tr;
        }















////////////////////////
     public void addCompracli(Compra x){
         if(x!=null){  
             //if(this.compras.containsKey(x.getCodprod())&&this.compras.get(x.getCodprod()).containsKey(x.getCodcli()))
        if(this.cc.containsKey(x.getMes())){
            
            if( this.cc.get(x.getMes()).containsKey(x.getCodcli()))
            this.cc.get(x.getMes()).get(x.getCodcli()).add(x);
            else {//TreeMap<String,ArrayList<Compra>> xp = new TreeMap<String,ArrayList<Compra>> ();
                  ArrayList<Compra> ar= new ArrayList<Compra>();
                ar.add(x);
                //xp.put(x.getCodprod(),ar);
                this.cc.get(x.getMes()).put(x.getCodcli(),ar);
             
            }
            
        
    }
        else{ TreeMap<String,ArrayList<Compra>> xp = new TreeMap<String,ArrayList<Compra>> ();
                ArrayList<Compra> ar= new ArrayList<Compra>();
                ar.add(x.clone());
            xp.put(x.getCodcli(),ar);
            this.cc.put(x.getMes(),xp);}
    
        }
        
}

 public void addCompraInvalida(Compra x){
    this.ci.add(x);
    }

    public void addCompra(Compra x){
    this.addCompraprod(x);
    this.addCompracli(x);

}



// nao le compras invalidas!!!!!!!!!!!!!!!!!

   public int leCompras (String nome) throws IOException{
   Compra cop;int i=0;
   TreeSet<String> prods= new TreeSet<>();
   TreeSet<String> clis = new TreeSet<>(); 
   int conta0=0;
   
        String linha= "";String txt="";
        StringTokenizer st ;
        String codprod; String codcli; int qt, mes;
        char p;
        double preco;
        
        BufferedReader bin = new BufferedReader (new FileReader( nome+".txt"));
                while (bin.ready()){
                linha = bin.readLine();
                st = new StringTokenizer(linha," ");
                codprod = st.nextToken();
                //preco= Integer.valueOf(st.nextToken()).floatValue();
                //txt= st.nextToken();
                //preco = Integer.parseInt(txt);
                preco=Float.valueOf(st.nextToken()).floatValue();
                qt = Integer.valueOf(st.nextToken()).intValue();
                p = st.nextToken().charAt(0);
                codcli = st.nextToken();
                mes=Integer.valueOf(st.nextToken()).intValue();
                //int m, String c, String p, char mo,float pr, int u
                cop=  new Compra(mes,codcli,codprod,p,preco,qt);
                //Contabilidade x= new Contabilidade();
                
                this.addCompra(cop.clone());
                //Contabilidade(String c,int nc, int pc,double n, double p, int me)
                
               
            cop=null;
                 i++;
            }
               bin.close();
               
   return 1;
}
 

public void gravaInv(String nome) throws IOException{
        FileWriter fw = new FileWriter(nome +".txt");
        BufferedWriter w = new BufferedWriter (fw);
        for(Compra x: this.ci)
           w.write (x.toString());
           w.flush();
           w.close();
           fw.close();
    }



}