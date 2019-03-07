
package Problems;

public class G009_PeakIndexinaMountainArray {
	
	public static void main(String[] args) {
		int[] nums = {0,2,1,0};
		peakIndexInMountainArray_logn(nums);
	}
	 public static int peakIndexInMountainArray(int[] A) {
	        for (int i = 1; i < A.length; ++i) {
	            if (A[i] > A[i + 1]) { return i; }
	        }
	        return -1; // no peak.
	    }
	 
	 public static int peakIndexInMountainArray_logn(int[] A) {
	        int lo = 0;
	        int hi = A.length - 1;
	        while (lo < hi) {
	            int mid = (lo + hi) / 2;
	            if (A[mid] < A[mid + 1]) { // peak index is after mid.
	                lo = mid + 1;
	            }else if (A[mid -1] > A[mid]) { // peak index is before mid.
	                hi = mid;
	            }else { // peak index is mid.
	                return mid;
	            }
	        }
	        return -1; // no peak.
	    }
	 
	 public int peakIndexInMountainArray_logn_short(int[] A) {
	        int lo = 0;
	        int hi = A.length - 1;
	        while (lo < hi) {
	            int mid = (lo + hi) / 2;
	            if (A[mid] < A[mid + 1]) { lo = mid + 1; } // peak index is after mid.
	            else{ hi = mid; } // peak index <= mid.
	        }
	        return lo; // found peak index.
	    }
	
	
}
