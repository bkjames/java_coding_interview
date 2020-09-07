package ama03;

public class A108_MissingNumber {

	public static void main(String[] args) {
		 int[] nums = {3,0,1};
		 System.out.println(missingNumber(nums));
	}
	
	
//	1.XOR
	public static int missingNumber(int[] nums) { //xor
	    int res = nums.length;
	    for(int i=0; i<nums.length; i++){
	        res ^= i;
	        res ^= nums[i];
	    }
	    return res;
	}
	
//	2.SUM
	public static int missingNumber(int[] nums) { //sum
	    int len = nums.length;
	    int sum = (0+len)*(len+1)/2;
	    for(int i=0; i<len; i++)
	        sum-=nums[i];
	    return sum;
	}
	
//	3.Binary Search
	public int missingNumber(int[] nums) { //binary search
	    Arrays.sort(nums);
	    int left = 0, right = nums.length, mid= (left + right)/2;
	    while(left<right){
	        mid = (left + right)/2;
	        if(nums[mid]>mid) right = mid;
	        else left = mid+1;
	    }
	    return left;
	}
	
	
	
	public static int missingNumber(int[] nums) {

	    int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
			System.out.println("aaaa xor: "+xor+ " i "+i);
		}
        System.out.println("xor: "+xor+ " i "+i);
		return xor ^ i;
	}
//	
//	
//	
//	public int missingNumber2(int[] nums) {
//        int n = nums.length;
//        int total = n * (n + 1) / 2;
//        int sum = 0;
//        for(int num : nums) {
//            sum += num;
//        }
//        return total - sum;
//    }
}
