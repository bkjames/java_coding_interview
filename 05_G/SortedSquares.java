package zGoogle;

public class SortedSquares {

	public static void main(String[] args) {
		int[] nums = {-4,-1,0,3,10};
		int[] result = sortedSquares(nums);
		print(result);
	}
	
	public static void print(int[] result) {
		for(int i : result) System.out.print(i+" ");
	}
	  public static int[] sortedSquares(int[] A) {
	        int n = A.length;
	        int[] result = new int[n];
	        int i = 0, j = n - 1;
	        for (int p = n - 1; p >= 0; p--) {
	            if (Math.abs(A[i]) > Math.abs(A[j])) {
	                result[p] = A[i] * A[i];
	                i++;
	            } else {
	                result[p] = A[j] * A[j];
	                j--;
	            }
	        }
	        return result;
	    }
}
