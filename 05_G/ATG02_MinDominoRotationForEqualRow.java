package p3;

public class G235_MinDominoRotationForEqualRow {

	public static void main(String[] args) {
		int[] A = {2,1,2,4,2,2}, B = {5,2,6,2,3,2};
		System.out.println(minDominoRotations(A,B));
	}
	 public static int minDominoRotations(int[] A, int[] B) {
	        if (A.length != B.length) { return -1; }
	        int[] countA = new int[7]; // countA[i] records the occurrence of i in A.
	        int[] countB = new int[7]; // countB[i] records the occurrence of i in B.
	        int[] same = new int[7]; // same[k] records the occurrence of k, where k == A[i] == B[i].
	        for (int i = 0; i < A.length; ++i) {
	            ++countA[A[i]];
	            ++countB[B[i]];
	            System.out.println(countA);
	            if (A[i] == B[i]) { 
	            	++same[A[i]]; 
	            }
	        }
	        for (int i = 1; i < 7; ++i) {
	            if (countA[i] + countB[i] - same[i] >= A.length) {
	                return Math.min(countA[i], countB[i]) - same[i];
	            }
	        }
	        return -1;
	    }
}
