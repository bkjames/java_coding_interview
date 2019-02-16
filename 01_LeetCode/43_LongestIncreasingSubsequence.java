package coding;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
		System.out.println(lengthOfLIS2(nums));
	}
		public static int lengthOfLIS(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    int[] max = new int[nums.length];
	 
	    for(int i=0; i<nums.length; i++){
	        max[i]=1;
	        for(int j=0; j<i;j++){
	        	System.out.println(i+" "+j);
	        	System.out.println("aa "+nums[i]+" "+nums[j]);
	            if(nums[i]>nums[j]){
	            	System.out.println("max "+nums[i]+" "+nums[j]);
	            	System.out.println("max val "+Math.max(max[i], max[j]+1));
	                max[i]=Math.max(max[i], max[j]+1);
	            }
	            
	        }
	    }
	 
	    int result = 0;
	    for(int i=0; i<max.length; i++){
	    	System.out.println("res: "+max[i]);
	        if(max[i]>result)
	            result = max[i];
	    }
	    return result;
	}
	
	
    public static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
            	System.out.println(nums[i]+" "+nums[j]);
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
	
	
	public  static int  lengthOfLIS2(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    ArrayList<Integer> list = new ArrayList<Integer>(); 
	 
	    for(int num: nums){
	        if(list.size()==0 || num>list.get(list.size()-1)){
	            list.add(num);
	        }else{
	            int i=0; 
	            int j=list.size()-1;
	 
	            while(i<j){
	                int mid = (i+j)/2;
	                if(list.get(mid) < num){
	                    i=mid+1;
	                }else{
	                    j=mid;
	                }
	            }
	 
	            list.set(j, num);
	        }
	    }
	 
	    return list.size();
	}

}
