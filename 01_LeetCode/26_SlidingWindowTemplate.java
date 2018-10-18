package code02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SlidingWindowTemplate {

	public static void main(String[] args) {
		String s= "ababccaba";
		String p = "ab";
//		System.out.println(slidingWindowTemplate(s,p));
		List<Integer> val = findAnagrams(s,p);
		for(Integer aa : val) {
			System.out.println(aa);
		}
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
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
}
