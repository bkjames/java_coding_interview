package aF01;

public class ImpleStr {

	
	
	public static void main(String[] args) {
		

		String aa = "hello" ;
		String bb = "ll";
		System.out.println(strStr(aa, bb));
	}
	
	public int strStr1(String haystack, String needle) {
	    return haystack.indexOf(needle);
	}

	public static int strStr(String haystack, String needle) {
	    if (haystack == null || needle == null)
	        return -1;
	    int l1 = haystack.length();
	    int l2 = needle.length();
	    for (int i = 0; i < l1-l2+1; i++) {
	        int count = 0;
	        while (count < l2 && haystack.charAt(i+count) == needle.charAt(count))
//	        	System.out.println(haystack.charAt(i+count)+" "+needle.charAt(count));
	            count++;
	        if (count == l2)
	            return i;
	    }
	    return -1;
	}
}
