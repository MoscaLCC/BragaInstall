
/**
 * Write a description of class ComparatorTrioCodIntInt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Comparator;
import java.io.Serializable;
 
public class ComparatorTrioCodIntInt implements Comparator<TrioCodIntInt>, Serializable {

 
  
   public int compare(TrioCodIntInt e1, TrioCodIntInt e2) {
     if(e1.getN()>e2.getN()) return -1;
      
     if(e1.getN()<e2.getN()) return 1;
      
     
     else{ return e1.getCod().compareTo(e2.getCod());}
     
   }
    
}



