package ab;

public class MinimumSizeSubArray {
	
	public static void main(String[] args) {
		int[] nums1 = {2,3,1,2,4,3};
//		System.out.println(minSubArrayLen2(7, nums1));
		
		System.out.println(minimumSize( nums1, 7));
	
	}
	
	
	
	public static int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int size = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            int sum = 0;
            int length = 0;
            for (int j = i; j < size; j++) {
                sum = sum + nums[j];
                length++;
                if (sum >= s) {
                    min = Math.min(min, length);
                }
            }
        }
        if (min != Integer.MAX_VALUE){
            return min;
        } else {
            return -1;
        }
    }
    
	
	public static int minSubArrayLen(int s, int[] nums) {
	    if(nums==null||nums.length==0)
	        return 0;
	 
	    int i=0; 
	    int j=0;
	    int sum=0;
	 
	    int minLen = Integer.MAX_VALUE;
	 
	    while(j<nums.length){
	        if(sum<s){
	            sum += nums[j];
	            j++;        
	        }else{
	            minLen = Math.min(minLen, j-i);
	            if(i==j-1)
	                return 1;
	 
	            sum -=nums[i];
	            i++;
	        }
	    }
	 
	    while(sum>=s){
	        minLen = Math.min(minLen, j-i);
	 
	        sum -=nums[i++];
	    }
	 
	    return minLen==Integer.MAX_VALUE? 0: minLen;
	}
	
	
	 public static int minSubArrayLen2(int s, int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        int start, end, sum;
	        start = end = sum = 0;
	        int min = Integer.MAX_VALUE;
	        while (end < nums.length) {
	            while (sum < s && end < nums.length) {
	                sum += nums[end];
	                end++;
	            }
	            // move start and log any possible min
	            while (sum >= s && start >= 0) {
	                min = Math.min(min, end - start);
	                sum -= nums[start];
	                start++;
	            }
	        }
	        return min == Integer.MAX_VALUE ? 0 : min;
	    }
	    
}



