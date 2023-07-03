

import java.util.Comparator;
import java.io.Serializable;
 
public class ComparatorParCodInt implements Comparator<ParCodInt>, Serializable {

 
  
   public int compare(ParCodInt e1, ParCodInt e2) {
     if(e1.getN()>e2.getN()) return -1;
      
     if(e1.getN()<e2.getN()) return 1;
      
     
     else{ return e1.getCod().compareTo(e2.getCod());}
     
   }
    
}


