package a_20200820;
import java.util.*;

public class A047_3Sum {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		A047_3Sum a = new A047_3Sum();
		System.out.println(a.threeSum_1(nums));
	}
	
	
	 public List<List<Integer>> threeSum_1(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        Arrays.sort(nums);// O(nlogn)
	        int n = nums.length;
	        for (int i = 0; i < n - 2; i++) { // check lo/hi after i
	            if (i > 0 && nums[i] == nums[i - 1]) {
	            	System.out.println("nums["+i+"] "+nums[i]+" nums["+(i-1)+"] "+nums[i-1]);
	            	continue; // check duplicate
	            }

	            int lo = i + 1, hi = n - 1;
	            while (lo < hi) {
	                int sum = nums[i] + nums[lo] + nums[hi];
	                System.out.println("nums["+i+"] "+nums[i]+" nums["+lo+"] "+nums[lo]+" nums["+hi+"] "+nums[hi]);
	                if (sum == 0) {
	                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
	                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
	                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
	                    lo++;
	                    hi--;
	                } else if (sum < 0) {
	                    lo++;
	                } else {
	                    hi--;
	                }
	            }
	        }
	        return result;
	    }
	
	public List<List<Integer>> threeSum1(int[] nums) {        
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i: nums) System.out.print(i + " ");
        System.out.println();
        int l = 0;
        while (l < nums.length - 2) {
            if (nums[l] > 0) break;
            int m = l + 1;
            int r = nums.length - 1;
            while (m < r) {
                System.out.print(nums[l] + " ");
                System.out.print(nums[m] + " ");
                System.out.println(nums[r]);
                int s = nums[l] + nums[m] + nums[r];
                if (s == 0) {
                    ans.add(Arrays.asList(nums[l], nums[m], nums[r]));
                    System.out.println("Zero-sum found!");
                }
                if (s <= 0) {
                    System.out.println("Sum negative or 0; moving m (at " + m + ") right to " + (m+1));
                    while (nums[m] == nums[++m] && m < r)
                    System.out.println("Avoided duplicate; m now at " + (m+1));
                }
                if (s >= 0) {
                    System.out.println("Sum positive or 0; moving r (at "+ r + ") left to " + (r-1));
                    while (nums[r] == nums[--r] && m < r)
                    System.out.println("Avoided duplicate; r now at " + (r-1));
                }
            }
            System.out.println("m == r; moving l (at " + l + ") right to " + (l+1));
            while (nums[l] == nums[++l] && l < nums.length - 2)
                System.out.println("Avoided duplicate; l now at " + (l+1));
        }
        return ans;
    }
	
	
	
	
	
	
	public List<List<Integer>> threeSum(int[] nums) {
	    List<List<Integer>> res = new ArrayList<>();
	    Arrays.sort(nums);
	    for (int i = 0; i + 2 < nums.length; i++) {
//	    	System.out.println("nums["+i+"] "+nums[i]+" nums["+(i-1)+"] "+nums[i-1]);
	        if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
	            continue;
	        }
	        int j = i + 1, k = nums.length - 1;  
	        int target = -nums[i];
	        while (j < k) {
System.out.println("nums["+j+"] "+nums[j]+" nums["+k+"] "+nums[k]+" target "+target);
	            if (nums[j] + nums[k] == target) {
	                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
	                j++;
	                k--;
	                while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
	                while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
	            } else if (nums[j] + nums[k] > target) {
	                k--;
	            } else {
	                j++;
	            }
	        }
	    }
	    return res;
	}
}
