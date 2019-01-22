package zz01;

public class LongestPalindrominSubstring {
	
	public static void main(String args[])
	{
		System.out.println(longestPalindrome("bananas"));
//		System.out.println(LPS("bbbb"));
	}	
		
	public static String longestPalindrome(String s) {
		if (s.isEmpty()) 
			return null;
		if (s.length() == 1) 
			return s;

		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {

	// get longest palindrome with center of i
		String tmp = helper(s, i, i);
		if (tmp.length() > longest.length()) {
			longest = tmp;
		}

	// get longest palindrome with center of i, i+1
		tmp = helper(s, i, i + 1);
	    	if (tmp.length() > longest.length()) {
	    		longest = tmp;
	    	}
		}
		return longest;
	}

	public static String helper(String s, int begin, int end) {

		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {

			begin--;
			end++;
		}

		return s.substring(begin + 1, end);
	}
}

  public static String LPS(String s) {
			  int n = s.length();
			  int palindromeBeginsAt = 0; //index where the longest palindrome begins
			  int max_len = 1;//length of the longest palindrome
			  boolean palindrome[][] = new boolean[n][n]; //boolean table to store palindrome truth
			  
			  //Trivial case: single letter palindromes
			  for (int i = 0; i < n; i++) {
				  palindrome[i][i] = true;
			  }
			  
			  //Finding palindromes of two characters.
			  for (int i = 0; i < n-1; i++) {
//				  System.out.println("i "+i+" i+1 "+(i+1));
//				  System.out.println("s.charAt(i) "+s.charAt(i)+" s.charAt(i+1) "+s.charAt(i+1));
			    if (s.charAt(i) == s.charAt(i+1)) {
			      System.out.println("s.charAt(i) "+s.charAt(i)+" s.charAt(i+1) "+s.charAt(i+1));
			      palindrome[i][i+1] = true;
			      palindromeBeginsAt = i;
			      max_len = 2;
			    }
			  }
			  
			  //Finding palindromes of length 3 to n and saving the longest
			  for (int curr_len = 3; curr_len <= n; curr_len++) {
			    for (int i = 0; i < n-curr_len+1; i++) {
			      int j = i+curr_len-1;
			  	  System.out.println("i "+(i)+" j "+(j));
			      if (s.charAt(i) == s.charAt(j) //1. The first and last characters should match 
			    	  && palindrome[i+1][j-1]) //2. Rest of the substring should be a palindrome
			      {
			    	System.out.println("i+1 "+(i+1)+" j+1 "+(j+1));
			    	palindrome[i][j] = true; 
			        palindromeBeginsAt = i;
			        max_len = curr_len;
			      }
			    }
			  }
				System.out.println(palindromeBeginsAt+"  "+ (max_len + palindromeBeginsAt));
			  return s.substring(palindromeBeginsAt, max_len + palindromeBeginsAt);
			}

		public static void main(String args[])
		{
			System.out.println(LPS("bananas"));
//			System.out.println(LPS("bbbb"));
		}
	}
