package Inter;

public class CountPrime {
	
	public static void main(String[] args) {
		int n =10;
		System.out.println(countPrimes(n));
	}
	public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
        	System.out.println("i: "+i);
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                	System.out.println("i "+i+" j "+j);
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }

}
