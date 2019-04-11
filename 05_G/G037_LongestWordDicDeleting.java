package zGoo1;
import java.util.*;
public class G037_LongestWordDicDeleting {

	public static void main(String[] args) {
		String s = "abpcplea";
//		List<String> d = {"ale","apple","monkey","plea"};
		List<String> d = new ArrayList<>();
		d.add("ale");
		d.add("apple");
		d.add("monkey");
		d.add("plea");
		G037_LongestWordDicDeleting a = new G037_LongestWordDicDeleting();
		System.out.println(a.findLongestWord(s, d));
		

	}
	 public String findLongestWord(String s, List<String> d) {
	        if (s.length() == 0 || d.size() == 0) return "";
	        
	        Collections.sort(d, (a, b) -> {
	           if (a.length() != b.length()) return b.length() - a.length();
	           return a.compareTo(b);
	        });
	        
	        for (String p : d) {
	            if (s.length() < p.length()) continue;
	            if (isSubSeq(s, p)) return p;
	        }
	        
	        return "";
	    }
	    
	    private boolean isSubSeq(String s, String p) {
	        int i = 0, j = 0;
	        while (i < s.length() && j < p.length()) {
	            if (s.charAt(i) == p.charAt(j)) {
	                i++; j++;
	            }
	            else {
	                i++;
	            }
	        }
	        return j == p.length();
	    }
}
