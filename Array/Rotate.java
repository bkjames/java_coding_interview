package coding;

public class rotate {
	
	public static void main(String[] args) {
		rotate r = new rotate();
		int[] nums = {1,2,3,4,5,6,7};
		int k =3;
		r.rotate3(nums, k);
	}
	
	public void rotate(int [] nums, int k) {
		
		int len = nums.length;
		System.out.println("len : "+len);
		
		if(k >  nums.length) k = k% nums.length;
		int[] result  = new int[nums.length];
		for(int i=0; i<k; i++) {
			result[i] = nums[nums.length-k+i];
		}
		
		int j =0;
		for(int i=k ; i< nums.length; i++) {
			result[i] = nums[j];
			j++;
		}
//		System.arraycopy(result, 0, nums, 0, nums.length);

		
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
	
	public void rotate2(int[] nums, int k) {
		
		if(nums== null || k <0) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		for(int i =0; i< k; i++) {
			for(int j =nums.length-1; j>0 ; j--) {
				int temp = nums[j];
				nums[j] = nums[j-1];
				nums[j-1] = temp;
			}
		}
		for(int i=0; i<nums.length; i++) {
			System.out.println("rotate2 : "+nums[i]);
		}
	}
	
	public void rotate3(int[] nums, int k) {
		
		if(nums== null || k <0 || nums ==null) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		if(k >  nums.length) k = k% nums.length;
		
		int a = nums.length - k ;
		
		reverse(nums, 0, a-1); //0, 3
		reverse(nums, a, nums.length-1); // 3 6
		reverse(nums, 0, nums.length-1);//0 6
//		
	
		
		for(int i=0; i<nums.length; i++) {
			System.out.println("rotate2 : "+nums[i]);
		}
	}
	
	public void reverse(int[] nums , int left, int right) {
		if(nums == null || nums.length ==1)
	    return ;
		
		while(left<right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
		
	}

}
