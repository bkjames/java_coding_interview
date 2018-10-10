package aExe07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;



class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num=num;
        this.count=count;
    }
}
public class TopKFrequentElements {
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		System.out.println(topKFrequent(nums, k));
	}
	
	
	  public static List<Integer> topKFrequent(int[] nums, int k) {
	        //count the frequency for each element
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int num: nums){
	            if(map.containsKey(num)){
	                map.put(num, map.get(num)+1);
	            }else{
	                map.put(num, 1);
	            }
	        }
	 
	        // create a min heap
	        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {

				@Override
				public int compare(Pair a, Pair b) {
					return a.count-b.count;
				}
	        	
	        });
	        
	 
	        //maintain a heap of size k. 
	        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	            Pair p = new Pair(entry.getKey(), entry.getValue());
	            queue.offer(p);
	            if(queue.size()>k){
	                queue.poll();
	            }
	        }
	 
	        //get all elements from the heap
	        List<Integer> result = new ArrayList<Integer>();
	        while(queue.size()>0){
	            result.add(queue.poll().num);
	        }
	        //reverse the order
	        Collections.reverse(result);
	 
	        return result;
	    }
	
	public static List<Integer> topKFrequent2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        
        // Using a map to store the element and its occurences
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // Using a maxHeap to auto-sort the EntrySet according to the occurences of elements, 
        // so we need to Override the compare method (Using  Lambda Expression)
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        
        List<Integer> rst = new ArrayList<>();
        while (k > 0) {
        	// poll the number with largest frequency currently.
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            rst.add(entry.getKey());
            k--;
        }
        return rst;
    }

}
