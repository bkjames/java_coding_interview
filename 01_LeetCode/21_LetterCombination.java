package aExe07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

	
	public static void main(String[] args) {
		String str ="23";
//		System.out.println(letterCombinations(str));
		List<String> list = letterCombinations(str);
		for(String s : list ) {
			System.out.println(s);
		}
		
	}
	
	
	public static List<String> letterCombinations3(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
			}
		}
		return ans;
	}
	
	 public static ArrayList<String> letterCombinations(String digits) {
	        ArrayList<String> result = new ArrayList<String>();

	        if (digits == null || digits.equals("")) {
	            return result;
	        }

	        Map<Character, char[]> map = new HashMap<Character, char[]>();
	        map.put('0', new char[] {});
	        map.put('1', new char[] {});
	        map.put('2', new char[] { 'a', 'b', 'c' });
	        map.put('3', new char[] { 'd', 'e', 'f' });
	        map.put('4', new char[] { 'g', 'h', 'i' });
	        map.put('5', new char[] { 'j', 'k', 'l' });
	        map.put('6', new char[] { 'm', 'n', 'o' });
	        map.put('7', new char[] { 'p', 'q', 'r', 's' });
	        map.put('8', new char[] { 't', 'u', 'v'});
	        map.put('9', new char[] { 'w', 'x', 'y', 'z' });

	        helper(map, digits, new StringBuilder(), result);

	        return result;
	    }

	    private static void helper(Map<Character, char[]> map, String digits, 
	        StringBuilder sb, ArrayList<String> result) {
	        if (sb.length() == digits.length()) {
	            result.add(sb.toString());
	            return;
	        }

	        for (char c : map.get(digits.charAt(sb.length()))) {
	            sb.append(c);
	            helper(map, digits, sb, result);
	            sb.deleteCharAt(sb.length() - 1);
	        }
	    }
	}

