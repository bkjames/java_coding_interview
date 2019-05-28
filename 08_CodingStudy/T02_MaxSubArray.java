package Top50;

public class T02_MaxSubArray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
	public static int maxSubArray_dp(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}
	
	public static int maxSubArray(int[] nums) {
		int newSum = nums[0];
		int max = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			System.out.println("newSum+nums["+i+"]: "+(newSum+nums[i])+" nums["+i+"]: "+nums[i]+" newSum:"+newSum);
			newSum = Math.max(newSum+nums[i], nums[i]);
			System.out.println("max: "+max+" newSum: "+newSum);
			max = Math.max(max, newSum);
			System.out.println("final max: "+max);
			System.out.println();
		}
		return max ;
	}
}
