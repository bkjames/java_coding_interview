package aExe07;

import java.util.LinkedList;

public class MaxSlidingWindow {
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		System.out.println(maxSlidingWindow(nums, k));
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
	    if(nums==null||nums.length==0)
	        return new int[0];
	 
	    int[] result = new int[nums.length-k+1];
	 
	    LinkedList<Integer> deque = new LinkedList<Integer>();
	    for(int i=0; i<nums.length; i++){
	        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
	            deque.poll();
	 
	        while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
	            deque.removeLast();
	        }    
	 
	        deque.offer(i);
	 
	        if(i+1>=k)
	            result[i+1-k]=nums[deque.peek()];
	    }
	 
	    return result;
	}

}
