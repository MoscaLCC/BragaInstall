
/**
 * Write a description of class ComparatorTrioCodIntDouble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Comparator;
import java.io.Serializable;
 
public class ComparatorTrioCodIntDouble implements Comparator<TrioCodIntDouble>, Serializable {

 
  
   public int compare(TrioCodIntDouble e1, TrioCodIntDouble e2) {
     if(e1.getN()>e2.getN()) return -1;
      
     if(e1.getN()<e2.getN()) return 1;
      
     
     else{ return e1.getCod().compareTo(e2.getCod());}
     
   }
    
}