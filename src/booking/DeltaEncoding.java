package booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeltaEncoding {
    public static void main(String[] args)  {
    
        int[] array = {25626,
        		25757,
        		24367,
        		24267,
        		16,
        		100,
        		2,
        		7277};
        
        delta_encode(array);
    }
    
    
    static  void  delta_encode(int[] array) {
    	
    	 StringBuilder result = new StringBuilder();
         result.append(array[0]+"\n");
         for (int i=1; i<array.length; i++) {
             int diff = array[i] - array[i-1];
             if (Math.abs(diff)>127) {
                 result.append("-128 "+"\n");
             }
             result.append(diff+"\n");
         }
  
         System.out.println(result);
    }
}

/*

25626
25757
24367
24267
16
100
2
7277
*/