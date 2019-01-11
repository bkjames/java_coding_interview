

public class JewelsAndStones {

	
	
	public static void main(String[] args) {
		String J = "aA",  S = "aAAbbbb";
		System.out.println(numJewelsInStones(J, S));
			

	}
	 public static int numJewelsInStones(String J, String S) {
	        int cntJewels = 0;
	        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
	            return cntJewels;
	        }
	        int[] hash = new int[256];
	        for (char ch : S.toCharArray()) {
	        	System.out.println("ch: "+(int)ch);
	        	
	            hash[ch]++;
	        }
	        for (char ch : J.toCharArray()) {
	            if (hash[ch] != 0) {
	            	System.out.println("hash[ch]: "+hash[ch]);
	                cntJewels += hash[ch];
	                hash[ch] = 0;
	            }
	        }
	        return cntJewels;
	    }
}
