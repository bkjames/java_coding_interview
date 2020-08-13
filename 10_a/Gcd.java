package a_20200813;

public class Gcd {
	
	public static void main(String[] args) {
		
//		String str1 = "ABABAB", str2 = "ABAB";
		String str1 = "ABABAC", str2 = "ABAB";
		Gcd a = new Gcd();
		System.out.println(a.gcdOfStrings(str1, str2));
		System.out.println(a.gcdOfStrings1(str1, str2));
		
	}
	
	
	 public String gcdOfStrings1(String str1, String str2) {
	        String s = str1.length() < str2.length() ? str1 : str2;
	        for (int d = 1, end = s.length(); d <= end; ++d) {
	            if (end % d != 0) { 
	            	continue; 
	            } // only if length of s mod d is 0, can sub be common divisor.
	            String sub = s.substring(0, end / d);
	            if (str1.replace(sub, "").isEmpty() && str2.replace(sub, "").isEmpty()) {
	                return sub;
	            }
	        }
	        return "";
	    }
	 
	 
	public String gcdOfStrings(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int d = gcd(m, n);
        String s = str1.substring(0, d), str = str1 + str2;
        for (int i = 0; i < m + n; i += d) {
            if (!str.startsWith(s, i)) 
                return "";        
        }
        return s;
    }
    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

}
