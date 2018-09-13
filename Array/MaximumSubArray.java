package aF01;

import java.util.HashSet;
import java.util.Set;

public class MaximumSubArray {

	
	public static void main(String[] args) {
		
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		
		MaximumSubArray a = new MaximumSubArray();
		System.out.println(a.maxSubArray(arr));
	}
	
	
	
	public int maxSubArray(int[] arr) {
		
		int sum =0;
		int maxSum = Integer.MIN_VALUE;
		System.out.println("maxSum: "+maxSum);
		
		for(int i =0; i<arr.length; i++ ) {
			sum += arr[i];
			maxSum = Math.max(maxSum , sum);
			
			if(sum <0) sum =0;
		}
		
		return maxSum;
	}
	
	public int dynamic(int[] arr) {
		int  max = arr[0];
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		
		for(int i =1; i< arr.length; i++) {
			sum[i] =Math.max(arr[i], sum[i-1]+arr[i]);
			max = Math.max(max, sum[i]);
		}
		
		return 0;
	}
}
