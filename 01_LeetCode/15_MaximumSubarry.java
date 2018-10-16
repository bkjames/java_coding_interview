package zcode01;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
	public static int maxSubArray(int[] nums) {
		int newSum = nums[0];
		int max = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			newSum = Math.max(newSum+nums[i], nums[i]);
			max = Math.max(max, newSum);
		}
		return max ;
	}

}
