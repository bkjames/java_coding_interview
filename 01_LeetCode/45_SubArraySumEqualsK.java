package coding;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

	public static void main(String[] args) {
		int[] nums = {3,4,7,2,-3,1,4,2};
		int k = 7;
		System.out.println(subarraySum(nums, k));
		System.out.println(subarraySum2(nums, k));
	}
	
	
	public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
            	System.out.println("00start: "+start+" end: "+end+" sum: "+sum);
                sum+=nums[end];
                if (sum == k) {
                	System.out.println("start: "+start+" end: "+end+" sum: "+sum+" k:"+k);
                    count++;
                }
            }
        }
        return count;
    }
	
	 public static int subarraySum(int[] nums, int k) {
	        if (nums == null || nums.length == 0) {
	            return -1;
	        }

	        Map<Integer, Integer> map = new HashMap<>();
	        // Initailize the values
	        map.put(0, 1);  // very important
	        int preSum = 0;
	        int count = 0;

	        for (int i = 0; i < nums.length; i++) {
	            preSum += nums[i];
	            if (map.containsKey(preSum - k)) {
	                count += map.get(preSum - k);
	            }
	            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
	        }

	        return count;
	    }
	
}
