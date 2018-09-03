package coding;



//A Simple Merge based O(n) solution  
//to find median of two sorted arrays 

class Median 
{ 
	public static void main(String[] args)
	{
		int ar1[] = {1,12,15,26,38};
		int ar2[] = {2,13,17,30,45};
		
		int n1 = ar1.length;
		int n2 = ar2.length;
	
		System.out.println("Median is "+findMedianSortedArrays(ar1, ar2));
	}
	
	public static double findMedianSortedArrays(int[] numsA, int[] numsB) {
	        // Assume edge case is safe
	        int n = numsA.length + numsB.length;

	        // Handle even/odd cases
	        if (n % 2 == 0) {
	            return (
	                findKth(numsA, 0, numsB, 0, n / 2) + 
	                findKth(numsA, 0, numsB, 0, n / 2 + 1)
	            ) / 2.0;
	        }
	        return (double)findKth(numsA, 0, numsB, 0, n / 2 + 1);
	    }

	    // Find kth number in two sorted array. k is size
	private static int findKth(int[] numsA, int startA, int[] numsB, int startB, int k) {
	        // check edge case for startA/startB index
	        if (startA >= numsA.length) return numsB[startB + k - 1]; // A exhausted, take kth in B
	        if (startB >= numsB.length) return numsA[startA + k - 1]; // B exhausted, take kth in A

	        // handle final condition k == 1. The two elements will be sorted and the smaller one is kth.
	        if (k == 1) return Math.min(numsA[startA], numsB[startB]);

	        // compare and partition at each [x+(k/2-1)] position
	        int halfKthOfA = startA + k / 2 - 1 < numsA.length ? numsA[startA + k / 2 - 1] : Integer.MAX_VALUE;
	        int halfKthOfB = startB + k / 2 - 1 < numsB.length ? numsB[startB + k / 2 - 1] : Integer.MAX_VALUE;
	        if (halfKthOfA < halfKthOfB) {
	            return findKth(numsA, startA + k / 2, numsB, startB, k - k / 2);
	        } else {
	            return findKth(numsA, startA, numsB, startB + k / 2, k - k / 2);
	        }
	    }
	

} 
