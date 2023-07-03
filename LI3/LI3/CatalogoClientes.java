
/**
 * Write a description of class CatalogoClientes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;

public class CatalogoClientes implements Serializable
{
    
     //catologo de clientes
   private TreeSet<String> clientes;
    
    
    public CatalogoClientes()
    {
        this.clientes = new TreeSet<String> ();
    }

    
    public boolean existeCli(String cod){
    return this.clientes.contains(cod);}
    
 public int leClientes () throws IOException{
    int i=0;
    
        String linha= "";
        StringTokenizer st ;
       String codcli;
        
        BufferedReader bin = new BufferedReader (new FileReader("FichClientes.txt"));
                while (bin.ready()){
                linha = bin.readLine();
                st = new StringTokenizer(linha," ");
                codcli = st.nextToken();
                
                
                this.clientes.add(codcli);
                codcli=null;i++;
            }
               bin.close();
       
    
    return i;
    }
    
  public TreeSet<String> getClientes(){
    TreeSet<String> x = new TreeSet<String>();
for(String y: this.clientes)
    x.add(y);

return x;
}
 



   
    }




