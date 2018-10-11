package zExercise01;

public class MedianSortedArray {
	
	
	public static void main(String[] args)
	{
		int ar1[] = {1,12,15,26,38};
		int ar2[] = {2,13,17,30,45};
		
		int n1 = ar1.length;
		int n2 = ar2.length;
	
		System.out.println("Median is "+findMedianSortedArrays(ar1, ar2));
	}
	
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int total = nums1.length+nums2.length;
	    if(total%2==0){
	        return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
	    }else{
	        return findKth(total/2+1, nums1, nums2, 0, 0);
	    }
	}
	 
	public static int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
		
		System.out.println("totalLength: "+k+" s1: "+s1+" s2: "+ s2);
	    if(s1>=nums1.length)
	        return nums2[s2+k-1];
	 
	    if(s2>=nums2.length)
	        return nums1[s1+k-1];
	 
	    if(k==1)
	        return Math.min(nums1[s1], nums2[s2]);
	 
	    int m1 = s1+k/2-1;
	    int m2 = s2+k/2-1;
	 
	    int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;    
	    int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;
	    
	    System.out.println("mid1: "+mid1+" mid2: "+mid2);
	    System.out.println("");
	 
	    if(mid1<mid2){
	        return findKth(k-k/2, nums1, nums2, m1+1, s2);
	    }else{
	        return findKth(k-k/2, nums1, nums2, s1, m2+1);
	    }
	}

}
