
/**
 * Escreva a descrição da classe ComparatorCodcli aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Comparator;
import java.io.Serializable;
 
public class ComparatorCodcli implements Comparator<Compra>, Serializable {

 
  
   public int compare(Compra e1, Compra e2) {
     return e1.getCodcli().compareTo(e2.getCodcli());
     
   }
    
}

