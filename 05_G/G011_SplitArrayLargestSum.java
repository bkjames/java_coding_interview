package zGoo1;

public class G011_SplitArrayLargestSum {

	public static void main(String[] args) {
		int[] nums = {7,2,5,10,8};
		int m = 2;
		G011_SplitArrayLargestSum a = new G011_SplitArrayLargestSum();
		System.out.println(a.splitArray(nums, m));
	}
	
	//1
	 public int splitArray(int[] nums, int m) {
	        int max = 0; long sum = 0;
	        for (int num : nums) {
	            max = Math.max(num, max);
	            sum += num;
	        }
	        if (m == 1) return (int)sum;
	        //binary search
	        long l = max; long r = sum;
	        while (l <= r) {
	            long mid = (l + r)/ 2;
	            if (valid(mid, nums, m)) {
	                r = mid - 1;
	            } else {
	                l = mid + 1;
	            }
	        }
	        return (int)l;
	    }
	    public boolean valid(long target, int[] nums, int m) {
	        int count = 1;
	        long total = 0;
	        for(int num : nums) {
	            total += num;
	            if (total > target) {
	                total = num;
	                count++;
	                if (count > m) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	    
	    

	    private int ans;
	    private int n, m;
	    
	    public int splitArray2(int[] nums, int M) {
	        ans = Integer.MAX_VALUE;
	        n = nums.length;
	        m = M;
	        dfs(nums, 0, 0, 0, 0);
	        return ans;
	    }
	    
	    private void dfs(int[] nums, int i, int cntSubarrays, int curSum, int curMax) {
	        if (i == n && cntSubarrays == m) {
	            ans = Math.min(ans, curMax);
	            return;
	        }
	        if (i == n) {
	            return;
	        }
	        if (i > 0) {
	            dfs(nums, i + 1, cntSubarrays, curSum + nums[i], Math.max(curMax, curSum + nums[i]));
	        }
	        if (cntSubarrays < m) {
	            dfs(nums, i + 1, cntSubarrays + 1, nums[i], Math.max(curMax, nums[i]));
	        }
	    }
	    
	    
	
	
}
