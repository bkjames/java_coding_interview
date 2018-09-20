package aExe01;

public class ContainerMostWater {

	
	
	
	public static void main(String[] args) {
		int[] nums = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(nums));
		
	}
	
	public static int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
	 
		int max = 0;
		int left = 0;
		int right = height.length - 1;
	 
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
	 
		return max;
	}
}
