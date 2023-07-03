
/**
 * Write a description of class CatalogoProdutos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class CatalogoProdutos implements Serializable
{
    //catalogo de produtos
   private TreeSet<String> produtos;
    
    public CatalogoProdutos()
    {
         this.produtos = new TreeSet<String> ();
    }

    
public TreeSet<String> getProdutos (){
TreeSet<String> x = new TreeSet<String>();
for(String y: this.produtos)
    x.add(y);

return x;
}


 
    public boolean existeProd(String cod){
    return this.produtos.contains(cod);}

public int leProdutos () throws IOException{
    int i=0;
 
        String linha= "";
        StringTokenizer st ;
       String codprod;
        
        BufferedReader bin = new BufferedReader (new FileReader("FichProdutos.txt"));
                while (bin.ready()){
                linha = bin.readLine();
                st = new StringTokenizer(linha," ");
                codprod = st.nextToken();
                
                
                this.produtos.add(codprod);
                codprod=null;i++;
            }
               bin.close();
              
    
    return i;
    }


}
