package real;

import java.util.Arrays;
import java.util.Comparator;

public class L1_StringSeq {

	public static void main(String[] args) {
//		String[] strs = {"sun", "bed", "car"};

		String[] strs = {"abce", "abcd", "cdx"};
		int n =3;
		L1_StringSeq a = new L1_StringSeq();
		String[] result = a.solution(strs, n);
		a.print(result);
	}
	
	public void print(String[] res) {
		for(String s: res)
			System.out.println(s);
	}
	
	
	public String[] solution(String[] strings, int n) {
		
		Arrays.sort(strings,   new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				
				if(a.charAt(n) > b.charAt(n)) {
				  return 1;
				}else if(a.charAt(n)< b.charAt(n)) {
				  return -1;
				}else {
					return a.compareTo(b);
				}
			}
			
		});
	    return strings;
	  }
}
