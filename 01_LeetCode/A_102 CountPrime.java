
public class CountPrime {
	
	
	public static void main(String[] args) {
		int val = new CountPrime().countPrimes(10);
		System.out.println("val: "+val);
	}
	 public int countPrimes(int n) {
	        boolean[] notPrime = new boolean[n];
	        int count = 0;
	        for (int i = 2; i < n; i++) {
	        	
	            if (notPrime[i] == false) {
	            	System.out.println("i: "+i);
	                count++;
	                for (int j = 2; i*j < n; j++) {
	                    notPrime[i*j] = true;
	                }
	            }
	        }
	        
	        return count;
	    }
}
