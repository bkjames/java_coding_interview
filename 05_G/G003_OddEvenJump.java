package p1;

import java.util.TreeMap;

public class G003_OddEvenJump {

	public static void main(String[] args) {
		int[] nums = {10,13,12,14,15};
		System.out.println(oddEvenJumps_DP(nums));
	}
	
	 public static int oddEvenJumps_DP(int[] A) {
	        int n = A.length;
	        TreeMap<Integer, Integer> map = new TreeMap<>();
	        boolean[][] dp = new boolean[n][2];
	        dp[n - 1][0] = true;
	        dp[n - 1][1] = true;
	        map.put(A[n - 1], n - 1);
	        int res = 1;

	        for (int i = n - 2; i >= 0; i--) {
	            // Odd step
	            Integer nextGreater = map.ceilingKey(A[i]);
	            if (nextGreater != null) {
	                dp[i][0] = dp[map.get(nextGreater)][1];
	            }
	            // Even step
	            Integer nextSmaller = map.floorKey(A[i]);
	            if (nextSmaller != null) {
	                dp[i][1] = dp[map.get(nextSmaller)][0];
	            }
	            map.put(A[i], i);

	            res += dp[i][0] ? 1 : 0;
	        }

	        return res;
	    }
	
	    public static int oddEvenJumps(int[] A) {
	        int N = A.length;
	        if (N <= 1) return N;
	        boolean[] odd = new boolean[N];
	        boolean[] even = new boolean[N];
	        odd[N-1] = even[N-1] = true;

	        TreeMap<Integer, Integer> vals = new TreeMap();
	        vals.put(A[N-1], N-1);
	        for (int i = N-2; i >= 0; --i) {
	            int v = A[i];
	            if (vals.containsKey(v)) {
	                odd[i] = even[vals.get(v)];
	                even[i] = odd[vals.get(v)];
	            } else {
	                Integer lower = vals.lowerKey(v);
	                Integer higher = vals.higherKey(v);

	                if (lower != null)
	                    even[i] = odd[vals.get(lower)];
	                if (higher != null) {
	                    odd[i] = even[vals.get(higher)];
	                }
	            }
	            vals.put(v, i);
	        }

	        int ans = 0;
	        for (boolean b: odd)
	            if (b) ans++;
	        return ans;
	    }
	
	
}
