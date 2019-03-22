package Problems;

public class TG37_BurstBalloons {

	public static void main(String[] args) {
		int[] nums = {3,1,5,8};
		System.out.println(maxCoins(nums));
	}
	
	
	public static int maxCoins(int[] nums) {
		
		int n = nums.length;
		if(n==0) return 0;
		
		int[][] opt = new int[n][n];
		
		for(int len=0; len<n; ++len) {
			for(int i=0; i+len<n; ++i) {
				int j= i+len;
				for( int k=i; k<=j; ++k) {
					int left_num =i==0 ? 1:nums[i-1];
					int right_num = j==n-1 ? 1:nums[j+1];
					
					int left_opt =k ==i? 0 : opt[i][k-1];
					int right_opt =k ==j ? 0: opt[k+1][j];
					
					System.out.println("opt["+i+"]["+j+"]"+"k: "+k+" left_num: "+left_num+" nums[k]: "+nums[k]+" right_num: "+right_num+" left_opt: "+left_opt
							+" right_opt: "+right_opt+" "+(left_num*nums[k]*right_num +left_opt+right_opt));
					
					opt[i][j]= Math.max(opt[i][j], left_num*nums[k]*right_num +left_opt+right_opt);
				}
			}
		}
		return opt[0][n-1];
		
	}
	
	public static int maxCoins2(int[] nums) {
	    // Extend list with head and tail (both are 1), index starts at 1
	    int array[] = new int[nums.length + 2];
	    array[0] = 1;
	    array[array.length-1] = 1;
	    for (int i = 0; i < nums.length; i++) {
	        array[i+1] = nums[i];
	    }

	    // Initialize DP arrays, 1 index based
	    int dp[][] = new int[array.length][array.length]; //dp[i][j] stands for max coins at i step, burst j
	    for (int i =0; i < array.length; i++) {
	        for (int j = 0; j < array.length; j++) {
	            dp[i][j] = 0;
	        }
	    }

	    for (int i=1; i< array.length-1; i++) {
	        for (int j=i; j >=1; j--) {
	            // k as last
	            for (int k=j; k <= i; k++) {
	                dp[j][i] = Math.max(array[j-1]*array[k]*array[i+1] + dp[j][k-1] + dp[k+1][i], dp[j][i]);
	            }
	        }
	    }

	    return dp[1][array.length-2];
	}
}
