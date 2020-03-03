package p3;

public class G235_MinDominoRotationForEqualRow {

	public static void main(String[] args) {
		int[] A = {2,1,2,4,2,2}, 
			  B = {5,2,6,2,3,2};
		G235_MinDominoRotationForEqualRow a = new G235_MinDominoRotationForEqualRow();
		System.out.println(a.minDominoRotations(A, B));
	}
	 public int minDominoRotations(int[] A, int[] B) {
	        int[] countA = new int[7], countB = new int[7], same = new int[7];
	        int n = A.length;
	        for (int i = 0; i < n; ++i) {
	            countA[A[i]]++;
	            countB[B[i]]++;
	            if (A[i] == B[i])
	                same[A[i]]++;
	        }
	        for (int i  = 1; i < 7; ++i)
	            if (countA[i] + countB[i] - same[i] == n)
	                return n - Math.max(countA[i], countB[i]);
	        return -1;
	    }
}
