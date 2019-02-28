
public class AddBoldTaginString {

	public static void main(String[] args) {
		String s = "abcxyz123";
		String[] dict = {"abc","123"};
		System.out.println(addBoldTag2(s, dict));
	}
	
	
	
	public static String addBoldTag2(String s, String[] dict) {
	    int n = s.length();
	    boolean[] marked = new boolean[n];
	    for (String word : dict) {
	        int m = word.length();
	        for (int i=0;i<=n-m;i++) { 
	        	System.out.println("value: "+s.substring(i, i + m));
	            if (s.substring(i, i + m).equals(word)) 
	                for (int j=i;j<i+m;j++) marked[j] = true;
	        }
	    }
	    
	    int i = 0;
	    StringBuilder res = new StringBuilder();
	    while (i < n) {
	        if (marked[i]) {             
	          int j = i;
	          while (j < n && marked[j]) j++;
	          res.append("<b>").append(s.substring(i,j)).append("</b>");
	          i = j;                 
	        }
	        else res.append(s.charAt(i++));
	    }
	    return res.toString();   
	    
	}
	
	
	
	public static String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        
        return result.toString();
    }
}
