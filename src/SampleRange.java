
public class SampleRange {

	

    /*
     * Complete the function below.
     */
    static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
     
      
        int [] prevEnd = new int [callsTimes.length] ;
        
        int result = 0 ;
        
        
        
        for(int idx = 0 ; idx < callsTimes.length ; idx++){
            
            if(idx == 0 ){
                result ++;
            }else{
                result = result + getAllOverLaps(callsTimes , idx);
            }
            
         
        }
    
        return result - noOfCurrentAgents;
    }


    static int getAllOverLaps(int[][] callsTimes , int idx){
        
        int result = 0; 
        
           for(int i = idx-1 ; i >= 0 ; i--){
            
               if (callsTimes[i] [0] < callsTimes[idx] [0] && callsTimes[i] [1] < callsTimes[idx] [0])
               result++;
           }
        
        return result; 
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
