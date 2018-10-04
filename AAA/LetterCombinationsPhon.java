package zz04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsPhon {

	public static void main(String[] args) {
		String str ="23";
//		System.out.println(letterCombinations(str));
		List<String> list = letterCombinations(str);
		for(String s : list ) {
			System.out.println(s);
		}
		
	}
	
	public static List<String> letterCombinations(String digits) {
	    HashMap<Integer, String> map = new HashMap<Integer, String>();
	    map.put(2, "abc");
	    map.put(3, "def");
	    map.put(4, "ghi");
	    map.put(5, "jkl");
	    map.put(6, "mno");
	    map.put(7, "pqrs");
	    map.put(8, "tuv");
	    map.put(9, "wxyz");
	    map.put(0, "");
	 
	    ArrayList<String> result = new ArrayList<String>();
	 
	    if(digits == null || digits.length() == 0)
	        return result;
	 
	    ArrayList<Character> temp = new ArrayList<Character>();
	    getString(digits, temp, result, map);
	 
	    return result;
	}
	 
	public static void getString(String digits, ArrayList<Character> temp, ArrayList<String> result,  HashMap<Integer, String> map){
	    if(digits.length() == 0){
	        char[] arr = new char[temp.size()];
	        for(int i=0; i<temp.size(); i++){
	            arr[i] = temp.get(i);
	        }
	        result.add(String.valueOf(arr));
	        return;
	    }
	 
	    Integer curr = Integer.valueOf(digits.substring(0,1));
	    String letters = map.get(curr);
	    System.out.println("letters: "+letters);
	    for(int i=0; i<letters.length(); i++){
	    	System.out.println("letters.charAt("+i+"): "+letters.charAt(i));
	        temp.add(letters.charAt(i));
	        getString(digits.substring(1), temp, result, map);
	        temp.remove(temp.size()-1);
	    }
	}
}
