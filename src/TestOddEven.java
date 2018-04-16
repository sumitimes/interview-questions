
public class TestOddEven {

	
	public int [] findOdds(int l, int r){
		
		if(l>r){
			return new  int [0];
		}
		
		
	    int diff = Math.abs(r-l) ;
	    int arraySize  = 0 ;
	    if(diff %2 == 0){
	    	arraySize = (diff/2 ) ; 
	    }else{
	    	arraySize = (diff/2 ) +1 ; 
	    }
        
        
        

        System.out.println("l:"+l+"r"+r+"| arraySize:"+arraySize );
		
		
        int [] result = new int[arraySize] ; 
        
        int start = 0; 
        if(l%2 ==0){
        	start = l+1;
        }else{
        	start = l;
        }
        
        for(int i =0; i <arraySize ; i++ ){
        	result[i] = start;
        	start +=  2;
        }
        
        
		
        
        
        
        
        return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestOddEven toe = new TestOddEven();
		
		
		int [] result = toe.findOdds(-12 , 8);
		
		for(int a :result){
			System.out.println("ind a:"+a );
		}
		 
		result = toe.findOdds(19 , 9);
		
		for(int a :result){
			System.out.println("ind a:"+a );
		}
//		
//		result =  toe.findOdds(3 , 21);
//		
//		for(int a :result){
//			System.out.println("ind a:"+a );
//		}
//		
		
	}

}
