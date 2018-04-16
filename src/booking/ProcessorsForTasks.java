package booking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProcessorsForTasks {

    /** Solution based on timeline  O(n + timeline)
     *  Adding or extracting 1 at the specific time point on timeline
     */
    public int findTotalNumberOfProcessorsNeededWithTimeline(List<Pair> pairs) {
        int min = PairUtils.findMin(pairs);
        int max = PairUtils.findMax(pairs);
        int[] timeline = new int[max - min + 1];
        for (Pair pair : pairs) {
            timeline[pair.getFirst() - min]++;
            timeline[pair.getSecond() - min]--;
        }
        int curNumberOfProcessors = 0;
        int needed = 0;
        for (int value : timeline) {
            curNumberOfProcessors += value;
            if (curNumberOfProcessors > needed) {
                needed = curNumberOfProcessors;
            }
        }
        return needed;
    }

    /** Solution based on sorting O(n log n)
     *  By sorting ins and outs in the order they happen (based on Math.abs logic)
     */
    public int findTotalNumberOfProcessorsNeededWithSorting(List<Pair> pairs) {
        ArrayList<Integer> positiveInsAndNegativeOuts = new ArrayList<>();
        for(Pair pair : pairs) {
            positiveInsAndNegativeOuts.add(pair.getFirst());
            positiveInsAndNegativeOuts.add(-pair.getSecond());
        }
        int maxNumber = 0;
        int currentNumberOfProcessors = 0;
        positiveInsAndNegativeOuts.sort(new ChecksComparator());
        for(int value : positiveInsAndNegativeOuts) {
            currentNumberOfProcessors += value > 0 ? 1 : - 1;
            if (currentNumberOfProcessors > maxNumber) {
                maxNumber = currentNumberOfProcessors;
            }
        }
        return maxNumber;
    }

    public static class ChecksComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int difference = Math.abs(o1) - Math.abs(o2);
            if (difference == 0) {
                return o2 - o1;
            }
            return difference;
        }
    }
    
    /*
     *
     * 

The first line contains the current number of customer service executives X.
The second line contains one integer N, N is the number of data points in the data set.
The third line contains one integer M, M is the number of integers in each data point

1
3
2
1481122000 1481122020
1481122000 1481122040
1481122030 1481122035
     * */
    
    public static void main(String[] args) throws Exception{
    	
    	 Scanner in = new Scanner(System.in);
    	 List<Pair> pairs =  new ArrayList<>();
    	 ProcessorsForTasks processor =  new ProcessorsForTasks();
    	 
    	  //  current number of customer service executives X.
    	  int X = in.nextInt();
        		 
          // Number of data points
    	  int N = in.nextInt();
    	  
          // number of integers in each data point
    	  int M = in.nextInt();
    	  in.nextLine();
    	  for (int i = 0; i < N; i++) {
    	 
    		  String[] timestamps = in.nextLine().split(" ");
    		  if(timestamps.length != M){
    			  throw new Exception("invalid input");
    		  }
    		  Pair pair = new Pair(Integer.parseInt(timestamps[0]),Integer.parseInt(timestamps[1]));
    		  pairs.add(pair);
    	  
    	  }
    	  
    	  int overlaps = processor.findTotalNumberOfProcessorsNeededWithTimeline(pairs);
    	
    }
}