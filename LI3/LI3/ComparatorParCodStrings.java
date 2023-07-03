
/**
 * Write a description of class ComparatorParCodStrings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

   import java.util.Comparator;
import java.io.Serializable;
 
public class ComparatorParCodStrings implements Comparator<ParCodStrings>, Serializable {

 
  
   public int compare(ParCodStrings e1, ParCodStrings e2) {
     if(e1.getNstrings()>e2.getNstrings()) return -1;
      
     if(e1.getNstrings()<e2.getNstrings()) return 1;
      
     
     else{ return e1.getCod().compareTo(e2.getCod());}
     
   }
    
}



