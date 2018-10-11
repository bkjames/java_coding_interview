package zz05;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
	public static void main(String[] args) {
//		String str = "abcabcdbb";
		String str = "pwwkew";
		System.out.println(longestSub(str));
	}
	
	public static int  longestSub(String s) {
		if(s==null || s.length()==0) return 0;
		
		int result =0;
		int k =0;
		HashSet<Character> set = new HashSet<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!set.contains(c)) {
				set.add(c);
				result = Math.max(result, set.size());
			}else {
				while(k<i) {
					if(s.charAt(k) ==c) {
						k++;
						break;
					}else {
						set.remove(s.charAt(k));
						k++;
					}
				}
			}
		}
		return result;
	}
}
