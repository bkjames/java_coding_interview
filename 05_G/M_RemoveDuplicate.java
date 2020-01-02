package goo;

import java.util.*;

public class RemoveDuplicate {

	public static void main(String[] args) {
		
		String s = "abbaca";
		RemoveDuplicate a = new RemoveDuplicate();
		System.out.println(a.removeDuplicates2(s));
		
	}
	public String removeDuplicates(String S) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (!dq.isEmpty() && dq.peekLast() == c) { 
                dq.pollLast();
            }else {
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : dq) { sb.append(c); }
        return sb.toString();
    }
	
	
	 public String removeDuplicates2(String S) {
	        StringBuilder sb = new StringBuilder();
	        for (char c : S.toCharArray()) {
	            int size = sb.length();
	            if (size > 0 && sb.charAt(size - 1) == c) { 
	                sb.deleteCharAt(size - 1); 
	            }else { 
	                sb.append(c); 
	            }
	        }
	        return sb.toString();
	    }
}
