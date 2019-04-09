package zGoo1;

public class G007_BackspaceCompare {

	public static void main(String[] args) {
		 String S = "ab#c", T = "ad#c";
		 G007_BackspaceCompare a = new G007_BackspaceCompare();
		 System.out.println(a.backspaceCompare(S, T));
	}
	
	
	  public boolean backspaceCompare(String S, String T) {
	        int i = S.length()-1;
	        int j = T.length()-1;
	        int countS = 0;
	        int countT = 0;
	        while (i >= 0 || j >= 0) {
	            while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
	                if (S.charAt(i) == '#') countS++;
	                else countS--;
	                i--;
	            }
	            char left = i < 0 ? '@' : S.charAt(i);
	            while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
	                if (T.charAt(j) == '#') countT++;
	                else countT--;
	                j--;
	            }
	            char right = j < 0 ? '@' : T.charAt(j);
	            if (left != right) return false;
	            i--;
	            j--;
	        }
	        return true;
	    }
	  
	  
	 public static boolean backspaceCompare2(String S, String T) {
	        return trans(S).equals(trans(T));
	    }
	    private static String trans(String str) {
	        StringBuilder sb = new StringBuilder();
	        for (char c : str.toCharArray()) {
	            if (c != '#') { sb.append(c); } // if not '#', append it at the end of sb.
	            else if (sb.length() > 0) { sb.deleteCharAt(sb.length() - 1); } // remove last char in sb, if sb is not empty.
	        }
	        return sb.toString();
	    }
	
}
