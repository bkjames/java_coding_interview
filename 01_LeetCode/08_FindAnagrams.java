package zz05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
	
	  public static void main(String args[])
	    {
	        String txt = "BACDGABCDA";
	        String pat = "ABCD";
	        System.out.println(findAnagrams2(txt, pat));
	    }
	
	
	 public static List<Integer> findAnagrams(String s, String p) {
	        List<Integer> rst = new ArrayList<>();
	        if (s == null || s.length() == 0 || s.length() < p.length()) {
	            return rst;
	        }

	        int[] map_p = new int[26];
	        for (int i = 0; i < p.length(); i++) {
	            map_p[p.charAt(i) - 'A']++;
	        }

	        for (int i = 0; i < s.length() - p.length()+1; i++) {
	            int[] map_s = new int[26];
	            for (int j = 0; j < p.length(); j++) {
	            	System.out.println("i: "+i+" j: "+j+" i+j: "+(i+j));
	            	System.out.println("s.charAt(i+j): "+s.charAt(i+j));
	                map_s[s.charAt(i+j) - 'A']++;
	            }
	            System.out.println();
	            if (isMatch(map_p, map_s)) {
	                rst.add(i);
	            }
	        }
	        return rst;
	    }

	    public static boolean isMatch(int[] arr1, int[] arr2) {
	        for (int i = 0; i < arr1.length; i++) {
	            if (arr1[i] != arr2[i]) {
	                return false;
	            }
	        }
	        return true;
	    }
	  
	  public static List<Integer> findAnagrams2(String s, String p) {
	        List<Integer> rst = new ArrayList<>();
	        if (s == null || s.length() == 0 || s.length() < p.length()) {
	            return rst;
	        }

	        Map<Character, Integer> map = new HashMap<>();
	        for (char c : p.toCharArray()) {
	            map.put(c, map.getOrDefault(c, 0) + 1);
	        }

	        // begin - left of window, end - right of window
	        int begin = 0, end = 0;
	        // The number of distinct characters
	        int counter = map.size();
	        
	        while (end < s.length()) {
	            char c = s.charAt(end);
	            if (map.containsKey(c)){
	                map.put(c, map.get(c) - 1);
	                if (map.get(c) == 0) {
	                    counter--;
	                }
	            }
	            end++;

	            while (counter == 0) {
	                char tempc = s.charAt(begin);
	                if (map.containsKey(tempc)) {
	                    map.put(tempc, map.get(tempc) + 1);
	                    if (map.get(tempc) > 0) {
	                        counter++;
	                    }
	                }

	                if (end - begin == p.length()) {
	                    rst.add(begin);
	                }
	                begin++;
	            }
	        }

	        return rst;
	    }
	  
	  
	  
	  
	
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return rst;
        }

        int[] map_p = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map_p[p.charAt(i) - 'A']++;
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            int[] map_s = new int[26];
            for (int j = 0; j < p.length(); j++) {
                map_s[s.charAt(i+j) - 'A']++;
            }
            if (isMatch(map_p, map_s)) {
                rst.add(i);
            }
        }
        return rst;
    }

    public static boolean isMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}


