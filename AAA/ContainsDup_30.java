package array;

import java.util.HashSet;

public class ContainsDup_30 {
	
	
	// Driver method to test above method
    public static void main (String[] args)
    {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        if (containsDuplicate(arr))
           System.out.println("Yes");
        else
           System.out.println("No");
    }
	
	
	
	public static boolean containsDuplicate(int[] nums) {
	    if(nums==null || nums.length==0)
	        return false;
	 
	    HashSet<Integer> set = new HashSet<Integer>();
	    for(int i: nums){
	        if(!set.add(i)){
	            return true;
	        }
	    }
	 
	    return false;
	}

}



