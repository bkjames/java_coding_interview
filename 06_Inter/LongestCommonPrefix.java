package Inter;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		
//		String[] str = {"flower","flow","flight"};
		String[] str = {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(str));
	}
	public static String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    System.out.println("prefix: "+prefix);
	    for (int i = 1; i < strs.length; i++) {
	    	System.out.println("aa: "+strs[i]);
	    	System.out.println(strs[i].indexOf(prefix));
	    	System.out.println("bb: "+strs[i]+" "+prefix);
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            System.out.println("substring: "+prefix);
	            if (prefix.isEmpty()) return "";
	        }
	    }
	    return prefix;
	}
}
