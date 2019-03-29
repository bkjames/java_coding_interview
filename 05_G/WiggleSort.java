
public class WiggleSort {

	
	public static void main(String[] args) {
		int[] nums = {3,5,2,1,6,4};
		wiggleSort(nums);
		for(int n : nums)
			System.out.println(n);
	}
	   public static void wiggleSort(int[] nums) {
	        for(int i=0;i<nums.length;i++)
	            if(i%2==1){
	               if(nums[i-1]>nums[i]) swap(nums, i);
	            }else if(i!=0 && nums[i-1]<nums[i]) swap(nums, i);
	    }
	    public static void swap(int[] nums, int i){
	          int tmp=nums[i];
	          nums[i]=nums[i-1];
	          nums[i-1]=tmp;
	    }
}

   public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
            }
    }
