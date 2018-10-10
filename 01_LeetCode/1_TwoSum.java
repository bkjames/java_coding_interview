package zz06;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,7,9,11};
		int target =9;
		int[] result = twoSum(nums, target);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int index = map.get(nums[i]);
				result[0] = index+1;
				result[1] = i+1;
			}else {
				map.put(target-nums[i], i);
			}
		}
		return result;
		
	}
}

