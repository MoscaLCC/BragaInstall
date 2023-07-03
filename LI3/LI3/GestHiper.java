
/**
 * Write a description of class GestHiper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class GestHiper implements Serializable
{
   //catalogo de produtos
   private CatalogoProdutos produtos;
   //catologo de clientes
   private CatalogoClientes clientes;
   // contabilidade
   private Contabilidade_Super contab;
   //estrutura de compras
   private CatalogoCompras cat; 
   
   
   public GestHiper(){
    this.produtos = new CatalogoProdutos ();
    this.clientes = new CatalogoClientes();
    this.contab= new Contabilidade_Super();
    this.cat = new CatalogoCompras ();
}
   
 // public GestHiper(GestHiper x){}

 
public TreeSet<String> getProdutos (){
TreeSet<String> x = new TreeSet<String>();
for(String y: this.produtos.getProdutos())
    x.add(y);

return x;
}
 
 
 
 
 
 
 
 
    public boolean foiComprado(String cod)
{ 
    return this.cat.foiComprad(cod);
  }

 
 public boolean ClienteComprou(String cod){
    return this.cat.Comprou(cod);
    
    } 
  
 
 public TreeSet<String> getNaoCompraram(){
    TreeSet<String> x = new TreeSet<String>();
    TreeSet<String> z = this.cat.getClientesCompradores();
    for(String y: this.clientes.getClientes())
    if(!z.contains(y)){
        
        x.add(y);}
    
    return x;
    }
 
 
 public void GravaTxtInvalidas(String nome) throws IOException{
    this.cat.gravaInv(nome);}
 
 
 public TreeSet<String> getNaoComprados(){
    TreeSet<String> x = new TreeSet<String>();
for(String y: this.produtos.getProdutos())
    if(!foiComprado(y))
        x.add(y);
    
    return x;
    }
 
 
 
 
 public int getNumeroComprasproduto(){
    return this.cat.getNumeroComprasprod();
}
 

public int QtdClientesCompraramMes(int mes){
return this.cat.QtdClientesCompraram(mes);}




public int getNumeroComprasMes(int mes){
   
     return this.cat.getNumeroCompras(mes);
}
 

    public double faturacaoMes(int mes){
     return this.contab.faturacaoMensal(mes);
    }
    
     public boolean existeCliente(String cod){
    return this.clientes.existeCli(cod);}
    
  public int getNumeroInvalidas(){
    return this.cat.getNInvalidas();
    }
    
    public void add1Contabilidade(Contabilidade x){
    this.contab.addContabilidade(x);
}

public void addCompraproduto(Compra x){
       this.cat.addCompraprod(x);
}
 

public Contabilidade getContabilidadeMensal (String prod, int mes)throws ProdutoNaoExiste{

    return this.contab.getContabilidadeMes(prod,mes);


}




public boolean existeproduto(String x){
    if (this.produtos.existeProd(x)) return true;
    else return false;
}







public TRIOcompfatuprod getInfoMesCliente(String cd, int m)throws ClienteNaoExiste{

	return this.cat.getInfoMesCli(cd,m);
          

}


public TRIOcompfatuprod getInfoMesProduto(String cd, int m)throws ProdutoNaoExiste{

return this.cat.getInfoMesProd(cd,m);
}

public TreeSet<TrioCodIntInt> getProdutosMaisVendidos(){
   TreeSet<TrioCodIntInt> x= new TreeSet<TrioCodIntInt> (new ComparatorTrioCodIntInt());
    
    for (TrioCodIntInt t:this.cat.getMaisVendidos().values())
      x.add(t);

     return x; 
}

  
public TreeSet<ParCodStrings> getOsMaioresCompradoress(){
   TreeSet<ParCodStrings> x= new TreeSet<ParCodStrings> (new ComparatorParCodStrings());
    
    for (ParCodStrings t:this.cat.getMaioresCompradores().values())
      x.add(t);

     return x; 
}
   

public TreeSet<TrioCodIntDouble>getMaisCompraramProduto(String cod)throws ProdutoNaoExiste{
TreeSet<TrioCodIntDouble> x= new TreeSet<TrioCodIntDouble> (new ComparatorTrioCodIntDouble());
    
    for (TrioCodIntDouble t:this.cat.getMaisCompraramProd(cod).values())
      x.add(t);

     return x; 

}


     
public void addCompracliente(Compra x){
       this.cat.addCompracli(x);
        
}

 public void addCompraInval(Compra x){
    this.cat.addCompraInvalida(x);
    }

    public void addCompra(Compra x){
    this.addCompraproduto(x);
    this.addCompracliente(x);

}

////////////////

public TreeSet<ParCodInt> ProdutosMaisCompradosCliente(String x)throws ClienteNaoExiste{
return this.cat.getMaisComprou(x);
}








//////////////////


public boolean compraValida(Compra x){
if(x.getCodcli().length()==5 && x.getCodprod().length()==6 && x.getPreco()>=0 && (x.getModo()=='N'|| x.getModo()=='P')&& (x.getMes()>0 &&x.getMes()<13))
    return (this.existeproduto(x.getCodprod())&& this.existeCliente(x.getCodcli()));

else return false;

}

   public int leCatalogoProdutos () throws IOException{
    int i=0;
    
       this.produtos.leProdutos();
              
    
    return i;
    }

    public int leCatologoClientes () throws IOException{
    int i=0;
    
        i=this.clientes.leClientes();
              
    
    return i;
    }

    /*Carrega todas as estruturas*/

public String CarregaDados(String nome) throws IOException{
    TreeSet<String> prods= new TreeSet<>();
   TreeSet<String> clis = new TreeSet<>(); 
   int c0=0,c=0,pr=0;    
   Compra cop;
   int i=0;
   double ft=0; 
  
     c= this.clientes.leClientes ();
     pr= this.produtos.leProdutos ();
     

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
                if(compraValida(cop)){
                if(preco==0) c0++;
                this.addCompra(cop.clone());
                clis.add(codcli);
                prods.add(codprod);
                ft+=preco;
                //Contabilidade(String c,int nc, int pc,double n, double p, int me)
                if(p=='N'){
                Contabilidade x= new Contabilidade(codprod,qt,0,preco,0,mes);
                this.add1Contabilidade(x.clone());
                x=null;
            }
                else{ Contabilidade y= new Contabilidade(codprod,0,qt,0,preco,mes);
                this.add1Contabilidade(y.clone());
               y=null;
            }}
                
            else {this.addCompraInval(cop.clone());
            
            
            }
            cop=null;
                 i++;
            }
               bin.close();
               
    
         StringBuilder sb= new StringBuilder();
    sb.append("\nNome do ficheiro de Compras: "+nome);
    sb.append("\nNumero de linhas lidas: "+i);
    sb.append("\nNumero total de produtos: " +c);
    sb.append("\nNumero de produtos diferentes comprados: "+ prods.size());
    sb.append("\nNumero de produtos não comprados: " +(pr-prods.size()));
    sb.append("\nNumero total de clientes: " +c);
    sb.append("\nNumero de clientes diferentes que compraram: "+ clis.size());
    sb.append("\nClientes que nada compraram:" +(c- clis.size()));
    sb.append("\nCompras de valor =0: " +c0);
    sb.append("\nTotal faturado: " +ft);
   

   return sb.toString();
        
        
       
    }

 public void gravaObjeto(String nome) throws IOException{
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(nome));
      
        out.writeObject(this);
        out.flush();
        out.close();
    }


public GestHiper CarregaObjeto(String nome) throws IOException, ClassNotFoundException {
    
    GestHiper sis= new GestHiper();
          
                ObjectInputStream inp = new ObjectInputStream (new FileInputStream(nome));
                sis = (GestHiper) inp.readObject();
                inp.close();
            
             
            return sis;
    
    
    }


}
    
    
    

