
package Ama;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
	
	public static void main(String[] args) {
		
		String J="aA";
		String S = "aAAbbbb";
		
		System.out.println(numJewelIsInStones(J,S));
		System.out.println(numJewelsInStones(J,S));
	}
	  public static int numJewelsInStones(String J, String S) {
	        Set<Character> Jset = new HashSet();
	        for (char j: J.toCharArray())
	            Jset.add(j);

	        int ans = 0;
	        for (char s: S.toCharArray())
	            if (Jset.contains(s))
	                ans++;
	        return ans;
	    }
	  
	  
		public static int numJewelIsInStones(String J, String S) {
			
			int cntJewels =0;
			if(J==null|| J.length()==0 || S==null|| S.length()==0) {
				return cntJewels;
			}
			
			int[] hash = new int[256];
			for(char ch: S.toCharArray()) {
				System.out.println("S ch: "+(int)ch);
				hash[ch]++;
			}
			
			for(char ch: J.toCharArray()) {
				if(hash[ch]!=0) {
					System.out.println("J ch: "+(int)ch);
					System.out.println("hash[ch]: "+hash[ch]);
					cntJewels += hash[ch];
					
				}
				
			}
			
//			print(hash);
			return cntJewels;

		}
		
		public static void print(int[] hash) {
			
			for(int i=0; i<hash.length; i++) {
				System.out.println("i: "+i+" "+hash[i]);
			}
		}
	

}

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
