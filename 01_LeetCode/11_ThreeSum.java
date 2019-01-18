package zcode01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public static void main(String[] args) {
		int[] nums = {-1 ,0 ,1, 2 ,-1 ,-4};
		System.out.println(threeSum(nums));
	}
	
    	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length < 3) return result;
		Arrays.sort(nums);
		int i = 0;
		while(i < nums.length - 2) {
		    if(nums[i] > 0) break;
		    int j = i + 1;
		    int k = nums.length - 1;
		    while(j < k) {
			int sum = nums[i] + nums[j] + nums[k];
			if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
			if(sum <= 0) while(nums[j] == nums[++j] && j < k);
			if(sum >= 0) while(nums[k--] == nums[k] && j < k);
		    }
		    while(nums[i] == nums[++i] && i < nums.length - 2);
		}
		return result;
	    }
}
	
	
	
	
	
	public static List<List<Integer>> threeSum(int[] nums) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
	    if(nums == null || nums.length<3)
	        return result;
	 
	    Arrays.sort(nums);
	 
	    for(int i=0; i<nums.length-2; i++){
	        if(i==0 || nums[i] > nums[i-1]){
	            int j=i+1;
	            int k=nums.length-1;
	 
	            while(j<k){
	            	System.out.println("i:"+i+" j:"+j+" k:"+k);
	                if(nums[i]+nums[j]+nums[k]==0){
	                	System.out.println("$$i:"+i+" j:"+j+" k:"+k);
	                    List<Integer> l = new ArrayList<Integer>();
	                    l.add(nums[i]);
	                    l.add(nums[j]);
	                    l.add(nums[k]);
	                    result.add(l);
	 
	                    j++;
	                    k--;
	 
	                    //handle duplicate here
	                    while(j<k && nums[j]==nums[j-1])
	                        j++;
	                    while(j<k && nums[k]==nums[k+1])
	                        k--;
	 
	                }else if(nums[i]+nums[j]+nums[k]<0){
	                    j++;
	                }else{
	                    k--;
	                }
	            }
	        }
	 
	    }
	 
	    return result;
	}
}
