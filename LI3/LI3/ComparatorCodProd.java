
/**
 * Escreva a descrição da classe ComparatorCodProd aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Comparator;
import java.io.Serializable;
 
public class ComparatorCodProd implements Comparator<Compra>, Serializable {

 
  
   public int compare(Compra e1, Compra e2) {
     return e1.getCodprod().compareTo(e2.getCodprod());
     
   }
    
}